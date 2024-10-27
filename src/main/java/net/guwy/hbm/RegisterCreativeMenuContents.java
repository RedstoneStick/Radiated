package net.guwy.hbm;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

public class RegisterCreativeMenuContents {

    public static void register(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(NTMResourcesNParts.TEST_ITEM);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            NTMOresNBlocks.ITEMS.getEntries().forEach((entry) -> {
                event.accept(entry.get());
            });
        }
    }
}
