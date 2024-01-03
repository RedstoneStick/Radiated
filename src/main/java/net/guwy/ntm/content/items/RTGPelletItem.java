package net.guwy.ntm.content.items;

import net.guwy.ntm.mechanics.hazard_items.IRadiatedItem;
import net.guwy.ntm.utils.NumberToTextConverter;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RTGPelletItem extends Item implements IRadiatedItem {
    /** Keep in mind 1 year = 8760000, 1 day = 24000, 1 hour = 1200 ticks **/
    /** maxHeat has to be 4times the HMB_NTM value, it's increased to give room to depleting pellets **/
    long lifetime, maxHeat;
    double radiation;
    static final String KEY_LIFETIME = "remainingLife";
    Item decayedItem;

    public RTGPelletItem(long lifetime, int maxHeat, double radiation, Item decayedItem, Properties pProperties) {
        super(pProperties);
        this.lifetime = lifetime;
        this.maxHeat = maxHeat;
        this.radiation = radiation;
        this.decayedItem = decayedItem;
    }

    public static String getKeyLifetime(){return KEY_LIFETIME;}
    public static long getMaxLifetime(RTGPelletItem item){return item.lifetime;}
    public static Item getDecayedItem(RTGPelletItem item){return item.decayedItem;}

    @Override
    public double radiationVal(ItemStack itemStack) {
        return this.radiation * getPercentageLifetime(itemStack);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        return (int) Math.floor(getPercentageLifetime(pStack) * 13);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        float stackMaxDamage = this.getMaxDamage(pStack);
        float f = (float) Math.max(0.0F, (getPercentageLifetime(pStack)));
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.ntm.rtg_pellet.1")
                .append(Integer.toString(getHeatVal(pStack)))
                .withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("tooltip.ntm.rtg_pellet.2")
                .append(new ItemStack(decayedItem).getDisplayName().getString())
                .withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("tooltip.ntm.rtg_pellet.3")
                .append(NumberToTextConverter.TicksToYMD(getRemainingLifetime(pStack)))
                .withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("tooltip.ntm.rtg_pellet.4")
                .append(NumberToTextConverter.TicksToYMD(this.lifetime))
                .withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pLevel.isClientSide){
            CompoundTag nbtTag = new CompoundTag();

            if(pStack.getTag() == null){
                nbtTag.putLong(KEY_LIFETIME, this.lifetime);
                pStack.setTag(nbtTag);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player pPlayer = pContext.getPlayer();
        CompoundTag nbtTag = new CompoundTag();
        ItemStack pStack = pContext.getItemInHand();
        if(pStack.getTag() != null){
            nbtTag.putLong(KEY_LIFETIME, Math.max(0, pStack.getTag().getLong(KEY_LIFETIME) - 1000));
            pStack.setTag(nbtTag);
        }
        pPlayer.getCooldowns().addCooldown(pContext.getItemInHand().getItem(), 20);
        return super.useOn(pContext);
    }

    public int getHeatVal(ItemStack itemStack){
        return (int) Math.ceil(this.maxHeat * getPercentageLifetime(itemStack));
    }

    public long getRemainingLifetime(ItemStack itemStack){
        if(itemStack.getTag() != null){
            return itemStack.getTag().getLong(KEY_LIFETIME);
        } else {
            return this.lifetime;
        }
    }

    private double getPercentageLifetime(ItemStack itemStack){
        if(itemStack.getTag() != null){
            long remainingLife = itemStack.getTag().getLong(KEY_LIFETIME);
            return (double) remainingLife / this.lifetime;
        } else {
            return 1;
        }
    }
}
