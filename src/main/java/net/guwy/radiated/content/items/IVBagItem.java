package net.guwy.radiated.content.items;

import net.guwy.radiated.index.ModDamageSources;
import net.guwy.radiated.index.ModSounds;
import net.guwy.radiated.index.RDTItems;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class IVBagItem extends Item {
    public IVBagItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        itemStack.setCount(itemStack.getCount() - 1);

        pPlayer.hurt(ModDamageSources.IV_BAG, 8);
        pPlayer.getCooldowns().addCooldown(itemStack.getItem(), 20);
        pPlayer.swing(pUsedHand);

        pLevel.playSound(null, pPlayer, ModSounds.RADAWAY.get(), SoundSource.PLAYERS, 100,1);

        ItemStack output = new ItemStack(RDTItems.BLOOD_BAG.get());
        pPlayer.addItem(output);

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
