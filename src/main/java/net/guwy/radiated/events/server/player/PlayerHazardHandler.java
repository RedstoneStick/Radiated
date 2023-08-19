package net.guwy.radiated.events.server.player;

import net.guwy.radiated.mechanics.hazard_items.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;

public class PlayerHazardHandler {
    public static void init(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        double asbestosAffect = 0,coalDustAffect = 0;
        int pyrophoricHotItemCount = 0, hydroreactiveItemCount = 0, flammableExplosiveItemCount = 0, blindingItemCount = 0;


        // Goes through the inventory to check hazards
        int invSize = player.getInventory().getContainerSize();
        for(int i = 0; i < invSize; i++){
            ItemStack itemStack = player.getInventory().getItem(i);
            Item item = itemStack.getItem();

            if(item instanceof IAsbestosItem specialItem) asbestosAffect += specialItem.asbestosVal(itemStack) * itemStack.getCount();
            if(item instanceof ICoalDustItem specialItem) coalDustAffect += specialItem.coalDustVal(itemStack) * itemStack.getCount();
            if(item instanceof IPyrophoricHotItem specialItem && specialItem.isPyrophoricHot(itemStack)) pyrophoricHotItemCount += itemStack.getCount();
            if(item instanceof IHydroreactiveItem specialItem && specialItem.isHydroreactive(itemStack)) hydroreactiveItemCount += itemStack.getCount();
            if(item instanceof IFlammableExplosiveItem specialItem && specialItem.isFlammableExplosive(itemStack)) flammableExplosiveItemCount += itemStack.getCount();
            if(item instanceof IBlindingItem specialItem && specialItem.isBlinding(itemStack)) blindingItemCount += itemStack.getCount();
        }

        HandleAsbestosHazard(player, asbestosAffect);
        HandleCoalDustHealing(player);
        HandleCoalDustHazard(player, coalDustAffect);
        HandlePyrophoricHotHazard(player, pyrophoricHotItemCount);
        HandleHydroreactiveHazard(player, hydroreactiveItemCount);
        HandleFlammableExplosiveHazard(player, flammableExplosiveItemCount);
        HandleBlindingHazard(player, blindingItemCount);
    }


    private static void HandleAsbestosHazard(Player player, double affect){
    }

    private static void HandleCoalDustHealing(Player player){
    }

    private static void HandleCoalDustHazard(Player player, double affect){
    }

    private static void HandlePyrophoricHotHazard(Player player, double count){
        if(count > 0){
            player.setRemainingFireTicks(100);
        }
    }

    private static void HandleHydroreactiveHazard(Player player, double count){
        if(count > 0){

            // If raining spawn particles and sound
            // offset 1 blocks above to compensate for sinking into any blocks
            if(player.getLevel().isRainingAt(player.getOnPos().offset(0, 1, 0))){

            }
        }
    }

    private static void HandleFlammableExplosiveHazard(Player player, double count){
    }

    private static void HandleBlindingHazard(Player player, double count){
    }
}
