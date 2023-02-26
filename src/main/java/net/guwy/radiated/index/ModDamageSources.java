package net.guwy.radiated.index;

import net.minecraft.world.damagesource.DamageSource;

public class ModDamageSources {
    public static DamageSource RADIATION = new DamageSource("radiation")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_1 = new DamageSource("yellowcake_1")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_2 = new DamageSource("yellowcake_2")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();

    public static DamageSource YELLOWCAKE_3 = new DamageSource("yellowcake_3")
            .bypassArmor().bypassEnchantments().bypassInvul().bypassMagic();
}
