package net.guwy.ntm.mechanics.radiation;

import net.guwy.ntm.index.NTMDamageSources;
import net.guwy.ntm.index.NTMEffects;
import net.guwy.ntm.index.NTMSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class RadiationPoisoningHandler {
    public static void handle(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            double radiationVal = handler.getPlayerRadiationVal();
            double chance = 0.50;
            boolean isTime = (player.tickCount % 100) == 0; // Once every 5 secs

            if(radiationVal > 0){
                // Kill if at max exposure
                if(radiationVal >= handler.getMaxPlayerRadiation()){
                    player.hurt(NTMDamageSources.RADIATION, Float.MAX_VALUE);
                }
                // At 900 make wither more severe
                if (radiationVal >= 900){
                    if(isTime && Math.random() < chance){
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
                    }
                }
                // At 800 add wither
                else if (radiationVal >= 800){
                    if(isTime && Math.random() < chance){
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    }
                }


                // At 600 add lots of negative effects
                if (radiationVal >= 600){

                    // Apply effects constantly if above 900 rads
                    if(radiationVal >= 900){
                        player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 3));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
                    }
                    else if(isTime){
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
                        }
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 3));
                        }
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
                        }
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
                        }
                    }

                } else {

                    // If below 500 rads the chances drop
                    if  (radiationVal < 500){
                        chance = 0.20;
                    }

                    // At 400 rads add slowdown and increase the effect of weakness
                    if (radiationVal >= 400 && isTime){
                         if (Math.random() < chance){
                             player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
                         }
                         if (Math.random() < chance){
                             player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
                         }
                    }
                    else {
                        // At 300 add weakness
                        if (radiationVal >= 300 && isTime){
                            if (Math.random() < chance){
                                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
                            }
                        }
                    }
                }

                // Vomit and nausea's chances are independant
                chance = 0.08;
                if (radiationVal >= 200 && isTime){
                    // Vomit
                    if (Math.random() < chance){
                        // If above 600 rads puke blood instead
                        if(radiationVal > 600){
                            player.addEffect(new MobEffectInstance(NTMEffects.VOMIT_BLOOD.get(), 60, 0, false, false, false));
                        } else {
                            player.addEffect(new MobEffectInstance(NTMEffects.VOMIT.get(), 60, 0, false, false, false));
                        }

                        Player soundPlayer = new Player(player.getLevel(), player.getOnPos(), 0, player.getGameProfile(), null) {
                            @Override
                            public boolean isSpectator() {
                                return false;
                            }

                            @Override
                            public boolean isCreative() {
                                return false;
                            }
                        };
                        soundPlayer.playSound(NTMSounds.VOMIT.get(), 1f, 1f);
                        soundPlayer.remove(Entity.RemovalReason.DISCARDED);
                    }
                    // Nausea
                    if (Math.random() < chance){
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
                    }
                }
            }
        });
    }
}
