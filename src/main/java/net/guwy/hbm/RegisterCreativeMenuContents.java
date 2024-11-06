package net.guwy.hbm;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

public class RegisterCreativeMenuContents {

    public static void register(BuildCreativeModeTabContentsEvent event) {

        //if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        //    NTMResourcesNParts.ITEMS.getEntries().forEach((item) -> {
        //        event.accept(item.get());
        //    });
        //}

    }
}
