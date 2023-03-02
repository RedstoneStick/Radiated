package net.guwy.radiated.events.server.player_tick;

import net.guwy.radiated.index.ModDamageSources;
import net.guwy.radiated.mechanics.radiation.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;

public class PlayerRadiationHandler {
    public static void init(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        Level level = player.getLevel();

        handleInventoryRadiation(player);

        processGeigerVal(player);
        RadiationPoisoningHandler.handle(player);

    }

    private static void handleInventoryRadiation(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            for(int i = 0; i < player.getInventory().getContainerSize(); i++){
                ItemStack itemStack = player.getInventory().getItem(i);


                if(!itemStack.getItem().equals(Blocks.AIR.asItem())){
                    handler.increaseGeigerVal(GetRadiationVal.getStackVal(itemStack));

                }
            }

        });
    }

    private static void processGeigerVal(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            double geigerVal = handler.getGeigerVal();

            if(!player.isCreative()){
                if(geigerVal > 0){
                    /* Radiation resistance application will come here */
                    geigerVal = geigerVal * (1 - GetRadiationResistance.getVal(player));

                    handler.increasePlayerRadiationVal(geigerVal);
                } else if(geigerVal < 0) {
                    handler.decreasePlayerRadiationVal(Math.abs(geigerVal));
                }
            }

            handler.setLastGeigerVal(geigerVal);
            handler.setGeigerVal(0);
        });
    }


}
