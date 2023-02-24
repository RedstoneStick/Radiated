package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.RTGPelletItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RDTRTGPellets {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);
    static long year = 8760000, day = 24000, hour = 1200;



    //Depleted
    public static final RegistryObject<Item> DECAYED_LEAD_RTG_PELLET = ITEM.register("decayed_lead_rtg_pellet",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.MAIN)));



    //Not Depleted
    public static final RegistryObject<Item> RADIUM_RTG_PELLET = ITEM.register("radium_rtg_pellet",
            () -> new RTGPelletItem(2400*year, 12, 11.25, DECAYED_LEAD_RTG_PELLET.get()
                    , new Item.Properties().tab(RDTCreativeModeTabs.MAIN)));



    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
