package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.DyeItem;
import net.guwy.radiated.content.items.RagItem;
import net.guwy.radiated.content.items.hazard_items.BasicHazardItem;
import net.guwy.radiated.content.items.hazard_items.BasicRadioactiveItem;
import net.guwy.radiated.enums.DyeColors;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
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
    public static final RegistryObject<Item> YELLOWCAKE = ITEMS.register("yellowcake", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).food(NTMFoods.YELLOWCAKE),
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
    public static final RegistryObject<Item> FIRECLAY = ITEMS.register("fireclay", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_IRON = ITEMS.register("ore_bedrock_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_COPPER = ITEMS.register("ore_bedrock_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_BORAX = ITEMS.register("ore_bedrock_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_ASBESTOS = ITEMS.register("ore_bedrock_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_NIOBIUM = ITEMS.register("ore_bedrock_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_TITANIUM = ITEMS.register("ore_bedrock_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_TUNGSTEN = ITEMS.register("ore_bedrock_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_GOLD = ITEMS.register("ore_bedrock_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_URANIUM = ITEMS.register("ore_bedrock_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_THORIUM = ITEMS.register("ore_bedrock_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_BEDROCK_CHLOROCALCITE = ITEMS.register("ore_bedrock_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_IRON = ITEMS.register("ore_centrifuged_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_COPPER = ITEMS.register("ore_centrifuged_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_BORAX = ITEMS.register("ore_centrifuged_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_ASBESTOS = ITEMS.register("ore_centrifuged_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_NIOBIUM = ITEMS.register("ore_centrifuged_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_TITANIUM = ITEMS.register("ore_centrifuged_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_TUNGSTEN = ITEMS.register("ore_centrifuged_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_GOLD = ITEMS.register("ore_centrifuged_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_URANIUM = ITEMS.register("ore_centrifuged_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_THORIUM = ITEMS.register("ore_centrifuged_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CENTRIFUGED_CHLOROCALCITE = ITEMS.register("ore_centrifuged_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_IRON = ITEMS.register("ore_cleaned_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_COPPER = ITEMS.register("ore_cleaned_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_BORAX = ITEMS.register("ore_cleaned_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_ASBESTOS = ITEMS.register("ore_cleaned_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_NIOBIUM = ITEMS.register("ore_cleaned_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_TITANIUM = ITEMS.register("ore_cleaned_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_TUNGSTEN = ITEMS.register("ore_cleaned_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_GOLD = ITEMS.register("ore_cleaned_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_URANIUM = ITEMS.register("ore_cleaned_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_THORIUM = ITEMS.register("ore_cleaned_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_CLEANED_CHLOROCALCITE = ITEMS.register("ore_cleaned_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_IRON = ITEMS.register("ore_separated_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_COPPER = ITEMS.register("ore_separated_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_BORAX = ITEMS.register("ore_separated_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_ASBESTOS = ITEMS.register("ore_separated_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_NIOBIUM = ITEMS.register("ore_separated_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_TITANIUM = ITEMS.register("ore_separated_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_TUNGSTEN = ITEMS.register("ore_separated_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_GOLD = ITEMS.register("ore_separated_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_URANIUM = ITEMS.register("ore_separated_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_THORIUM = ITEMS.register("ore_separated_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEPARATED_CHLOROCALCITE = ITEMS.register("ore_separated_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_IRON = ITEMS.register("ore_purified_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_COPPER = ITEMS.register("ore_purified_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_BORAX = ITEMS.register("ore_purified_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_ASBESTOS = ITEMS.register("ore_purified_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_NIOBIUM = ITEMS.register("ore_purified_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_TITANIUM = ITEMS.register("ore_purified_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_TUNGSTEN = ITEMS.register("ore_purified_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_GOLD = ITEMS.register("ore_purified_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_URANIUM = ITEMS.register("ore_purified_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_THORIUM = ITEMS.register("ore_purified_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_PURIFIED_CHLOROCALCITE = ITEMS.register("ore_purified_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_IRON = ITEMS.register("ore_nitrated_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_COPPER = ITEMS.register("ore_nitrated_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_BORAX = ITEMS.register("ore_nitrated_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_ASBESTOS = ITEMS.register("ore_nitrated_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_NIOBIUM = ITEMS.register("ore_nitrated_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_TITANIUM = ITEMS.register("ore_nitrated_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_TUNGSTEN = ITEMS.register("ore_nitrated_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_GOLD = ITEMS.register("ore_nitrated_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_URANIUM = ITEMS.register("ore_nitrated_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_THORIUM = ITEMS.register("ore_nitrated_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITRATED_CHLOROCALCITE = ITEMS.register("ore_nitrated_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_IRON = ITEMS.register("ore_nitrocrystalline_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_COPPER = ITEMS.register("ore_nitrocrystalline_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_BORAX = ITEMS.register("ore_nitrocrystalline_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_ASBESTOS = ITEMS.register("ore_nitrocrystalline_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_NIOBIUM = ITEMS.register("ore_nitrocrystalline_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_TITANIUM = ITEMS.register("ore_nitrocrystalline_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_TUNGSTEN = ITEMS.register("ore_nitrocrystalline_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_GOLD = ITEMS.register("ore_nitrocrystalline_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_URANIUM = ITEMS.register("ore_nitrocrystalline_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_THORIUM = ITEMS.register("ore_nitrocrystalline_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_NITROCRYSTALLINE_CHLOROCALCITE = ITEMS.register("ore_nitrocrystalline_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_IRON = ITEMS.register("ore_deepcleaned_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_COPPER = ITEMS.register("ore_deepcleaned_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_BORAX = ITEMS.register("ore_deepcleaned_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_ASBESTOS = ITEMS.register("ore_deepcleaned_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_NIOBIUM = ITEMS.register("ore_deepcleaned_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_TITANIUM = ITEMS.register("ore_deepcleaned_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_TUNGSTEN = ITEMS.register("ore_deepcleaned_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_GOLD = ITEMS.register("ore_deepcleaned_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_URANIUM = ITEMS.register("ore_deepcleaned_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_THORIUM = ITEMS.register("ore_deepcleaned_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_DEEPCLEANED_CHLOROCALCITE = ITEMS.register("ore_deepcleaned_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_IRON = ITEMS.register("ore_seared_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_COPPER = ITEMS.register("ore_seared_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_BORAX = ITEMS.register("ore_seared_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_ASBESTOS = ITEMS.register("ore_seared_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_NIOBIUM = ITEMS.register("ore_seared_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_TITANIUM = ITEMS.register("ore_seared_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_TUNGSTEN = ITEMS.register("ore_seared_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_GOLD = ITEMS.register("ore_seared_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_URANIUM = ITEMS.register("ore_seared_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_THORIUM = ITEMS.register("ore_seared_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_SEARED_CHLOROCALCITE = ITEMS.register("ore_seared_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_IRON = ITEMS.register("ore_enriched_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_COPPER = ITEMS.register("ore_enriched_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_BORAX = ITEMS.register("ore_enriched_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_ASBESTOS = ITEMS.register("ore_enriched_asbestos", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_NIOBIUM = ITEMS.register("ore_enriched_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_TITANIUM = ITEMS.register("ore_enriched_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_TUNGSTEN = ITEMS.register("ore_enriched_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_GOLD = ITEMS.register("ore_enriched_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_URANIUM = ITEMS.register("ore_enriched_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_THORIUM = ITEMS.register("ore_enriched_thorium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ORE_ENRICHED_CHLOROCALCITE = ITEMS.register("ore_enriched_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_IRON = ITEMS.register("byproduct_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_COPPER = ITEMS.register("byproduct_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_LITHIUM = ITEMS.register("byproduct_lithium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_SILICON = ITEMS.register("byproduct_silicon", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_LEAD = ITEMS.register("byproduct_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_TITANIUM = ITEMS.register("byproduct_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_ALUMINIUM = ITEMS.register("byproduct_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_SULFUR = ITEMS.register("byproduct_sulfur", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_CALCIUM = ITEMS.register("byproduct_calcium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_BISMUTH = ITEMS.register("byproduct_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_RADIUM = ITEMS.register("byproduct_radium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_TECHNETIUM = ITEMS.register("byproduct_technetium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_POLONIUM = ITEMS.register("byproduct_polonium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BYPRODUCT_URANIUM = ITEMS.register("byproduct_uranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_COAL = ITEMS.register("crystal_coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_IRON = ITEMS.register("crystal_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_GOLD = ITEMS.register("crystal_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_REDSTONE = ITEMS.register("crystal_redstone", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_LAPIS = ITEMS.register("crystal_lapis", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_DIAMOND = ITEMS.register("crystal_diamond", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_URANIUM = ITEMS.register("crystal_uranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.5));
    public static final RegistryObject<Item> CRYSTAL_THORIUM = ITEMS.register("crystal_thorium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1));
    public static final RegistryObject<Item> CRYSTAL_PLUTONIUM = ITEMS.register("crystal_plutonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            75));
    public static final RegistryObject<Item> CRYSTAL_TITANIUM = ITEMS.register("crystal_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_SULFUR = ITEMS.register("crystal_sulfur", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_NITER = ITEMS.register("crystal_niter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_COPPER = ITEMS.register("crystal_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_TUNGSTEN = ITEMS.register("crystal_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_ALUMINIUM = ITEMS.register("crystal_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_FLUORITE = ITEMS.register("crystal_fluorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_BERYLLIUM = ITEMS.register("crystal_beryllium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_LEAD = ITEMS.register("crystal_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_SCHRARANIUM = ITEMS.register("crystal_schraranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            15));
    public static final RegistryObject<Item> CRYSTAL_SCHRABIDIUM = ITEMS.register("crystal_schrabidium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            150));
    public static final RegistryObject<Item> CRYSTAL_RARE = ITEMS.register("crystal_rare", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_PHOSPHORUS = ITEMS.register("crystal_phosphorus", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> CRYSTAL_LITHIUM = ITEMS.register("crystal_lithium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> CRYSTAL_COBALT = ITEMS.register("crystal_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_STARMETAL = ITEMS.register("crystal_starmetal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_CINNABAR = ITEMS.register("crystal_cinnabar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_TRIXITE = ITEMS.register("crystal_trixite", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            250));
    public static final RegistryObject<Item> CRYSTAL_OSMIRIDIUM = ITEMS.register("crystal_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> GEM_TANTALIUM = ITEMS.register("gem_tantalium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.gem_tantalium.tooltip"));
        }
    });
    public static final RegistryObject<Item> GEM_VOLCANIC = ITEMS.register("gem_volcanic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GEM_ALEXANDRITE = ITEMS.register("gem_alexandrite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_NEODYMIUM = ITEMS.register("fragment_neodymium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_COBALT = ITEMS.register("fragment_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_NIOBIUM = ITEMS.register("fragment_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_CERIUM = ITEMS.register("fragment_cerium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_LANTHANIUM = ITEMS.register("fragment_lanthanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_ACTINIUM = ITEMS.register("fragment_actinium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_BORON = ITEMS.register("fragment_boron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_METEORITE = ITEMS.register("fragment_meteorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FRAGMENT_COLTAN = ITEMS.register("fragment_coltan", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BIOMASS = ITEMS.register("biomass", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BIOMASS_COMPRESSED = ITEMS.register("biomass_compressed", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BIO_WAFER = ITEMS.register("bio_wafer", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_URANIUM = ITEMS.register("nugget_uranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.035));
    public static final RegistryObject<Item> NUGGET_U233 = ITEMS.register("nugget_u233", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.5));
    public static final RegistryObject<Item> NUGGET_U235 = ITEMS.register("nugget_u235", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.1));
    public static final RegistryObject<Item> NUGGET_U238 = ITEMS.register("nugget_u238", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.025));
    public static final RegistryObject<Item> NUGGET_TH232 = ITEMS.register("nugget_th232", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.01));
    public static final RegistryObject<Item> NUGGET_PLUTONIUM = ITEMS.register("nugget_plutonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.75));
    public static final RegistryObject<Item> NUGGET_PU238 = ITEMS.register("nugget_pu238", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> NUGGET_PU239 = ITEMS.register("nugget_pu239", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.5));
    public static final RegistryObject<Item> NUGGET_PU240 = ITEMS.register("nugget_pu240", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.75));
    public static final RegistryObject<Item> NUGGET_PU241 = ITEMS.register("nugget_pu241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 2.5));
    public static final RegistryObject<Item> NUGGET_PU_MIX = ITEMS.register("nugget_pu_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.625));
    public static final RegistryObject<Item> NUGGET_AM241 = ITEMS.register("nugget_am241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.85));
    public static final RegistryObject<Item> NUGGET_AM242 = ITEMS.register("nugget_am242", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.95));
    public static final RegistryObject<Item> NUGGET_AM_MIX = ITEMS.register("nugget_am_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.9));
    public static final RegistryObject<Item> NUGGET_NEPTUNIUM = ITEMS.register("nugget_neptunium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.25));
    public static final RegistryObject<Item> NUGGET_POLONIUM = ITEMS.register("nugget_polonium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> NUGGET_COBALT = ITEMS.register("nugget_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_CO60 = ITEMS.register("nugget_co60", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> NUGGET_SR90 = ITEMS.register("nugget_sr90", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.5, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> NUGGET_TECHNETIUM = ITEMS.register("nugget_technetium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_AU198 = ITEMS.register("nugget_au198", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            50, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> NUGGET_PB209 = ITEMS.register("nugget_pb209", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1000, 0, 0, true, false, true, false));
    public static final RegistryObject<Item> NUGGET_RA226 = ITEMS.register("nugget_ra226", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.75));
    public static final RegistryObject<Item> NUGGET_ACTINIUM = ITEMS.register("nugget_actinium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 3));
    public static final RegistryObject<Item> NUGGET_LEAD = ITEMS.register("nugget_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_BISMUTH = ITEMS.register("nugget_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_ARSENIC = ITEMS.register("nugget_arsenic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_TANTALIUM = ITEMS.register("nugget_tantalium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.nugget_tantalium.tooltip"));
        }
    });
    public static final RegistryObject<Item> NUGGET_BERYLLIUM = ITEMS.register("nugget_beryllium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_SCHRABIDIUM = ITEMS.register("nugget_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            1.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> NUGGET_SOLINIUM = ITEMS.register("nugget_solinium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.75, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> NUGGET_GH336 = ITEMS.register("nugget_gh336", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC), 0.5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.nugget_gh336.tooltip"));
        }
    });
    public static final RegistryObject<Item> NUGGET_URANIUM_FUEL = ITEMS.register("nugget_uranium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.05));
    public static final RegistryObject<Item> NUGGET_THORIUM_FUEL = ITEMS.register("nugget_thorium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.175));
    public static final RegistryObject<Item> NUGGET_PLUTONIUM_FUEL = ITEMS.register("nugget_plutonium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.425));
    public static final RegistryObject<Item> NUGGET_NEPTUNIUM_FUEL = ITEMS.register("nugget_neptunium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.15));
    public static final RegistryObject<Item> NUGGET_MOX_FUEL = ITEMS.register("nugget_mox_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.25));
    public static final RegistryObject<Item> NUGGET_AMERICIUM_FUEL = ITEMS.register("nugget_americium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.475));
    public static final RegistryObject<Item> NUGGET_SCHRABIDIUM_FUEL = ITEMS.register("nugget_schrabidium_fuel", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.585, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> NUGGET_HES = ITEMS.register("nugget_hes", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.585));
    public static final RegistryObject<Item> NUGGET_LES = ITEMS.register("nugget_les", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), 0.585));
    public static final RegistryObject<Item> NUGGET_ZIRCONIUM = ITEMS.register("nugget_zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM = ITEMS.register("nugget_australium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM_LESSER = ITEMS.register("nugget_australium_lesser", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NUGGET_AUSTRALIUM_GREATER = ITEMS.register("nugget_australium_greater", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NUGGET_DESH = ITEMS.register("nugget_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_EUPHEMIUM = ITEMS.register("nugget_euphemium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.nugget_euphemium.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.nugget_euphemium.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.radiated.nugget_euphemium.tooltip.3"));
        }
    });
    public static final RegistryObject<Item> NUGGET_DINEUTRONIUM = ITEMS.register("nugget_dineutronium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_OSMIRIDIUM = ITEMS.register("nugget_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PLATE_IRON = ITEMS.register("plate_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_GOLD = ITEMS.register("plate_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_TITANIUM = ITEMS.register("plate_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ALUMINIUM = ITEMS.register("plate_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_STEEL = ITEMS.register("plate_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_LEAD = ITEMS.register("plate_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_COPPER = ITEMS.register("plate_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ADVANCED_ALLOY = ITEMS.register("plate_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NEUTRON_REFLECTOR = ITEMS.register("neutron_reflector", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_SCHRABIDIUM = ITEMS.register("plate_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            15, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> PLATE_COMBINE_STEEL = ITEMS.register("plate_combine_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_MIXED = ITEMS.register("plate_mixed", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_SATURNITE = ITEMS.register("plate_saturnite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PLATE_PAA = ITEMS.register("plate_paa", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PLATE_POLYMER = ITEMS.register("plate_polymer", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_KEVLAR = ITEMS.register("plate_kevlar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_DALEKANIUM = ITEMS.register("plate_dalekanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_DESH = ITEMS.register("plate_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_BISMUTH = ITEMS.register("plate_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.plate_bismuth.tooltip"));
        }
    });
    public static final RegistryObject<Item> PLATE_EUPHEMIUM = ITEMS.register("plate_euphemium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> PLATE_DINEUTRONIUM = ITEMS.register("plate_dineutronium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_TITANIUM = ITEMS.register("plate_armor_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_AJR = ITEMS.register("plate_armor_ajr", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_HEV = ITEMS.register("plate_armor_hev", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_LUNAR = ITEMS.register("plate_armor_lunar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_FAU = ITEMS.register("plate_armor_fau", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_ARMOR_DNT = ITEMS.register("plate_armor_dnt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_IRON = ITEMS.register("plate_cast_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_GOLD = ITEMS.register("plate_cast_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_SCHRABIDIUM = ITEMS.register("plate_cast_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, false ,false, true, false));
    public static final RegistryObject<Item> PLATE_CAST_TITANIUM = ITEMS.register("plate_cast_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_COPPER = ITEMS.register("plate_cast_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ALUMINIUM = ITEMS.register("plate_cast_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_LEAD = ITEMS.register("plate_cast_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ZIRCONIUM = ITEMS.register("plate_cast_zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_OSMIRIDIUM = ITEMS.register("plate_cast_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_STEEL = ITEMS.register("plate_cast_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ADVANCED_ALLOY = ITEMS.register("plate_cast_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_DESH = ITEMS.register("plate_cast_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_TECHNETIUM_STEEL = ITEMS.register("plate_cast_technetium_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_CADMIUM_STEEL = ITEMS.register("plate_cast_cadmium_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_COMBINE_STEEL = ITEMS.register("plate_cast_combine_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BOARD_COPPER = ITEMS.register("board_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BOLT_DURA_STEEL = ITEMS.register("bolt_dura_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BOLT_TUNGSTEN = ITEMS.register("bolt_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BOLT_COMPOUND = ITEMS.register("bolt_compound", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HAZMAT_CLOTH = ITEMS.register("hazmat_cloth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HAZMAT_CLOTH_RED = ITEMS.register("hazmat_cloth_red", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HAZMAT_CLOTH_GREY = ITEMS.register("hazmat_cloth_grey", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> ASBESTOS_CLOTH = ITEMS.register("asbestos_cloth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RAG = ITEMS.register("rag", () -> new RagItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RAG_DAMP = ITEMS.register("rag_damp", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RAG_PISS = ITEMS.register("rag_piss", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FILTER_COAL = ITEMS.register("filter_coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_ALUMINIUM = ITEMS.register("wire_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_COPPER = ITEMS.register("wire_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_TUNGSTEN = ITEMS.register("wire_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_RED_COPPER = ITEMS.register("wire_red_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_ADVANCED_ALLOY = ITEMS.register("wire_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_GOLD = ITEMS.register("wire_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> WIRE_SCHRABIDIUM = ITEMS.register("wire_schrabidium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE), 1.5));
    public static final RegistryObject<Item> WIRE_MAGNETIZED_TUNGSTEN = ITEMS.register("wire_magnetized_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_COPPER = ITEMS.register("coil_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_COPPER_TORUS = ITEMS.register("coil_copper_torus", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_ADVANCED_ALLOY = ITEMS.register("coil_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_ADVANCED_TORUS = ITEMS.register("coil_advanced_torus", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_GOLD = ITEMS.register("coil_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_GOLD_TORUS = ITEMS.register("coil_gold_torus", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_TUNGSTEN = ITEMS.register("coil_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COIL_MAGNETIZED_TUNGSTEN = ITEMS.register("coil_magnetized_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SAFETY_FUSE = ITEMS.register("safety_fuse", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> TANK_STEEL = ITEMS.register("tank_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MOTOR = ITEMS.register("motor", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MOTOR_DESH = ITEMS.register("motor_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MOTOR_BISMUTH = ITEMS.register("motor_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CENTRIFUGE_ELEMENT = ITEMS.register("centrifuge_element", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> MAGNET_CIRCULAR = ITEMS.register("magnet_circular", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> REACTOR_CORE = ITEMS.register("reactor_core", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RTG_UNIT = ITEMS.register("rtg_unit", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> LEVITATION_UNIT = ITEMS.register("levitation_unit", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PIPES_STEEL = ITEMS.register("pipes_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DRILL_TITANIUM = ITEMS.register("drill_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PHOTO_PANEL = ITEMS.register("photo_panel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CHLORINE_PINWHEEL = ITEMS.register("chlorine_pinwheel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> RING_STARMETAL = ITEMS.register("ring_starmetal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public Component getName(ItemStack pStack) {
            return ((MutableComponent) super.getName(pStack)).withStyle(ChatFormatting.BLUE);
        }
    });
    public static final RegistryObject<Item> DEUTERIUM_FILTER = ITEMS.register("deuterium_filter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item>[] DYE_CHEM = registerDyes("chem");
    public static final RegistryObject<Item>[] DYE_CRAYON = registerDyes("crayon");
    public static final RegistryObject<Item> PISTON_PNEUMATIC = ITEMS.register("piston_pneumatic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PISTON_HYDRAULIC = ITEMS.register("piston_hydraulic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PISTON_ELECTRIC = ITEMS.register("piston_electric", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PARTS_LEGENDARY_TIER1 = ITEMS.register("parts_legendary.tier1", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PARTS_LEGENDARY_TIER2 = ITEMS.register("parts_legendary.tier2", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PARTS_LEGENDARY_TIER3 = ITEMS.register("parts_legendary.tier3", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STIRLING_GEAR = ITEMS.register("stirling_gear", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> STIRLING_GEAR_STEEL = ITEMS.register("stirling_gear_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SAWMILL_SAW = ITEMS.register("sawmill_saw", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLANT_ITEM_TOBACCO = ITEMS.register("plant_item.tobacco", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLANT_ITEM_ROPE = ITEMS.register("plant_item.rope", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLANT_ITEM_MUSTARDWILLOW = ITEMS.register("plant_item.mustardwillow", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.plant_item.mustardwillow.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.plant_item.mustardwillow.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> ENTANGLEMENT_KIT = ITEMS.register("entanglement_kit", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.entanglement_kit.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.radiated.entanglement_kit.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.radiated.entanglement_kit.tooltip.3"));
        }
    });
    public static final RegistryObject<Item> COMPONENT_LIMITER = ITEMS.register("component_limiter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COMPONENT_EMITTER = ITEMS.register("component_emitter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_SMALL_STEEL = ITEMS.register("hull_small_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_SMALL_ALUMINIUM = ITEMS.register("hull_small_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.radiated.hull_small_aluminium.tooltip"));
        }
    });
    public static final RegistryObject<Item> HULL_BIG_STEEL = ITEMS.register("hull_big_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_BIG_ALUMINIUM = ITEMS.register("hull_big_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_BIG_TITANIUM = ITEMS.register("hull_big_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));








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

    private static <T extends Item> RegistryObject<T>[] registerDyes(String unlocalizedName){
        RegistryObject<?>[] toReturn = new RegistryObject[DyeColors.values().length];
        EnumSet.allOf(DyeColors.class).forEach(dye -> {
            String name = "dye." + unlocalizedName + "." + dye.dictName;
            toReturn[dye.ordinal()] = ITEMS.register(name, () -> new DyeItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), dye.color));
        });
        return (RegistryObject<T>[]) toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
