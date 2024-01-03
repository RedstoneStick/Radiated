package net.guwy.radiated.content.items;

import net.guwy.radiated.index.NTMSounds;
import net.guwy.radiated.index.NTMTools;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RadawayItem extends Item {
    double radRemove;
    public RadawayItem(double radRemove, Properties pProperties) {
        super(pProperties);
        this.radRemove = radRemove;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        pPlayer.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            handler.decreaseGeigerVal(this.radRemove);
        });

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        itemStack.setCount(itemStack.getCount() - 1);

        pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 20);
        pPlayer.swing(pUsedHand);
        pPlayer.getInventory().placeItemBackInInventory(new ItemStack(NTMTools.IV_BAG.get()));

        Player soundPlayer = new Player(pPlayer.getLevel(), pPlayer.getOnPos(), 0, pPlayer.getGameProfile(), null) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return false;
            }
        };
        soundPlayer.playSound(NTMSounds.RADAWAY.get());
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.radiated.radaway", Integer.toString((int) radRemove))
                .withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
