package net.guwy.hbm;

import net.guwy.hbm.index.*;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

public class RegisterCreativeMenuContents {

    public static void register(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            NTMWeapons.ITEMS.getEntries().forEach((item) -> {
                event.accept(item.get());
            });
            NTMArmors.ITEMS.getEntries().forEach((item) -> {
                event.accept(item.get());
            });
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            NTMTools.ITEMS.getEntries().forEach((item) -> {
                event.accept(item.get());
            });
        }

    }
}
