package net.guwy.hbm.blocks.machines.brick_furnace;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.guwy.hbm.util.AshUtil;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBrickFurnaceBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {

    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_FUEL = 1;
    protected static final int SLOT_RESULT = 2;
    protected static final int SLOT_ASH = 3;
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1, 3};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    public static final int DATA_LIT_TIME = 0;
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int DATA_ASH_COAL = 4;
    public static final int DATA_ASH_WOOD = 5;
    public static final int DATA_ASH_MISC = 6;
    public static final int NUM_DATA_VALUES = 7;
    public static final int COOK_TIME_STANDARD = 200;
    public static final int COOK_COOL_SPEED = 2;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;
    protected NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;
    int ashLevelWood;
    int ashLevelCoal;
    int ashLevelMisc;
    public static final int ASH_THRESHOLD = 2000;
    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int index) {
            switch (index) {
                case DATA_LIT_TIME:
                    if (litDuration > Short.MAX_VALUE) {
                        // Neo: preserve litTime / litDuration ratio on the client as data slots are synced as shorts.
                        return net.minecraft.util.Mth.floor(((double) litTime / litDuration) * Short.MAX_VALUE);
                    }

                    return AbstractBrickFurnaceBlockEntity.this.litTime;
                case DATA_LIT_DURATION:
                    return Math.min(AbstractBrickFurnaceBlockEntity.this.litDuration, Short.MAX_VALUE);
                case DATA_COOKING_PROGRESS:
                    return AbstractBrickFurnaceBlockEntity.this.cookingProgress;
                case DATA_COOKING_TOTAL_TIME:
                    return AbstractBrickFurnaceBlockEntity.this.cookingTotalTime;
                case DATA_ASH_COAL:
                    return AbstractBrickFurnaceBlockEntity.this.ashLevelCoal;
                case DATA_ASH_WOOD:
                    return AbstractBrickFurnaceBlockEntity.this.ashLevelWood;
                case DATA_ASH_MISC:
                    return AbstractBrickFurnaceBlockEntity.this.ashLevelMisc;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case DATA_LIT_TIME:
                    AbstractBrickFurnaceBlockEntity.this.litTime = value;
                    break;
                case DATA_LIT_DURATION:
                    AbstractBrickFurnaceBlockEntity.this.litDuration = value;
                    break;
                case DATA_COOKING_PROGRESS:
                    AbstractBrickFurnaceBlockEntity.this.cookingProgress = value;
                    break;
                case DATA_COOKING_TOTAL_TIME:
                    AbstractBrickFurnaceBlockEntity.this.cookingTotalTime = value;
                case DATA_ASH_COAL:
                    AbstractBrickFurnaceBlockEntity.this.ashLevelCoal = value;
                case DATA_ASH_WOOD:
                    AbstractBrickFurnaceBlockEntity.this.ashLevelWood = value;
                case DATA_ASH_MISC:
                    AbstractBrickFurnaceBlockEntity.this.ashLevelMisc = value;
            }
        }

        @Override
        public int getCount() {
            return NUM_DATA_VALUES;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<SingleRecipeInput, ? extends AbstractCookingRecipe> quickCheck;

    public static HashMap<Item, Integer> burnSpeedBonus = new HashMap();
    static {
        burnSpeedBonus.put(Items.CLAY_BALL, 4);
        burnSpeedBonus.put(NTMResourcesNParts.FIRECLAY_BALL.get(), 4);
        burnSpeedBonus.put(Items.NETHERRACK, 4);
    }



    protected AbstractBrickFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState, RecipeType<? extends AbstractCookingRecipe> recipeType) {
        super(type, pos, blockState);
        this.quickCheck = RecipeManager.createCheck((RecipeType<AbstractCookingRecipe>)recipeType);
        this.recipeType = recipeType;
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        this.litTime = tag.getInt("BurnTime");
        this.cookingProgress = tag.getInt("CookTime");
        this.cookingTotalTime = tag.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.items.get(SLOT_FUEL));
        CompoundTag compoundtag = tag.getCompound("RecipesUsed");
        for (String s : compoundtag.getAllKeys()) {
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }

        this.ashLevelWood = tag.getInt("AshLevelWood");
        this.ashLevelCoal = tag.getInt("AshLevelCoal");
        this.ashLevelMisc = tag.getInt("AshLevelMisc");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("BurnTime", this.litTime);
        tag.putInt("CookTime", this.cookingProgress);
        tag.putInt("CookTimeTotal", this.cookingTotalTime);
        ContainerHelper.saveAllItems(tag, this.items, registries);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundtag.putInt(p_187449_.toString(), p_187450_));
        tag.put("RecipesUsed", compoundtag);

        tag.putInt("AshLevelWood", this.ashLevelWood);
        tag.putInt("AshLevelCoal", this.ashLevelCoal);
        tag.putInt("AshLevelMisc", this.ashLevelMisc);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, AbstractBrickFurnaceBlockEntity blockEntity) {
        boolean flag = blockEntity.isLit();
        boolean flag1 = false;
        if (blockEntity.isLit()) {
            blockEntity.litTime--;
        }

        ItemStack itemstack = blockEntity.items.get(SLOT_FUEL);
        ItemStack itemstack1 = blockEntity.items.get(SLOT_INPUT);
        boolean flag2 = !itemstack1.isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (blockEntity.isLit() || flag3 && flag2) {
            RecipeHolder<?> recipeholder;
            if (flag2) {
                recipeholder = blockEntity.quickCheck.getRecipeFor(new SingleRecipeInput(itemstack1), level).orElse(null);
            } else {
                recipeholder = null;
            }

            int i = blockEntity.getMaxStackSize();
            if (!blockEntity.isLit() && canBurn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity)) {
                // Furnace won't ignite if there's more than 16 of any ash backed up in the buffer
                boolean isClogged = blockEntity.ashLevelCoal >= 16 * ASH_THRESHOLD
                        || blockEntity.ashLevelWood >= 16 * ASH_THRESHOLD
                        || blockEntity.ashLevelMisc >= 16 * ASH_THRESHOLD;
                blockEntity.litTime = !isClogged ? blockEntity.getBurnDuration(itemstack) : 0;
                blockEntity.litDuration = blockEntity.litTime;
                if (blockEntity.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem())
                        blockEntity.items.set(SLOT_FUEL, itemstack.getCraftingRemainingItem());
                    else
                    if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            blockEntity.items.set(SLOT_FUEL, itemstack.getCraftingRemainingItem());
                        }
                    }
                    //Ash buildup when a item is consumed as fuel
                    AshUtil.EnumAshType ashType = AshUtil.getAshFromFuel(itemstack);
                    // Increment ash by burn time
                    if (ashType == AshUtil.EnumAshType.COAL) blockEntity.ashLevelCoal += blockEntity.litTime;
                    if (ashType == AshUtil.EnumAshType.WOOD) blockEntity.ashLevelWood += blockEntity.litTime;
                    if (ashType == AshUtil.EnumAshType.MISC) blockEntity.ashLevelMisc += blockEntity.litTime;
                }
                // If ash exceeds threshold, create ash item and decrease ash buildup
                blockEntity.ashLevelCoal -= processAsh(blockEntity, AshUtil.EnumAshType.COAL, blockEntity.ashLevelCoal) * ASH_THRESHOLD;
                blockEntity.ashLevelWood -= processAsh(blockEntity, AshUtil.EnumAshType.WOOD, blockEntity.ashLevelWood) * ASH_THRESHOLD;
                blockEntity.ashLevelMisc -= processAsh(blockEntity, AshUtil.EnumAshType.MISC, blockEntity.ashLevelMisc) * ASH_THRESHOLD;
            }

            if (blockEntity.isLit() && canBurn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity)) {
                blockEntity.cookingProgress++;
                if (blockEntity.cookingProgress == blockEntity.cookingTotalTime) {
                    blockEntity.cookingProgress = 0;
                    blockEntity.cookingTotalTime = getTotalCookTime(level, blockEntity);
                    if (burn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity)) {
                        blockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            } else {
                blockEntity.cookingProgress = 0;
            }
        } else if (!blockEntity.isLit() && blockEntity.cookingProgress > 0) {
            blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - COOK_COOL_SPEED, 0, blockEntity.cookingTotalTime);
        }

        if (flag != blockEntity.isLit()) {
            flag1 = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(blockEntity.isLit()));
            level.setBlock(pos, state, 3);
        }

        if (flag1) {
            setChanged(level, pos, state);
        }
    }

    /**
     * Generates ASH if the ASH_THRESHOLD is met
     * @param blockEntity blockEntity
     * @param ashType Type of ash to process
     * @param ashLevel Ash Level in INTEGER
     * @return Amount of ASH created
     */
    private static int processAsh(AbstractBrickFurnaceBlockEntity blockEntity, AshUtil.EnumAshType ashType, int ashLevel) {
        if (ashLevel >= ASH_THRESHOLD) {
            Item ashItem = ashType.getItem();
            ItemStack existingItem = blockEntity.items.get(SLOT_ASH);
            int count = Math.min(ashLevel / ASH_THRESHOLD, ashItem.getDefaultMaxStackSize());
            if (existingItem.isEmpty()) {
                blockEntity.items.set(SLOT_ASH, new ItemStack(ashItem, count));
                return count;
            }
            else if (existingItem.getItem() == ashItem && existingItem.getCount() < existingItem.getMaxStackSize()) {
                int n = Math.min(existingItem.getMaxStackSize() - existingItem.getCount(), count);
                existingItem.grow(n);
                return n;
            }
        }

        return 0;
    }

    private static boolean canBurn(RegistryAccess registryAccess, @Nullable RecipeHolder<?> recipe, NonNullList<ItemStack> inventory, int maxStackSize, AbstractBrickFurnaceBlockEntity furnace) {
        if (!inventory.get(SLOT_INPUT).isEmpty() && recipe != null) {
            ItemStack itemstack = ((RecipeHolder<? extends AbstractCookingRecipe>) recipe).value().assemble(new SingleRecipeInput(furnace.getItem(SLOT_INPUT)), registryAccess);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = inventory.get(SLOT_RESULT);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItemSameComponents(itemstack1, itemstack)) {
                    return false;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= maxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize() // Neo fix: make furnace respect stack sizes in furnace recipes
                            ? true
                            : itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Neo fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    private static boolean burn(RegistryAccess registryAccess, @Nullable RecipeHolder<?> recipe, NonNullList<ItemStack> inventory, int maxStackSize, AbstractBrickFurnaceBlockEntity furnace) {
        if (recipe != null && canBurn(registryAccess, recipe, inventory, maxStackSize, furnace)) {
            ItemStack itemstack = inventory.get(SLOT_INPUT);
            ItemStack itemstack1 = ((RecipeHolder<? extends AbstractCookingRecipe>) recipe).value().assemble(new SingleRecipeInput(furnace.getItem(SLOT_INPUT)), registryAccess);
            ItemStack itemstack2 = inventory.get(SLOT_RESULT);
            if (itemstack2.isEmpty()) {
                inventory.set(SLOT_RESULT, itemstack1.copy());
            } else if (ItemStack.isSameItemSameComponents(itemstack2, itemstack1)) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !inventory.get(SLOT_FUEL).isEmpty() && inventory.get(SLOT_FUEL).is(Items.BUCKET)) {
                inventory.set(SLOT_FUEL, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
            return true;
        } else {
            return false;
        }
    }

    protected int getBurnDuration(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            return fuel.getBurnTime(this.recipeType);
        }
    }

    private static int getTotalCookTime(Level level, AbstractBrickFurnaceBlockEntity blockEntity) {
        ItemStack itemStack = blockEntity.getItem(SLOT_INPUT);
        SingleRecipeInput singlerecipeinput = new SingleRecipeInput(itemStack);
        int cookTime = blockEntity.quickCheck.getRecipeFor(singlerecipeinput, level).map(p_300840_ -> p_300840_.value().getCookingTime()).orElse(COOK_TIME_STANDARD);
        Item resultItem = blockEntity.quickCheck.getRecipeFor(singlerecipeinput, level).map(a -> a.value().getResultItem(level.registryAccess())).orElse(ItemStack.EMPTY).getItem();

        // HashMap Smelting Bonus
        if (burnSpeedBonus.containsKey(itemStack.getItem())) {
            return cookTime / burnSpeedBonus.get(itemStack.getItem());
        }
        // Block to Block Smelting Bonus
        else if (itemStack.getItem() instanceof BlockItem && resultItem instanceof BlockItem) {
            return cookTime / 2;
        }
        // Log to Charcoal Smelting Bonus
        else if (resultItem.builtInRegistryHolder().is(ItemTags.LOGS)) {
            return cookTime / 2;
        }
        // Normal Cooking
        else return cookTime;
    }

    public static boolean isFuel(ItemStack stack) {
        return stack.getBurnTime(null) > 0;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return side == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    /**
     * Returns {@code true} if automation can insert the given item in the given slot from the given side.
     */
    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return this.canPlaceItem(index, itemStack);
    }

    /**
     * Returns {@code true} if automation can extract the given item in the given slot from the given side.
     */
    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return direction == Direction.DOWN && index == SLOT_FUEL ? stack.is(Items.WATER_BUCKET) || stack.is(Items.BUCKET) : true;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setItem(int index, ItemStack stack) {
        ItemStack itemstack = this.items.get(index);
        boolean flag = !stack.isEmpty() && ItemStack.isSameItemSameComponents(itemstack, stack);
        this.items.set(index, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        if (index == SLOT_INPUT && !flag) {
            this.cookingTotalTime = getTotalCookTime(this.level, this);
            this.cookingProgress = 0;
            this.setChanged();
        }
    }

    /**
     * Returns {@code true} if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For guis use Slot.isItemValid
     */
    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        if (index == SLOT_RESULT) {
            return false;
        } else if (index != SLOT_FUEL) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(SLOT_FUEL);
            return stack.getBurnTime(this.recipeType) > 0 || stack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }

    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe) {
        if (recipe != null) {
            ResourceLocation resourcelocation = recipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    @Override
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void awardUsedRecipes(Player player, List<ItemStack> items) {
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer player) {
        List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
        player.awardRecipes(list);

        for (RecipeHolder<?> recipeholder : list) {
            if (recipeholder != null) {
                player.triggerRecipeCrafted(recipeholder, this.items);
            }
        }

        this.recipesUsed.clear();
    }

    public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel level, Vec3 popVec) {
        List<RecipeHolder<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            level.getRecipeManager().byKey(entry.getKey()).ifPresent(p_300839_ -> {
                list.add((RecipeHolder<?>)p_300839_);
                createExperience(level, popVec, entry.getIntValue(), ((AbstractCookingRecipe)p_300839_.value()).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel level, Vec3 popVec, int recipeIndex, float experience) {
        int i = Mth.floor((float)recipeIndex * experience);
        float f = Mth.frac((float)recipeIndex * experience);
        if (f != 0.0F && Math.random() < (double)f) {
            i++;
        }

        ExperienceOrb.award(level, popVec, i);
    }

    @Override
    public void fillStackedContents(StackedContents helper) {
        for (ItemStack itemstack : this.items) {
            helper.accountStack(itemstack);
        }
    }
}
