package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.items.ColtanCompassItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NTMResourcesNParts {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    public static final DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new ColtanCompassItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
