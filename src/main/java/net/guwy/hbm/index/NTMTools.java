package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NTMTools {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 1.5f, -3f))));
    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 1.5f, -2.8f))));
    public static final DeferredItem<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 6, -3f))));
    public static final DeferredItem<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STEEL, -2, -1f))));

    public static final DeferredItem<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(ModToolTiers.TITANIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, 1.5f, -3f))));
    public static final DeferredItem<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TITANIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, 1, -2.8f))));
    public static final DeferredItem<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(ModToolTiers.TITANIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, 5.5f, -3f))));
    public static final DeferredItem<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(ModToolTiers.TITANIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, -2.5f, -1f))));

    public static final DeferredItem<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModToolTiers.COBALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COBALT, 1.5f, -3f))));
    public static final DeferredItem<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COBALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COBALT, 1, -2.8f))));
    public static final DeferredItem<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModToolTiers.COBALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COBALT, 6.5f, -3f))));
    public static final DeferredItem<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModToolTiers.COBALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COBALT, -2.5f, -1f))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
