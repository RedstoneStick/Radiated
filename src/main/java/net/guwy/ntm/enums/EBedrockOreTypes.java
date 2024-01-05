package net.guwy.ntm.enums;

public enum EBedrockOreTypes {
    //Types (can just add more to register more types :) )
    BEDROCK("bedrock"),
    CENTRIFUGED("centrifuged"),
    CLEANED("cleaned"),
    SEPARATED("separated"),
    PURIFIED("purified"),
    NITRATED("nitrated"),
    NITRO_CRYSTALLINE("nitro_crystalline"),
    DEEP_CLEANED("deep_cleaned"),
    SEARED("seared"),
    ENRICHED("enriched");

    public String oreName;

    /** Byproduct count must be consistent with current tier count, use NULL if no byproduct should be generated! */
    EBedrockOreTypes(String name) {
        this.oreName = name;
    }
}
