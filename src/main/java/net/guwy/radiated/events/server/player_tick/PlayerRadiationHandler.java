package net.guwy.radiated.events.server.player_tick;

import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class PlayerRadiationHandler {
    public static void init(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        Level level = player.getLevel();

        processGeigerVal(player);
        handleRadiationPoisoning(player);
    }

    private static void processGeigerVal(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            double geigerVal = handler.getGeigerVal();

            if(!player.isCreative()){
                if(geigerVal > 0){
                    /* Radiation resistance application will come here */
                    handler.increasePlayerRadiationVal(geigerVal);
                } else if(geigerVal < 0) {
                    handler.decreasePlayerRadiationVal(geigerVal);
                }
            }

            handler.setLastGeigerVal(geigerVal);
            handler.setGeigerVal(0);
        });
    }

    private static void handleRadiationPoisoning(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            double radiationVal = handler.getPlayerRadiationVal();
            double chance = 0.25;
            boolean isTime = (player.tickCount % 100) == 0;

            if(radiationVal > 0){
                if(radiationVal >= handler.getMaxPlayerRadiation()){
                    player.hurt(new DamageSource("radiation"), Float.MAX_VALUE);
                }
                if (radiationVal >= 900){
                    if(isTime && Math.random() < chance){
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
                    }
                }
                else if (radiationVal >= 800){
                    if(isTime && Math.random() < chance){
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    }
                }


                if (radiationVal >= 600){
                    boolean rollRandom;
                    if(radiationVal >= 900){
                        player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 3));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
                    } else {
                        if(isTime){
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
                    }

                } else {

                    if  (radiationVal < 500){
                        chance = 0.08;
                    }

                    if (radiationVal >= 400){
                        if(isTime){
                            if (Math.random() < chance){
                                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
                            }
                            if (Math.random() < chance){
                                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
                            }
                        }
                    } else {
                        if (radiationVal >= 300){
                            if(isTime){
                                if (Math.random() < chance){
                                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
                                }
                            }
                        }
                    }
                }

                chance = 0.08;
                if (radiationVal >= 200){
                    if(isTime){
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 2));
                            /** vomit **/
                        }
                        if (Math.random() < chance){
                            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
                        }
                    }
                }
            }
        });
    }
}
