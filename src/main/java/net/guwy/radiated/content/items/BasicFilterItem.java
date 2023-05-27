package net.guwy.radiated.content.items;

import net.minecraft.world.item.ItemStack;

public class BasicFilterItem extends FilterItem{
    boolean airborneParticles, particulates, chemicalGas, bacteriaAerosol, carbonMonoxide, nerveAgent;
    int durability;

    public BasicFilterItem(Properties pProperties, int durability,
                           boolean airborneParticles, boolean particulates, boolean chemicalGas,
                           boolean bacteriaAerosol, boolean carbonMonoxide, boolean nerveAgent) {
        super(pProperties);

        this.durability = durability;

        this.airborneParticles = airborneParticles;
        this.particulates = particulates;
        this.chemicalGas = chemicalGas;
        this.bacteriaAerosol = bacteriaAerosol;
        this.carbonMonoxide = carbonMonoxide;
        this.nerveAgent = nerveAgent;
    }



    //@Override
    //public int getMaxDamage(ItemStack stack) {
    //    return durability;
    //}



    public boolean isAirborneParticles() {
        return this.airborneParticles;
    }

    public boolean particulates() {
        return this.particulates;
    }

    public boolean chemicalGas() {
        return this.chemicalGas;
    }

    public boolean bacteriaAerosol() {
        return this.bacteriaAerosol;
    }

    public boolean carbonMonoxide() {
        return this.carbonMonoxide;
    }

    public boolean nerveAgent() {
        return this.nerveAgent;
    }
}
