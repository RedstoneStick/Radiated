package net.guwy.ntm.content.items;

import net.guwy.ntm.mechanics.gasmask.AirborneHazardTypes;
import net.guwy.ntm.mechanics.gasmask.IFilterItem;
import net.guwy.ntm.mechanics.gasmask.IGasmaskItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BasicFilterItem extends Item implements IFilterItem {
    List<AirborneHazardTypes> filterableHazards;


    /** It takes a list for hazard protection for ease of use down the line */
    public BasicFilterItem(Properties pProperties, List<AirborneHazardTypes> protectionList) {
        super(pProperties);
        this.filterableHazards = protectionList;
    }

    /** This one compiles the list for you */
    public BasicFilterItem(Properties pProperties, boolean airborneParticles, boolean particulates, boolean chemicalGas, boolean bacteriaAerosol, boolean carbonMonoxide, boolean nerveAgent) {
        super(pProperties);

        List<AirborneHazardTypes> protectionList = new ArrayList<>();
        if(airborneParticles) protectionList.add(AirborneHazardTypes.AIRBORNE_PARTICLES);
        if(particulates) protectionList.add(AirborneHazardTypes.PARTICULATES);
        if(chemicalGas) protectionList.add(AirborneHazardTypes.CHEMICAL_GAS);
        if(bacteriaAerosol) protectionList.add(AirborneHazardTypes.BACTERIA_AEROSOL);
        if(carbonMonoxide) protectionList.add(AirborneHazardTypes.CARBON_MONOXIDE);
        if(nerveAgent) protectionList.add(AirborneHazardTypes.NERVE_AGENT);

        this.filterableHazards = protectionList;
    }



    @Override
    public List<AirborneHazardTypes> GetFiltrableHazards() {
        return this.filterableHazards;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            IGasmaskItem.setFilter(pPlayer, pPlayer.getItemInHand(pUsedHand), pUsedHand);

            pPlayer.getCooldowns().addCooldown(pPlayer.getItemInHand(pUsedHand).getItem(), 5);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        // Filter Item Tooltip
        pTooltipComponents.addAll(FilterItemTooltip(pStack));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
