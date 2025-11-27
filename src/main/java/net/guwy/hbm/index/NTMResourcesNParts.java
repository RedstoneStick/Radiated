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
    public static final DeferredItem<Item> INGOT_TITANIUM = ITEMS.register("ingot_titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_STEEL = ITEMS.register("ingot_steel",
            () -> new BasicTooltipItem(new Item.Properties(),
                    Component.translatable("item.hbm.ingot_steel.tooltip").withStyle(ChatFormatting.GRAY)));
    public static final DeferredItem<Item> INGOT_COBALT = ITEMS.register("ingot_cobalt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_FIREBRICK = ITEMS.register("ingot_firebrick",
            () -> new Item(new Item.Properties()));



    // Tars, Solid Fuels & Asbestos //
    public static final DeferredItem<Item> INGOT_ASBESTOS = ITEMS.register("ingot_asbestos",
            () -> new BasicTooltipItem(new Item.Properties(),
                    Component.translatable("item.hbm.ingot_asbestos.tooltip").withStyle(ChatFormatting.GRAY)));



    // Billets //
    public static final DeferredItem<Item> BILLET_COBALT = ITEMS.register("billet_cobalt",
            () -> new Item(new Item.Properties()));



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
    public static final DeferredItem<Item> POWDER_ASH_COAL = ITEMS.register("powder_ash.coal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWDER_ASH_WOOD = ITEMS.register("powder_ash.wood",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWDER_ASH_MISC = ITEMS.register("powder_ash.misc",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWDER_ASH_FLY = ITEMS.register("powder_ash.fly",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWDER_ASH_SOOT = ITEMS.register("powder_ash.soot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWDER_ASH_FULLERENE = ITEMS.register("powder_ash.fullerene",
            () -> new Item(new Item.Properties()));



    // Explosives N Compounds //
    public static final DeferredItem<Item> FIRECLAY_BALL = ITEMS.register("ball_fireclay",
            () -> new Item(new Item.Properties()));



    // Bedrock Ores //



    // Crystals //
    public static final DeferredItem<Item> FRAGMENT_COLTAN = ITEMS.register("fragment_coltan",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHUNK_ORE_RARE = ITEMS.register("chunk_ore.rare",
            () -> new Item(new Item.Properties()));



    // Fragments //



    // Nuggets //
    public static final DeferredItem<Item> NUGGET_COBALT = ITEMS.register("nugget_cobalt",
            () -> new Item(new Item.Properties()));



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
