package net.guwy.radiated.index;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RDTCreativeModeTabs {
    public static final CreativeModeTab MAIN = new CreativeModeTab("radiated_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RDTResources.THORIUM_FUEL_INGOT.get());
        }
    };
}
