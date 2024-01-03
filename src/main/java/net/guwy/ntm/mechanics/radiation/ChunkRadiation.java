package net.guwy.ntm.mechanics.radiation;

import net.minecraft.nbt.CompoundTag;

public class ChunkRadiation {
    /** Lots of variables to save **/
    private double chunkRadiationVal = 0;
    private double chunkRadiationBuffer = 0;

    public ChunkRadiation() {
    }

    /** Under Normal Circumstances Don't fiddle with the chunkRadiationVal, instead use chunkRadiationBuffer **/

    public double getChunkRadiationVal(){
        return this.chunkRadiationVal;
    }
    public void setChunkRadiationVal(double radiationVal){
        this.chunkRadiationVal = radiationVal;
    }
    public void addChunkRadiationVal(double increase){
        this.chunkRadiationVal = this.chunkRadiationVal + increase;
    }

    public double getChunkRadiationBuffer(){
        return this.chunkRadiationBuffer;
    }
    public void setChunkRadiationBuffer(double radiationVal){
        this.chunkRadiationBuffer = radiationVal;
    }
    public void addChunkRadiationBuffer(double increase){
        this.chunkRadiationBuffer = this.chunkRadiationBuffer + increase;
    }



    /** The part after this point handles the saving and loading of data **/
    public void copyFrom(ChunkRadiation source){
        this.chunkRadiationVal = source.chunkRadiationVal;
        this.chunkRadiationBuffer = source.chunkRadiationBuffer;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putDouble("radiationVal", chunkRadiationVal);
        nbt.putDouble("radiationBuffer", chunkRadiationBuffer);
    }

    public void loadNBTData(CompoundTag nbt){
        chunkRadiationVal = nbt.getDouble("radiationVal");
        chunkRadiationBuffer = nbt.getDouble("radiationBuffer");
    }
}
