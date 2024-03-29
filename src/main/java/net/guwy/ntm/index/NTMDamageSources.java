package net.guwy.ntm.index;

import net.minecraft.world.damagesource.DamageSource;

public class NTMDamageSources {
    public static DamageSource RADIATION = new DamageSource("radiation")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_1 = new DamageSource("yellowcake_1")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_2 = new DamageSource("yellowcake_2")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_3 = new DamageSource("yellowcake_3")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource IV_BAG = new DamageSource("iv_bag")
            .bypassArmor().bypassEnchantments().bypassMagic();

    public static DamageSource VOMIT_BLOOD = new DamageSource("vomit_blood")
            .bypassArmor().bypassEnchantments().bypassMagic();

    public static DamageSource ASBESTOS = new DamageSource("asbestos")
            .bypassArmor().bypassEnchantments().bypassMagic();

    public static DamageSource COAL_DUST = new DamageSource("coal_dust")
            .bypassArmor().bypassEnchantments().bypassMagic();
}
