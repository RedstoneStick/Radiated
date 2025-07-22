package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.items.ColtanCompassItem;
import net.guwy.hbm.items.misc.BasicTooltipItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NTMResourcesNParts {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    // Raw Ores //
    public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_THORIUM = ITEMS.register("raw_thorium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ALUMINIUM = ITEMS.register("raw_aluminium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BERYLLIUM = ITEMS.register("raw_beryllium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_AUSTRALIUM = ITEMS.register("raw_australium",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> RAW_COBALT = ITEMS.register("raw_cobalt",
            () -> new Item(new Item.Properties()));



    // Ingots //



    // Tars, Solid Fuels & Asbestos //
    public static final DeferredItem<Item> INGOT_ASBESTOS = ITEMS.register("ingot_asbestos",
            () -> new BasicTooltipItem(new Item.Properties(),
                    Component.translatable("item.hbm.ingot_asbestos.tooltip").withStyle(ChatFormatting.GRAY)));



    // Billets //



    // Coals //
    public static final DeferredItem<Item> CINNEBAR = ITEMS.register("cinnebar",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGNITE = ITEMS.register("lignite",
            () -> new Item(new Item.Properties()));



    // Dusts //
    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NITER = ITEMS.register("niter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLUORITE = ITEMS.register("fluorite",
            () -> new Item(new Item.Properties()));



    // Explosives N Compounds //



    // Bedrock Ores //



    // Crystals //
    public static final DeferredItem<Item> FRAGMENT_COLTAN = ITEMS.register("fragment_coltan",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHUNK_ORE_RARE = ITEMS.register("chunk_ore.rare",
            () -> new Item(new Item.Properties()));



    // Fragments //



    // Nuggets //



    // Plates //



    // Welded Plates //



    // Shells //



    // Pipes //



    // Cubes //



    // Bolts //



    // Cloths //



    // Wire //



    // Dense Wires //



    // Dyes //



    // Missile Parts //



    // Parts //



    // Foundry Scraps //



    // Nuclear Wastes //



    // Weapon Parts //



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
