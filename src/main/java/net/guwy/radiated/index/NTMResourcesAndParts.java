package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.hazard_items.BasicHazardItem;
import net.guwy.radiated.content.items.hazard_items.BasicRadioactiveItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class NTMResourcesAndParts {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.35));
    public static final RegistryObject<Item> URANIUM_233_INGOT = ITEMS.register("uranium_233_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> URANIUM_235_INGOT = ITEMS.register("uranium_235_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.0));
    public static final RegistryObject<Item> URANIUM_238_INGOT = ITEMS.register("uranium_238_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.25));
    public static final RegistryObject<Item> THORIUM_232_INGOT = ITEMS.register("thorium_232_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.1));
    public static final RegistryObject<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> PLUTONIUM_238_INGOT = ITEMS.register("plutonium_238_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            10.0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> PLUTONIUM_239_INGOT = ITEMS.register("plutonium_239_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> PLUTONIUM_240_INGOT = ITEMS.register("plutonium_240_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> PLUTONIUM_241_INGOT = ITEMS.register("plutonium_241_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            25));
    public static final RegistryObject<Item> PLUTONIUM_RG_INGOT = ITEMS.register("plutonium_rg_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            6.25));
    public static final RegistryObject<Item> AMERICIUM_241_INGOT = ITEMS.register("americium_241_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            8.5));
    public static final RegistryObject<Item> AMERICIUM_242_INGOT = ITEMS.register("americium_242_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9.5));
    public static final RegistryObject<Item> AMERICIUM_RG_INGOT = ITEMS.register("americium_rg_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9));
    public static final RegistryObject<Item> NEPTUNIUM_INGOT = ITEMS.register("neptunium_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

            pTooltipComponents.add(Component.translatable("item.radiated.neptunium_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> POLONIUM_210_INGOT = ITEMS.register("polonium_210_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            75));
    public static final RegistryObject<Item> TECHNETIUM_99_INGOT = ITEMS.register("technetium_99_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.75));
    public static final RegistryObject<Item> COBALT_60_INGOT = ITEMS.register("cobalt_60_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> STRONTIUM_90_INGOT = ITEMS.register("strontium_90_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> GOLD_198_INGOT = ITEMS.register("gold_198_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> LEAD_209_INGOT = ITEMS.register("lead_209_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            10000, 0, 0, true, false, true, false));
    public static final RegistryObject<Item> RADIUM_226_INGOT = ITEMS.register("radium_226_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RED_COPPER_INGOT = ITEMS.register("red_copper_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ADVANCED_ALLOY_INGOT = ITEMS.register("advanced_alloy_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TECHNETIUM_STEEL_INGOT = ITEMS.register("technetium_steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CADMIUM_STEEL_INGOT = ITEMS.register("cadmium_steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ARSENIC_INGOT = ITEMS.register("arsenic_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

            pTooltipComponents.add(Component.translatable("item.radiated.tantalum_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> GRAPHITE_INGOT = ITEMS.register("graphite_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FIREBRICK = ITEMS.register("firebrick", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DURA_STEEL_INGOT = ITEMS.register("dura_steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POLYMER = ITEMS.register("polymer", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BAKELITE = ITEMS.register("bakelite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POLYCARBONATE = ITEMS.register("polycarbonate", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PVC = ITEMS.register("pvc", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WATZ_MUD = ITEMS.register("watz_mud", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)
            , 1));
    public static final RegistryObject<Item> SCHRARANIUM_INGOT = ITEMS.register("schraranium_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.5, 0, 0, false, false, true, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.schraranium_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> SCHRABIDIUM_INGOT = ITEMS.register("schrabidium_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            15, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> SCHRABIDATE_INGOT = ITEMS.register("schrabidate_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            1.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> MAGNETIZED_TUNGSTEN_INGOT = ITEMS.register("magnetized_tungsten_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CMB_STEEL_INGOT = ITEMS.register("cmb_steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.cmb_steel_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> SOLINIUM_INGOT = ITEMS.register("solinium_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            17.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> GHIORSIUM_336_INGOT = ITEMS.register("ghiorsium_336_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.ghiorsium_336_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> URANIUM_FUEL_INGOT = ITEMS.register("uranium_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.5));
    public static final RegistryObject<Item> THORIUM_FUEL_INGOT = ITEMS.register("thorium_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.75));
    public static final RegistryObject<Item> PLUTONIUM_FUEL_INGOT = ITEMS.register("plutonium_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.25));
    public static final RegistryObject<Item> NEPTUNIUM_FUEL_INGOT = ITEMS.register("neptunium_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.5));
    public static final RegistryObject<Item> MOX_FUEL_INGOT = ITEMS.register("mox_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> AMERICIUM_FUEL_INGOT = ITEMS.register("americium_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.75));
    public static final RegistryObject<Item> SCHRABIDIUM_FUEL_INGOT = ITEMS.register("schrabidium_fuel_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> HES_FUEL_INGOT = ITEMS.register("hes_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85));
    public static final RegistryObject<Item> LES_FUEL_INGOT = ITEMS.register("les_fuel_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85));
    public static final RegistryObject<Item> AUSTRALIUM_INGOT = ITEMS.register("australium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.lanthanum_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> ACTINIUM_227_INGOT = ITEMS.register("actinium_227_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30));
    public static final RegistryObject<Item> DESH_INGOT = ITEMS.register("desh_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FERROURANIUM_INGOT = ITEMS.register("ferrouranium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STARMETAL_INGOT = ITEMS.register("starmetal_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SATURNITE_INGOT = ITEMS.register("saturnite_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> EUPHEMIUM_INGOT = ITEMS.register("euphemium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.euphemium_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> DINEUTRONIUM_INGOT = ITEMS.register("dineutronium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ELECTRONIUM_INGOT = ITEMS.register("electronium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SMORE_INGOT = ITEMS.register("smore_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = ITEMS.register("osmiridium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> DUSTED_STEEL_INGOT = ITEMS.register("dusted_steel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.literal("Non Usable").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    });
    public static final RegistryObject<Item> CHAINSTEEL_INGOT = ITEMS.register("chainsteel_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> METEORITE_INGOT = ITEMS.register("meteorite_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FORGED_METEORITE_INGOT = ITEMS.register("forged_meteorite_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> METEORITE_BLADE = ITEMS.register("meteorite_blade", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PHOSPHORUS_INGOT = ITEMS.register("phosphorus_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SEMTEX_INGOT = ITEMS.register("semtex_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.semtex_ingot.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.semtex_ingot.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.radiated.semtex_ingot.tooltip.3"));
        }
    });
    public static final RegistryObject<Item> C4_INGOT = ITEMS.register("c4_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR = ITEMS.register("oil_tar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_CRACK = ITEMS.register("oil_tar_crack", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_COAL = ITEMS.register("oil_tar_coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_WOOD = ITEMS.register("oil_tar_wood", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_WAX = ITEMS.register("oil_tar_wax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_PARAFFIN = ITEMS.register("oil_tar_paraffin", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SOLID_FUEL = ITEMS.register("solid_fuel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> SOLID_FUEL_PRESTO = ITEMS.register("solid_fuel_presto", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 40; // 40 Items
        }
    });
    public static final RegistryObject<Item> SOLID_FUEL_PRESTO_TRIPLET = ITEMS.register("solid_fuel_presto_triplet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 200; // 200 Items
        }
    });
    public static final RegistryObject<Item> SOLID_FUEL_BF = ITEMS.register("solid_fuel_bf", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1000){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 160; // 160 Items
        }
    });
    public static final RegistryObject<Item> SOLID_FUEL_PRESTO_BF = ITEMS.register("solid_fuel_presto_bf", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2000){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 400; // 400 Items
        }
    });
    public static final RegistryObject<Item> SOLID_FUEL_PRESTO_TRIPLET_BF = ITEMS.register("solid_fuel_presto_triplet_bf", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            6000){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 2000; // 2000 Items
        }
    });
    public static final RegistryObject<Item> ROCKET_FUEL = ITEMS.register("rocket_fuel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 32; // 32 Items
        }
    });
    public static final RegistryObject<Item> FIBERGLASS_INGOT = ITEMS.register("fiberglass_ingot", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.fiberglass_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> ASBESTOS_INGOT = ITEMS.register("asbestos_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 1, false, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.asbestos_ingot.tooltip"));
        }
    });
    public static final RegistryObject<Item> URANIUM_BILLET = ITEMS.register("uranium_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.175));
    public static final RegistryObject<Item> URANIUM_233_BILLET = ITEMS.register("uranium_233_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> URANIUM_235_BILLET = ITEMS.register("uranium_235_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.5));
    public static final RegistryObject<Item> URANIUM_238_BILLET = ITEMS.register("uranium_238_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.125));
    public static final RegistryObject<Item> THORIUM_232_BILLET = ITEMS.register("thorium_232_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.05));
    public static final RegistryObject<Item> PLUTONIUM_BILLET = ITEMS.register("plutonium_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> PLUTONIUM_238_BILLET = ITEMS.register("plutonium_238_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> PLUTONIUM_239_BILLET = ITEMS.register("plutonium_239_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> PLUTONIUM_240_BILLET = ITEMS.register("plutonium_240_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> PLUTONIUM_241_BILLET = ITEMS.register("plutonium_241_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            12.5));
    public static final RegistryObject<Item> PLUTONIUM_RG_BILLET = ITEMS.register("plutonium_rg_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.125));
    public static final RegistryObject<Item> AMERICIUM_241_BILLET = ITEMS.register("americium_241_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.25));
    public static final RegistryObject<Item> AMERICIUM_242_BILLET = ITEMS.register("americium_242_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.75));
    public static final RegistryObject<Item> AMERICIUM_RG_BILLET = ITEMS.register("americium_rg_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.5));
    public static final RegistryObject<Item> NEPTUNIUM_BILLET = ITEMS.register("neptunium_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.25));
    public static final RegistryObject<Item> POLONIUM_210_BILLET = ITEMS.register("polonium_210_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            37.5));
    public static final RegistryObject<Item> TECHNETIUM_99_BILLET = ITEMS.register("technetium_99_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.375));

    public static final RegistryObject<Item> COBALT_BILLET = ITEMS.register("cobalt_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COBALT_60_BILLET = ITEMS.register("cobalt_60_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> STRONTIUM_90_BILLET = ITEMS.register("strontium_90_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> GOLD_198_BILLET = ITEMS.register("gold_198_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            250, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> LEAD_209_BILLET = ITEMS.register("lead_209_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5000, 0, 0, true, false, true, false));
    public static final RegistryObject<Item> RADIUM_226_BILLET = ITEMS.register("radium_226_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> ACTINIUM_227_BILLET = ITEMS.register("actinium_227_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15));
    public static final RegistryObject<Item> SCHRABIDIUM_BILLET = ITEMS.register("schrabidium_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            7.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> SOLINIUM_BILLET = ITEMS.register("solinium_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            8.75, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> GHIORSIUM_336_BILLET = ITEMS.register("ghiorsium_336_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            2.5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.ghiorsium_336_billet.tooltip"));
        }
    });
    public static final RegistryObject<Item> AUSTRALIUM_BILLET = ITEMS.register("australium_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> AUSTRALIUM_BILLET_LESSER = ITEMS.register("australium_billet_lesser", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> AUSTRALIUM_BILLET_GREATER = ITEMS.register("australium_billet_greater", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> URANIUM_FUEL_BILLET = ITEMS.register("uranium_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.25));
    public static final RegistryObject<Item> THORIUM_FUEL_BILLET = ITEMS.register("thorium_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.875));
    public static final RegistryObject<Item> PLUTONIUM_FUEL_BILLET = ITEMS.register("plutonium_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.125));
    public static final RegistryObject<Item> NEPTUNIUM_FUEL_BILLET = ITEMS.register("neptunium_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.75));
    public static final RegistryObject<Item> MOX_FUEL_BILLET = ITEMS.register("mox_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.25));
    public static final RegistryObject<Item> AMERICIUM_FUEL_BILLET = ITEMS.register("americium_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.375));
    public static final RegistryObject<Item> LES_FUEL_BILLET = ITEMS.register("les_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925));
    public static final RegistryObject<Item> SCHRABIDIUM_FUEL_BILLET = ITEMS.register("schrabidium_fuel_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> HES_FUEL_BILLET = ITEMS.register("hes_fuel_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925));
    public static final RegistryObject<Item> PO210BE_BILLET = ITEMS.register("po210be_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            112.5));
    public static final RegistryObject<Item> RA226BE_BILLET = ITEMS.register("ra226be_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            11.25));
    public static final RegistryObject<Item> PU238BE_BILLET = ITEMS.register("pu238be_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15));
    public static final RegistryObject<Item> BERYLLIUM_BILLET = ITEMS.register("beryllium_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BISMUTH_BILLET = ITEMS.register("bismuth_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ZIRCONIUM_BILLET = ITEMS.register("zirconium_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BISMUTH_ZFB_BILLET = ITEMS.register("bismuth_zfb_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLUTONIUM_241_ZFB_BILLET = ITEMS.register("plutonium_241_zfb_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> AMERICIUM_RG_ZFB_BILLET = ITEMS.register("americium_rg_zfb_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> YHARONITE_BILLET = ITEMS.register("yharonite_billet", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FLASHGOLD_BILLET = ITEMS.register("flashgold_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON),
            250));
    public static final RegistryObject<Item> FLASHLEAD_BILLET = ITEMS.register("flashlead_billet", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON),
            6250, 0, 0, true, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.flashlead_billet.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.flashlead_billet.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> NUCLEAR_WASTE_BILLET = ITEMS.register("nuclear_waste_billet", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MERCURY_NUGGET_TINY = ITEMS.register("mercury_nugget_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MERCURY_NUGGET = ITEMS.register("mercury_nugget", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MERCURY_BOTTLE = ITEMS.register("mercury_bottle", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> LIGNITE_COKE = ITEMS.register("lignite_coke", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> PETROLEUM_COKE = ITEMS.register("petroleum_coke", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> LIGNITE = ITEMS.register("lignite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 6; // 6 Items
        }
    });
    public static final RegistryObject<Item> INFERNAL_COAL = ITEMS.register("infernal_coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 24; // 24 Items
        }
    });
    public static final RegistryObject<Item> COAL_BRIQUETTE = ITEMS.register("coal_briquette", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 10; // 10 Items
        }
    });
    public static final RegistryObject<Item> LIGNITE_BRIQUETTE = ITEMS.register("lignite_briquette", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 8; // 8 Items
        }
    });
    public static final RegistryObject<Item> SAWDUST_BRIQUETTE = ITEMS.register("sawdust_briquette", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 2; // 2 Items
        }
    });
    public static final RegistryObject<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NITER_DUST = ITEMS.register("niter_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FLUORITE_DUST = ITEMS.register("fluorite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 9, 0, false, false, false, false){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 8; // 8 Items
        }
    });
    public static final RegistryObject<Item> COAL_DUST_TINY = ITEMS.register("coal_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 1, 0, false, false, false, false));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> QUARTZ_DUST = ITEMS.register("quartz_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> URANIUM_DUST = ITEMS.register("uranium_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.05));
    public static final RegistryObject<Item> PLUTONIUM_DUST = ITEMS.register("plutonium_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22.5));
    public static final RegistryObject<Item> NEPTUNIUM_DUST = ITEMS.register("neptunium_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> POLONIUM_DUST = ITEMS.register("polonium_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            225, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> COBALT_60_DUST = ITEMS.register("cobalt_60_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            90, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> STRONTIUM_90_DUST = ITEMS.register("strontium_90_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> STRONTIUM_90_DUST_TINY = ITEMS.register("strontium_90_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.5, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> IODINE_131_DUST = ITEMS.register("iodine_131_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            450, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> IODINE_131_DUST_TINY = ITEMS.register("iodine_131_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> XENON_135_DUST = ITEMS.register("xenon_135_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3750, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> XENON_135_DUST_TINY = ITEMS.register("xenon_135_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            375, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> CAESIUM_137_DUST = ITEMS.register("caesium_137_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            60, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> CAESIUM_137_DUST_TINY = ITEMS.register("caesium_137_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            6, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> GOLD_198_DUST = ITEMS.register("gold_198_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> RADIUM_226_DUST = ITEMS.register("radium_226_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22.5));
    public static final RegistryObject<Item> ASTATINE_209_DUST = ITEMS.register("astatine_209_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RED_COPPER_DUST = ITEMS.register("red_copper_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ADVANCED_ALLOY_DUST = ITEMS.register("advanced_alloy_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ALUMINIUM_DUST = ITEMS.register("aluminium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STEEL_DUST_TINY = ITEMS.register("steel_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TECHNETIUM_STEEL_DUST = ITEMS.register("technetium_steel_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BISMUTH_DUST = ITEMS.register("bismuth_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CALCIUM_DUST = ITEMS.register("calcium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CADMIUM_DUST = ITEMS.register("cadmium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COLTAN_ORE_DUST = ITEMS.register("coltan_ore_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 3, false, false, false, false));
    public static final RegistryObject<Item> COLTAN_DUST = ITEMS.register("coltan_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TANTALIUM_DUST = ITEMS.register("tantalium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.tantalium_dust.tootlip"));
        }
    });
    public static final RegistryObject<Item> TEKTITE_DUST = ITEMS.register("tektite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PALEOGENITE_DUST = ITEMS.register("paleogenite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PALEOGENITE_DUST_TINY = ITEMS.register("paleogenite_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> IMPURE_OSMIRIDIUM_DUST = ITEMS.register("impure_osmiridium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BORAX_DUST = ITEMS.register("borax_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CHLOROCALCYTE_DUST = ITEMS.register("chlorocalcite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> YELLOWCAKE = ITEMS.register("yellowcake", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).food(ModFoods.YELLOWCAKE),
            1.05){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.yellowcake.tooltip"));
        }
    });
    public static final RegistryObject<Item> BERYLLIUM_DUST = ITEMS.register("beryllium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DURA_STEEL_DUST = ITEMS.register("dura_steel_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POLYMER_DUST = ITEMS.register("polymer_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BAKELITE_DUST = ITEMS.register("bakelite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SCHRABIDIUM_DUST = ITEMS.register("schrabidium_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            45, 0, 0, false, false, true   , false));
    public static final RegistryObject<Item> SCHRABIDATE_DUST = ITEMS.register("schrabidate_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            4.5, 0, 0, false, false, true   , false));

    public static final RegistryObject<Item> MAGNETIZED_TUNGSTEN_DUST = ITEMS.register("magnetized_tungsten_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CHLOROPHYTE_DUST = ITEMS.register("chlorophyte_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CMB_STEEL_DUST = ITEMS.register("cmb_steel_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LITHIUM_DUST = ITEMS.register("lithium_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> LITHIUM_DUST_TINY = ITEMS.register("lithium_dust_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> ZIRCONIUM_DUST = ITEMS.register("zirconium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LIGNITE_DUST = ITEMS.register("lignite_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 9, 0, false, false, false, false){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 6; // 6 Items
        }
    });
    public static final RegistryObject<Item> NEODYMIUM_DUST = ITEMS.register("neodymium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> NEODYMIUM_DUST_TINY = ITEMS.register("neodymium_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> AUSTRALIUM_DUST = ITEMS.register("australium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COBALT_DUST = ITEMS.register("cobalt_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> COBALT_DUST_TINY = ITEMS.register("cobalt_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NIOBIUM_DUST = ITEMS.register("niobium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> NIOBIUM_DUST_TINY = ITEMS.register("niobium_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CERIUM_DUST = ITEMS.register("cerium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CERIUM_DUST_TINY = ITEMS.register("cerium_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LANTHANUM_DUST = ITEMS.register("lanthanum_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> LANTHANUM_DUST_TINY = ITEMS.register("lanthanum_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ACTINIUM_227_DUST = ITEMS.register("actinium_227_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            90));
    public static final RegistryObject<Item> ACTINIUM_227_DUST_TINY = ITEMS.register("actinium_227_dust_tiny", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9));
    public static final RegistryObject<Item> BORON_DUST = ITEMS.register("boron_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> BORON_DUST_TINY = ITEMS.register("boron_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ASBESTOS_DUST = ITEMS.register("asbestos_dust", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 3, false, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.asbestos_dust.tooltip"));
        }
    });

    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CLOUD_RESIDUE = ITEMS.register("cloud_residue", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SAWDUST = ITEMS.register("sawdust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> FLUX = ITEMS.register("flux", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INDUSTRIAL_FERTILIZER = ITEMS.register("industrial_fertilizer", () -> new BoneMealItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BALEFIRE_DUST = ITEMS.register("balefire_dust", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            500));
    public static final RegistryObject<Item> SEMTEX_MIX = ITEMS.register("semtex_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DESH_MIX = ITEMS.register("desh_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DESH_READY = ITEMS.register("desh_ready", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DESH_DUST = ITEMS.register("desh_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NITAN_MIX = ITEMS.register("nitan_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SPARK_MIX = ITEMS.register("spark_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> METEORITE_DUST = ITEMS.register("meteorite_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> METEORITE_DUST_TINY = ITEMS.register("meteorite_dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> EUPHEMIUM_DUST = ITEMS.register("euphemium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.euphemium_dust.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.euphemium_dust.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> DINEUTRONIUM_DUST = ITEMS.register("dineutronium_dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> REDSTONE_DEPLETED = ITEMS.register("redstone_depleted", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DUST = ITEMS.register("dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.dust.tooltip"));
        }
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> DUST_TINY = ITEMS.register("dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FALLOUT = ITEMS.register("fallout", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30));
    public static final RegistryObject<Item> ASH_WOOD = ITEMS.register("ash_wood", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> ASH_COAL = ITEMS.register("ash_coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200; // 1 Items
        }
    });
    public static final RegistryObject<Item> ASH_MISC = ITEMS.register("ash_misc", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> RED_PHOSPHORUS = ITEMS.register("red_phosphorus", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, true, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.red_phosphorus.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.red_phosphorus.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> CRYO_POWDER = ITEMS.register("cryo_powder", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POISON_POWDER = ITEMS.register("poison_powder", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.poison_powder.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.poison_powder.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> THERMITE = ITEMS.register("thermite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ENERGY_POWDER = ITEMS.register("energy_powder", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CORDITE = ITEMS.register("cordite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> BALLISTITE = ITEMS.register("ballistite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> DYNAMITE = ITEMS.register("dynamite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> TNT = ITEMS.register("tnt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TATB = ITEMS.register("tatb", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));








    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return NTMResourcesAndParts.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
