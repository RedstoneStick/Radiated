package net.guwy.radiated.mechanics.radiation;

import net.minecraft.nbt.CompoundTag;

public class EntityRadiation {
    /** Lots of variables to save **/
    private double playerRadiationVal = 0;
    private double geigerVal = 0;
    private double lastGeigerVal = 0;

    private static final double MAX_PLAYER_RADIATION = 1000;

    public EntityRadiation() {
    }

    /** Under Normal Circumstances Don't fiddle with the player radiation, instead use player geiger value
     * it'll apply radiation resistance itself and record the instant value for use in geiger counter **/

    public double getPlayerRadiationVal(){
        return Math.round(this.playerRadiationVal * 1000) / 1000d;
    }
    public void setPlayerRadiationVal(double radiationVal){
        this.playerRadiationVal = radiationVal;
    }
    public void increasePlayerRadiationVal(double increase){
        this.playerRadiationVal = Math.min(MAX_PLAYER_RADIATION, this.playerRadiationVal + increase);
    }
    public void decreasePlayerRadiationVal(double decrease){
        this.playerRadiationVal = Math.max(0, this.playerRadiationVal - decrease);
    }


    public double getGeigerVal(){
        return this.geigerVal;
    }
    public void setGeigerVal(double geigerVal){
        this.geigerVal = geigerVal;
    }
    public void increaseGeigerVal(double increase){
        this.geigerVal += increase;
    }
    public void decreaseGeigerVal(double decrease){
        this.geigerVal -= decrease;
    }


    public double getLastGeigerVal(){
        return Math.round(this.lastGeigerVal * 1000) / 1000d;
    }
    public void setLastGeigerVal(double lastGeigerVal){
        this.lastGeigerVal = lastGeigerVal;
    }


    /** The part after this point handles the saving and loading of data **/
    public void copyFrom(EntityRadiation source){
        this.playerRadiationVal = source.playerRadiationVal;
        this.geigerVal = source.geigerVal;
        this.lastGeigerVal = source.lastGeigerVal;
    }


    public static double getMaxPlayerRadiation(){
        return MAX_PLAYER_RADIATION;
    }


    public void saveNBTData(CompoundTag nbt){
        nbt.putDouble("playerRadiationVal", playerRadiationVal);
        nbt.putDouble("geigerVal", geigerVal);
        nbt.putDouble("lastGeigerVal", lastGeigerVal);
    }

    public void loadNBTData(CompoundTag nbt){
        playerRadiationVal = nbt.getDouble("playerRadiationVal");
        geigerVal = nbt.getDouble("geigerVal");
        lastGeigerVal = nbt.getDouble("lastGeigerVal");
    }
}
