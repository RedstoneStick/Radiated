package net.guwy.ntm.enums;

import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public enum EBedrockOres {
    //Ore								Byproduct (gives 2 when the item is centrifuged)	1(nitrated),			2(deep cleaned),			3(seared)
    IRON("iron", 0xE2C0AA,                      EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.TITANIUM,	EBedrockOreByproducts.TITANIUM), //titanium, sulfur from pyrite
    COPPER("copper", 0xEC9A63,					EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.SULFUR), //sulfur sulfur sulfur sulfur
    BORAX("borax", 0xE4BE74, 					EBedrockOreByproducts.LITHIUM, 	EBedrockOreByproducts.CALCIUM, 	EBedrockOreByproducts.CALCIUM), //calcium from ulexite, uhhh lithium?
    ASBESTOS("asbestos", 0xBFBFB9,				EBedrockOreByproducts.SILICON,	EBedrockOreByproducts.SILICON,	EBedrockOreByproducts.SILICON), //quartz i guess?
    NIOBIUM("niobium", 0xAF58D8,				EBedrockOreByproducts.IRON,		EBedrockOreByproducts.IRON,		EBedrockOreByproducts.IRON), //iron in columbite, often found along tantalite
    TITANIUM("titanium", 0xF2EFE2,				EBedrockOreByproducts.SILICON,	EBedrockOreByproducts.CALCIUM,	EBedrockOreByproducts.ALUMINIUM), //titanite is titanium + calcium + silicon with traces of iron and aluminium
    TUNGSTEN("tungsten", 0x2C293C,				EBedrockOreByproducts.LEAD,		EBedrockOreByproducts.IRON,		EBedrockOreByproducts.BISMUTH), //ferberite has iron, raspite has lead, russelite is bismuth tungsten
    GOLD("gold", 0xF9D738,						EBedrockOreByproducts.LEAD,		EBedrockOreByproducts.COPPER,	EBedrockOreByproducts.BISMUTH), //occurs with copper, lead and rare bismuthide
    URANIUM("uranium", 0x868D82,				EBedrockOreByproducts.LEAD,		EBedrockOreByproducts.RADIUM,	EBedrockOreByproducts.POLONIUM), //uranium and its decay products
    THORIUM("th232", 0x7D401D,				    EBedrockOreByproducts.SILICON,	EBedrockOreByproducts.URANIUM,	EBedrockOreByproducts.TECHNETIUM), //thorium occours with uraninite and decay products
    CHLOROCALCITE("chlorocalcite", 0xCDE036, 	EBedrockOreByproducts.LITHIUM, 	EBedrockOreByproducts.SILICON, 	EBedrockOreByproducts.SILICON), //i guess?
    FLUORITE("fluorite", 0xF6F3E7, 				EBedrockOreByproducts.SILICON, 	EBedrockOreByproducts.LITHIUM, 	EBedrockOreByproducts.ALUMINIUM), //different silicon-bearing gemstones, generic lithium, aluminium from sodium compound trailings
    HEMATITE("hematite", 0xA37B72,				EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.TITANIUM,	EBedrockOreByproducts.TITANIUM), //titanium, sulfur from pyrite
    MALACHITE("malachite", 0x66B48C,			EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.SULFUR,	EBedrockOreByproducts.SULFUR); //sulfur sulfur sulfur sulfur

    public String oreName;
    public int color;
    public EBedrockOreByproducts[] byproducts;

    /** Byproduct count must be consistent with current tier count, use NULL if no byproduct should be generated! */
    EBedrockOres(String name, int color, @Nullable EBedrockOreByproducts... by) {
        this.oreName = name;
        this.color = color;
        this.byproducts = by;
    }
}
