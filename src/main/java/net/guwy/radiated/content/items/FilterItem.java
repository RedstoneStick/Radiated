package net.guwy.radiated.content.items;

import net.guwy.radiated.index.ModSounds;
import net.guwy.radiated.mechanics.gasmask.IGasmaskItem;
import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FilterItem extends Item {
    public FilterItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            IGasmaskItem.setFilter(pPlayer, pPlayer.getItemInHand(pUsedHand), pUsedHand);

            pPlayer.getCooldowns().addCooldown(pPlayer.getItemInHand(pUsedHand).getItem(), 5);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }



    public boolean doesProtectAgainstAirborneParticles(){
        return false;
    }

    public boolean doesProtectAgainstParticulates(){
        return false;
    }   // Unused

    public boolean doesProtectAgainstChemicalGas(){
        return false;
    }

    public boolean doesProtectAgainstBacteriaAerosols(){
        return false;
    }   // Unused

    public boolean doesProtectAgainstCarbonMonoxide(){
        return false;
    }

    public boolean doesProtectAgainstNerveAgent(){
        return false;
    }   // Unused


    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        // Protection Tooltip
        if(!Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.generic"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift"));

            if(this.doesProtectAgainstAirborneParticles()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.airborne_particles"));
            }
            if(this.doesProtectAgainstParticulates()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.particulates"));
            }
            if(this.doesProtectAgainstChemicalGas()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.chemical_gas"));
            }
            if(this.doesProtectAgainstBacteriaAerosols()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.bacteria_aerosols"));
            }
            if(this.doesProtectAgainstCarbonMonoxide()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.carbon_monoxide"));
            }
            if(this.doesProtectAgainstNerveAgent()){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.nerve_agent"));
            }
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
