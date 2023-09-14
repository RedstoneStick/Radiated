package net.guwy.radiated.mechanics.lung_diseases;

import net.guwy.radiated.mechanics.gasmask.AirborneHazardTypes;
import net.guwy.radiated.mechanics.gasmask.IFilterItem;
import net.guwy.radiated.mechanics.gasmask.IGasmaskItem;
import net.guwy.sticky_foundations.client.onscreen_message.SFMessagesOnDisplay;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PlayerLungDiseases {
    // Variables to save
    private int blackLung = 0;
    private int asbestos = 0;

    private static final int MAX_VAL = 72000;
    public static int GetMaxVal(){ return MAX_VAL;}

    public PlayerLungDiseases() {
    }

    /** During using the increase function it'll handle the gas mask filtering itself **/

    public int getBlackLung(){return this.blackLung;}
    public void setBlackLung(int set){this.blackLung = set;}
    public void increaseBlackLung(int increase, Player player){
        int amount = IGasmaskItem.ProcessGasMaskFiltration(player, increase, AirborneHazardTypes.AIRBORNE_PARTICLES);

        // Increase
        this.blackLung += amount;

        // Message
        if(amount > 0) SFMessagesOnDisplay.addNewMessage(Component.translatable("message.radiated.coal_dust").getString());
    }
    public void decreaseBlackLung(int decrease){this.blackLung = Math.max(0, this.blackLung - decrease);}


    public int getAsbestos(){return this.asbestos;}
    public void setAsbestos(int set){this.asbestos = set;}
    public void increaseAsbestos(int increase, Player player){
        int amount = IGasmaskItem.ProcessGasMaskFiltration(player, increase, AirborneHazardTypes.PARTICULATES);

        // Increase
        this.asbestos += amount;

        // Message
        if(amount > 0) SFMessagesOnDisplay.addNewMessage(Component.translatable("message.radiated.asbestos").getString());
    }
    public void decreaseAsbestos(int decrease){this.asbestos = Math.max(0, this.asbestos - decrease);}



    /** The part after this point handles the saving and loading of data **/
    public void copyFrom(PlayerLungDiseases source){
        this.blackLung = source.blackLung;
        this.asbestos = source.asbestos;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("blackLung", blackLung);
        nbt.putInt("asbestos", asbestos);
    }

    public void loadNBTData(CompoundTag nbt){
        blackLung = nbt.getInt("blackLung");
        asbestos = nbt.getInt("asbestos");
    }
}
