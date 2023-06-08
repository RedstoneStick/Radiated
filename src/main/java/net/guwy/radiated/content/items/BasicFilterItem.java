package net.guwy.radiated.content.items;

import net.minecraft.world.item.ItemStack;

public class BasicFilterItem extends FilterItem{
    boolean airborneParticles, particulates, chemicalGas, bacteriaAerosol, carbonMonoxide, nerveAgent;

    public BasicFilterItem(Properties pProperties,
                           boolean airborneParticles, boolean particulates, boolean chemicalGas,
                           boolean bacteriaAerosol, boolean carbonMonoxide, boolean nerveAgent) {
        super(pProperties);

        this.airborneParticles = airborneParticles;
        this.particulates = particulates;
        this.chemicalGas = chemicalGas;
        this.bacteriaAerosol = bacteriaAerosol;
        this.carbonMonoxide = carbonMonoxide;
        this.nerveAgent = nerveAgent;
    }



    public boolean doesProtectAgainstAirborneParticles() {
        return this.airborneParticles;
    }

    public boolean doesProtectAgainstParticulates() {
        return this.particulates;
    }

    public boolean doesProtectAgainstChemicalGas() {
        return this.chemicalGas;
    }

    public boolean doesProtectAgainstBacteriaAerosols() {
        return this.bacteriaAerosol;
    }

    public boolean doesProtectAgainstCarbonMonoxide() {
        return this.carbonMonoxide;
    }

    public boolean doesProtectAgainstNerveAgent() {
        return this.nerveAgent;
    }
}
