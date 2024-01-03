package net.guwy.radiated.content.items;

import net.guwy.radiated.index.NTMDamageSources;
import net.guwy.radiated.index.NTMSounds;
import net.guwy.radiated.index.NTMTools;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IVBagItem extends Item {
    public IVBagItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        itemStack.setCount(itemStack.getCount() - 1);

        pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 20);
        pPlayer.swing(pUsedHand);

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

        ItemStack output = new ItemStack(NTMTools.BLOOD_BAG.get());
        pPlayer.getInventory().placeItemBackInInventory(output);

        pPlayer.hurt(NTMDamageSources.IV_BAG, 8);

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
