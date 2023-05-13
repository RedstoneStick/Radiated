package net.guwy.radiated.content.items;

import net.guwy.radiated.index.ModSounds;
import net.guwy.radiated.index.RDTItems;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.guwy.radiated.mechanics.radiation.IRadiationResistance;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DuctTapeItem extends Item {
    public DuctTapeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(IRadiationResistance.getMaxApplicableDuctTape(itemStack) > IRadiationResistance.getDuctTapeAmount(itemStack)){
            IRadiationResistance.addDuctTape(itemStack, 1);
            pLevel.playSound(null, pPlayer, ModSounds.RADAWAY.get(), SoundSource.PLAYERS, 100,1);

            pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 5);
            itemStack.hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(pUsedHand));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.radiated.duct_tape.1").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
