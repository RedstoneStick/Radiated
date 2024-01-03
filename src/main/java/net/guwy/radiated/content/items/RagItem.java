package net.guwy.radiated.content.items;

import net.guwy.radiated.index.NTMResourcesAndParts;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class RagItem extends Item {

    public RagItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("item.radiated.rag.tooltip.1"));
        pTooltipComponents.add(Component.translatable("item.radiated.rag.tooltip.2"));
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if(entity.isInWaterOrRain()){
            int count = stack.getCount();
            stack = new ItemStack(NTMResourcesAndParts.RAG_DAMP.get(), count);
            entity.setItem(stack);
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.setItemInHand(pUsedHand, new ItemStack(itemStack.getItem(), itemStack.getCount() - 1));
        pPlayer.getInventory().placeItemBackInInventory(new ItemStack(NTMResourcesAndParts.RAG_PISS.get(), 1));
        pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 4);
        pLevel.playSound(null, pPlayer, SoundEvents.AMBIENT_UNDERWATER_EXIT, SoundSource.PLAYERS, 1, 1.3f);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
    }
}
