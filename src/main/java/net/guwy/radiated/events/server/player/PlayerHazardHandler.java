package net.guwy.radiated.events.server.player;

import net.guwy.radiated.index.NTMSounds;
import net.guwy.radiated.index.NTMDamageSources;
import net.guwy.radiated.index.NTMEffects;
import net.guwy.radiated.mechanics.hazard_items.*;
import net.guwy.radiated.mechanics.lung_diseases.PlayerLungDiseases;
import net.guwy.radiated.mechanics.lung_diseases.PlayerLungDiseasesProvider;
import net.guwy.sticky_foundations.index.SFTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.TickEvent;

public class PlayerHazardHandler {
    public static void init(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        int asbestosAffect = 0,coalDustAffect = 0, pyrophoricHotItemCount = 0, hydroreactiveItemCount = 0, flammableExplosiveItemCount = 0, blindingItemCount = 0;
        boolean playerHasReacher = false;


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

            // Check for a tungsten reacher
            playerHasReacher = false;
        }

        // Handles the effect applications of hazards
        HandleLungDiseases(player, asbestosAffect, coalDustAffect);
        HandlePyrophoricHotHazard(player, pyrophoricHotItemCount, playerHasReacher);
        HandleHydroreactiveHazard(player, hydroreactiveItemCount);
        HandleFlammableExplosiveHazard(player, flammableExplosiveItemCount);
        HandleBlindingHazard(player, blindingItemCount);
    }



    private static void HandleLungDiseases(Player player, int asbestos, int coalDust){

        // Do not process if the player is in creative
        if(!player.isCreative()){
            player.getCapability(PlayerLungDiseasesProvider.PLAYER_LUNG_DISEASES).ifPresent(lungs -> {

                // Death
                if (lungs.getAsbestos() >= PlayerLungDiseases.GetMaxVal()) player.hurt(NTMDamageSources.ASBESTOS, Float.MAX_VALUE);
                if (lungs.getBlackLung() >= PlayerLungDiseases.GetMaxVal()) player.hurt(NTMDamageSources.COAL_DUST, Float.MAX_VALUE);

                // Asbestos
                lungs.increaseAsbestos(asbestos, player);

                // Coal Dust
                if(lungs.getBlackLung() <= PlayerLungDiseases.GetMaxVal() / 4) lungs.decreaseBlackLung(1);  // Healing
                lungs.increaseBlackLung(Math.min(90, coalDust), player);    // you won't get affected for more than 90 per tick from items

                // Effects
                DoLungEffects(player);
            });
        }
    }


    private static void HandlePyrophoricHotHazard(Player player, double count, boolean hasReacher){
        // Don't set fire if the player has a tungsten reacher
        if(count > 0 && !hasReacher){

            // Do a check to not reduce the remaining fire ticks if the player was already on fire
            if(player.getRemainingFireTicks() < 40) player.setRemainingFireTicks(40);
        }
    }


    private static void HandleHydroreactiveHazard(Player player, double count){
        if(count > 0){

            // offset 1 blocks above to compensate for sinking into any blocks
            boolean isRaining = player.getLevel().isRainingAt(player.getOnPos().offset(0, 1, 0));
            boolean isInWater = player.isInWater();
            if(isInWater || isRaining) {

                // Explode
                player.level.explode(null, player.getX(), player.getY() + 1.5, player.getZ(), (float) (1 + (Math.sqrt(count) * 0.4)), Explosion.BlockInteraction.DESTROY);

                // Remove Items
                int invSize = player.getInventory().getContainerSize();
                for(int i = 0; i < invSize; i++){
                    ItemStack itemStack = player.getInventory().getItem(i);
                    Item item = itemStack.getItem();

                    if(item instanceof IHydroreactiveItem) itemStack.setCount(0);
                }
            }
        }
    }


    private static void HandleFlammableExplosiveHazard(Player player, double count){
        if(count > 0 && player.isOnFire()){
            // Explode
            player.level.explode(null, player.getX(), player.getY() + 1.5, player.getZ(), (float) (1 + (Math.sqrt(count) * 0.4)), Explosion.BlockInteraction.DESTROY);

            // Remove Items
            int invSize = player.getInventory().getContainerSize();
            for(int i = 0; i < invSize; i++){
                ItemStack itemStack = player.getInventory().getItem(i);
                Item item = itemStack.getItem();

                if(item instanceof IFlammableExplosiveItem) itemStack.setCount(0);
            }

            // Extinguish the player
            player.clearFire();
        }
    }


    private static void HandleBlindingHazard(Player player, double count){
        if(count > 0 && !(player.getItemBySlot(EquipmentSlot.HEAD).is(SFTags.Items.VISORS_THAT_GET_DIRTY))){
            // Blind
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 45));
        }
    }



    private static void DoLungEffects(Player player){
        player.getCapability(PlayerLungDiseasesProvider.PLAYER_LUNG_DISEASES).ifPresent(lungs -> {

            // Variables
            int     blacklung = lungs.getBlackLung(),
                    asbestos = lungs.getAsbestos(),
                    MAX_VAL = PlayerLungDiseases.GetMaxVal();

            double  blacklungPercent = (double) blacklung / MAX_VAL,
                    asbestosPercent = (double) asbestos / MAX_VAL,
                    totalPercent = blacklungPercent + asbestosPercent;

            boolean shouldCough = blacklungPercent > 0.25 || asbestosPercent > 0.25,
                    coughCoal = blacklungPercent > 0.5,
                    coughBlood = blacklungPercent > 0.75 || asbestosPercent > 0.75;



            // Coughing (every second 10% chance)
            if(shouldCough && player.tickCount % 20 == 0 && Math.random() < 0.1){

                // Cough Sound (Randomized)
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
                double rand = Math.random();
                if(rand > 0.75) soundPlayer.playSound(NTMSounds.COUGH1.get(), 1f, 1f);
                else if(rand > 0.50) soundPlayer.playSound(NTMSounds.COUGH2.get(), 1f, 1f);
                else if (rand > 0.25) soundPlayer.playSound(NTMSounds.COUGH3.get(), 1f, 1f);
                else soundPlayer.playSound(NTMSounds.COUGH4.get(), 1f, 1f);
                soundPlayer.remove(Entity.RemovalReason.DISCARDED);

                // Cough Particles
                // Uses an effect since they are already synced between client and server
                // This is probably a bad method :P
                if(coughBlood) player.addEffect(new MobEffectInstance(NTMEffects.COUGH_BLOOD.get(), 5, 0, false, false, false));
                else if(coughCoal) player.addEffect(new MobEffectInstance(NTMEffects.COUGH_COAL.get(), 5, 0, false, false, false));
            }



            // Effects
            if(totalPercent > 0.75){
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
            }
            if(totalPercent > 0.95){
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
            }
        });
    }
}
