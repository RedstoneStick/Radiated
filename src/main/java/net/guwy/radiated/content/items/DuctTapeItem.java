package net.guwy.radiated.content.items;

import net.guwy.radiated.index.NTMSounds;
import net.guwy.radiated.mechanics.radiation.IRadiationResistance;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
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
        ItemStack armorItem;

        for(EquipmentSlot equipmentSlot : EquipmentSlot.values()){
            armorItem = pPlayer.getItemBySlot(equipmentSlot);

            if(equipmentSlot.getType().equals(EquipmentSlot.Type.ARMOR)){
                if(IRadiationResistance.getMaxApplicableDuctTape(armorItem) > IRadiationResistance.getDuctTapeAmount(armorItem)
                        && itemStack.getCount() > 0){
                    IRadiationResistance.addDuctTape(armorItem, 1);

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
                    soundPlayer.playSound(NTMSounds.DUCT_TAPE.get());

                    pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 5);
                    itemStack.setCount(itemStack.getCount() - 1);
                    pPlayer.swing(pUsedHand);
                }
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.radiated.duct_tape.1").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
