package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.GeigerCounterItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RDTTools {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    public static final RegistryObject<Item> GEIGER_COUNTER = ITEMS.register("geiger_counter",
            () -> new GeigerCounterItem(new Item.Properties().tab(RDTCreativeModeTabs.MAIN)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
