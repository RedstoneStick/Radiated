package net.guwy.ntm.enums;

import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraft.world.item.Item;

public enum EBedrockOreByproducts {
    //Byproduct
    IRON("iron", 0xE2C0AA),
    COPPER("copper", 0xEC9A63),
    LITHIUM("lithium", 0xEDEDED),
    SILICON("silicon", 0xFFFBD1),
    LEAD("lead", 0x646470),
    TITANIUM("titanium", 0xF2EFE2),
    ALUMINIUM("aluminium", 0xE8F2F9),
    SULFUR("sulfur", 0xEAD377),
    CALCIUM("calcium", 0xCFCFA6),
    BISMUTH("bismuth", 0x8D8577),
    RADIUM("radium", 0xE9FAF6),
    TECHNETIUM("technetium", 0xCADFDF),
    POLONIUM("polonium", 0xCADFDF),
    URANIUM("uranium", 0x868D82);

    public String oreName;
    public int color;

    EBedrockOreByproducts(String name, int color) {
        this.oreName = name;
        this.color = color;
    }
}
