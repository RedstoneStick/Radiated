package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NTMWeapons {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    public static final DeferredItem<Item> REDSTONE_SWORD = ITEMS.register("redstone_sword",
            () -> new SwordItem(Tiers.STONE, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.STONE, 3, -1.2F))));
    public static final DeferredItem<Item> BIG_SWORD = ITEMS.register("big_sword",
            () -> new SwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.8F))));
    public static final DeferredItem<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 3, -2.4F))));
    public static final DeferredItem<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(ModToolTiers.TITANIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, 3, -2.4F))));
    public static final DeferredItem<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new SwordItem(ModToolTiers.COBALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COBALT, 8.5f, -2.4F))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
