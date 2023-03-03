package net.guwy.radiated.mechanics.radiation;

import net.guwy.radiated.index.ModDamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class RadiationPoisoningHandler {
    public static void handle(Player player){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            double radiationVal = handler.getPlayerRadiationVal();
            double chance = 0.50;
            boolean isTime = (player.tickCount % 100) == 0;

            if(radiationVal > 0){
                if(radiationVal >= handler.getMaxPlayerRadiation()){
                    player.hurt(ModDamageSources.RADIATION, Float.MAX_VALUE);
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
                        chance = 0.20;
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
