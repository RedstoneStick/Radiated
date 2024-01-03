package net.guwy.radiated.content.items;

import net.guwy.radiated.index.NTMSounds;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.guwy.radiated.mechanics.radiation.GetRadiationResistance;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GeigerCounterItem extends Item {
    public GeigerCounterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, @NotNull Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            pPlayer.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
                pPlayer.getCooldowns().addCooldown(pPlayer.getItemInHand(pUsedHand).getItem(), 5);

                Component component;

                pPlayer.sendSystemMessage(Component.translatable("message.radiated.geiger_counter.1").withStyle(ChatFormatting.GOLD));


                component = Component.literal("").append(Component.translatable("message.radiated.geiger_counter.2").withStyle(ChatFormatting.YELLOW))
                        .append(Component.literal(Double.toString(handler.getLastGeigerVal())).append(" ").append(Component.translatable("tooltip.radiated.radiation.rad_s"))
                                .withStyle(getColorForEnvironmentRad(handler.getLastGeigerVal())));
                pPlayer.sendSystemMessage(component);

                component = Component.literal("").append(Component.translatable("message.radiated.geiger_counter.3").withStyle(ChatFormatting.YELLOW))
                        .append(Component.literal(Double.toString(handler.getPlayerRadiationVal())).append(" ").append(Component.translatable("tooltip.radiated.radiation.rad"))
                                .withStyle(getColorForPlayerRad(handler.getPlayerRadiationVal())));
                pPlayer.sendSystemMessage(component);

                component = Component.literal("").append(Component.translatable("message.radiated.geiger_counter.4").withStyle(ChatFormatting.YELLOW))
                        .append(Component.literal(Double.toString(Math.round(GetRadiationResistance.getVal(pPlayer) * 10000) / 100.0) + "%")
                                .withStyle(getColorForPlayerResist(GetRadiationResistance.getVal(pPlayer))));
                pPlayer.sendSystemMessage(component);


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
                soundPlayer.playSound(NTMSounds.TECH_BOOP.get());
            });
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private ChatFormatting getColorForEnvironmentRad(double val){
        if(val >= 1000){
            return ChatFormatting.BLACK;
        } else if (val >= 100){
            return ChatFormatting.DARK_RED;
        } else if (val >= 10){
            return ChatFormatting.RED;
        } else if (val >= 1) {
            return ChatFormatting.GOLD;
        } else if (val > 0){
            return ChatFormatting.YELLOW;
        } else {
            return ChatFormatting.GREEN;
        }
    }

    private ChatFormatting getColorForPlayerRad(double val){
        if(val >= 1000){
            return ChatFormatting.BLACK;
        } else if (val >= 800){
            return ChatFormatting.DARK_RED;
        } else if (val >= 600){
            return ChatFormatting.RED;
        } else if (val >= 400) {
            return ChatFormatting.GOLD;
        } else if (val > 200){
            return ChatFormatting.YELLOW;
        } else {
            return ChatFormatting.GREEN;
        }
    }

    private ChatFormatting getColorForPlayerResist(double val){
        if(val > 0){
            return ChatFormatting.GREEN;
        } else {
            return ChatFormatting.WHITE;
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged) && oldStack.getItem() != newStack.getItem();
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity.getType().equals(EntityType.PLAYER) && !pLevel.isClientSide){
            Player player = (Player) pEntity;
            playGeigerNoise(player, pLevel);
            setGeigerCounterNBT(player, pStack);
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    public void setGeigerCounterNBT(Player player, ItemStack itemStack){
        player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            CompoundTag tag;

            if(itemStack.getTag() != null){
                tag = itemStack.getTag();
            } else {
                tag = new CompoundTag();
                tag.putDouble("geiger_val", 0);
                tag.putDouble("player_rad", 0);
            }

            tag.putDouble("geiger_val", handler.getLastGeigerVal());
            tag.putDouble("player_rad", handler.getPlayerRadiationVal());

            itemStack.setTag(tag);
        });
    }

    public void playGeigerNoise(Player player, Level pLevel){
        if(player.tickCount % 5 == 0){
            player.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler ->{
                double val = handler.getLastGeigerVal();
                if(val > 0){

                    if(val >= 30){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER6.get());
                    } else if (val >= 25){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER5.get());
                    } else if (val >= 20){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER4.get());
                    } else if (val >= 15){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER3.get());
                    } else if (val >= 10){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER2.get());
                    } else if (val >= 5){
                        playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER1.get());
                    } else if (val > 1){
                        if(player.tickCount % 10 == 0 && Math.random() * 5 < val){
                            playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER1.get());
                        }
                    } else {
                        if(player.tickCount % 20 == 0 && Math.random() < val){
                            playTargetSoundWithRandoms(player, pLevel, NTMSounds.GEIGER1.get());
                        }
                    }
                }
            });
        }
    }

    private void playTargetSoundWithRandoms(Player player, Level pLevel, SoundEvent soundEvent){
        double rand = Math.random();
        Player sPlayer = new Player(pLevel, player.getOnPos(), 0, player.getGameProfile(), null) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return false;
            }
        };

        if(rand < 0.60){
            sPlayer.playSound(soundEvent, 100, 1);
            //pLevel.playSound(null, player, soundEvent, SoundSource.PLAYERS, 100, 1);
        } else if (rand < 0.68) {
            //pLevel.playSound(null, player, ModSounds.GEIGER5.get(), SoundSource.PLAYERS, 200, 1);
            sPlayer.playSound(NTMSounds.GEIGER5.get(), 100, 1);
        } else if (rand < 0.76) {
            //pLevel.playSound(null, player, ModSounds.GEIGER4.get(), SoundSource.PLAYERS, 200, 1);
            sPlayer.playSound(NTMSounds.GEIGER4.get(), 100, 1);
        } else if (rand < 0.84) {
            //pLevel.playSound(null, player, ModSounds.GEIGER3.get(), SoundSource.PLAYERS, 200, 1);
            sPlayer.playSound(NTMSounds.GEIGER3.get(), 100, 1);
        } else if (rand < 0.92) {
            //pLevel.playSound(null, player, ModSounds.GEIGER2.get(), SoundSource.PLAYERS, 200, 1);
            sPlayer.playSound(NTMSounds.GEIGER2.get(), 100, 1);
        } else {
            //pLevel.playSound(null, player, ModSounds.GEIGER1.get(), SoundSource.PLAYERS, 200, 1);
            sPlayer.playSound(NTMSounds.GEIGER1.get(), 100, 1);
        }
    }
}
