package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.gasmask.IGasmaskItem;
import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class FilterItem extends Item {
    public FilterItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            IGasmaskItem.setFilter(pPlayer, pPlayer.getItemInHand(pUsedHand), pUsedHand);
            pPlayer.getCooldowns().addCooldown(pPlayer.getUseItem().getItem(), 5);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }



    public boolean doesProtectAgainstAirborneParticles(){
        return false;
    }

    // Unused
    public boolean doesProtectAgainstParticulates(){
        return false;
    }

    public boolean doesProtectAgainstChemicalGas(){
        return false;
    }

    // Unused
    public boolean doesProtectAgainstBacteriaAerosols(){
        return false;
    }

    public boolean doesProtectAgainstCarbonMonoxide(){
        return false;
    }

    // Unused
    public boolean doesProtectAgainstNerveAgent(){
        return false;
    }


    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
