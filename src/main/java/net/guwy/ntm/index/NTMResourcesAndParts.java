package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.guwy.ntm.content.items.MultiColorItem;
import net.guwy.ntm.content.items.RagItem;
import net.guwy.ntm.content.items.hazard_items.BasicHazardItem;
import net.guwy.ntm.content.items.hazard_items.BasicRadioactiveItem;
import net.guwy.ntm.enums.EBedrockOreByproducts;
import net.guwy.ntm.enums.EBedrockOreTypes;
import net.guwy.ntm.enums.EBedrockOres;
import net.guwy.ntm.enums.EDyeColors;
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
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NTM.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NTM.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NTM.MOD_ID);



    public static final RegistryObject<Item> INGOT_URANIUM = ITEMS.register("ingot_uranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.35));
    public static final RegistryObject<Item> INGOT_U233 = ITEMS.register("ingot_u233", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> INGOT_U235 = ITEMS.register("ingot_u235", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.0));
    public static final RegistryObject<Item> INGOT_U238 = ITEMS.register("ingot_u238", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.25));
    public static final RegistryObject<Item> INGOT_TH232 = ITEMS.register("ingot_th232", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.1));
    public static final RegistryObject<Item> INGOT_PLUTONIUM = ITEMS.register("ingot_plutonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> INGOT_PU238 = ITEMS.register("ingot_pu238", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            10.0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> INGOT_PU239 = ITEMS.register("ingot_pu239", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> INGOT_PU240 = ITEMS.register("ingot_pu240", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> INGOT_PU241 = ITEMS.register("ingot_pu241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            25));
    public static final RegistryObject<Item> INGOT_PU_MIX = ITEMS.register("ingot_pu_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            6.25));
    public static final RegistryObject<Item> INGOT_AM241 = ITEMS.register("ingot_am241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            8.5));
    public static final RegistryObject<Item> INGOT_AM242 = ITEMS.register("ingot_am242", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9.5));
    public static final RegistryObject<Item> INGOT_AM_MIX = ITEMS.register("ingot_am_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9));
    public static final RegistryObject<Item> INGOT_NEPTUNIUM = ITEMS.register("ingot_neptunium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

            pTooltipComponents.add(Component.translatable("item.ntm.ingot_neptunium.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_POLONIUM = ITEMS.register("ingot_polonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            75));
    public static final RegistryObject<Item> INGOT_TECHNETIUM = ITEMS.register("ingot_technetium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.75));
    public static final RegistryObject<Item> INGOT_CO60 = ITEMS.register("ingot_co60", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> INGOT_SR90 = ITEMS.register("ingot_sr90", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> INGOT_AU198 = ITEMS.register("ingot_au198", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> INGOT_PB209 = ITEMS.register("ingot_pb209", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            10000, 0, 0, true, false, true, false));
    public static final RegistryObject<Item> INGOT_RA226 = ITEMS.register("ingot_ra226", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> INGOT_TITANIUM = ITEMS.register("ingot_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_COPPER = ITEMS.register("ingot_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_RED_COPPER = ITEMS.register("ingot_red_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_ADVANCED_ALLOY = ITEMS.register("ingot_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_TUNGSTEN = ITEMS.register("ingot_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_ALUMINIUM = ITEMS.register("ingot_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_STEEL = ITEMS.register("ingot_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_TCALLOY = ITEMS.register("ingot_tcalloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_CDALLOY = ITEMS.register("ingot_cdalloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_LEAD = ITEMS.register("ingot_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_BISMUTH = ITEMS.register("ingot_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_ARSENIC = ITEMS.register("ingot_arsenic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_CALCIUM = ITEMS.register("ingot_calcium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_CADMIUM = ITEMS.register("ingot_cadmium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_TANTALIUM = ITEMS.register("ingot_tantalium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

            pTooltipComponents.add(Component.translatable("item.ntm.ingot_tantalium.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_NIOBIUM = ITEMS.register("ingot_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_BERYLLIUM = ITEMS.register("ingot_beryllium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_COBALT = ITEMS.register("ingot_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_BORON = ITEMS.register("ingot_boron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_GRAPHITE = ITEMS.register("ingot_graphite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_FIREBRICK = ITEMS.register("ingot_firebrick", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_DURA_STEEL = ITEMS.register("ingot_dura_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_POLYMER = ITEMS.register("ingot_polymer", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_BAKELITE = ITEMS.register("ingot_bakelite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_RUBBER = ITEMS.register("ingot_rubber", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_PC = ITEMS.register("ingot_pc", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_PVC = ITEMS.register("ingot_pvc", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_MUD = ITEMS.register("ingot_mud", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)
            , 1));
    public static final RegistryObject<Item> INGOT_SCHRARANIUM = ITEMS.register("ingot_schraranium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.5, 0, 0, false, false, true, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_schraranium.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_SCHRABIDIUM = ITEMS.register("ingot_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            15, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> INGOT_SCHRABIDATE = ITEMS.register("ingot_schrabidate", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            1.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> INGOT_MAGNETIZED_TUNGSTEN = ITEMS.register("ingot_magnetized_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_COMBINE_STEEL = ITEMS.register("ingot_combine_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_combine_steel.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_SOLINIUM = ITEMS.register("ingot_solinium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            17.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> INGOT_GH336 = ITEMS.register("ingot_gh336", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_gh336.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_URANIUM_FUEL = ITEMS.register("ingot_uranium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.5));
    public static final RegistryObject<Item> INGOT_THORIUM_FUEL = ITEMS.register("ingot_thorium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.75));
    public static final RegistryObject<Item> INGOT_PLUTONIUM_FUEL = ITEMS.register("ingot_plutonium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.25));
    public static final RegistryObject<Item> INGOT_NEPTUNIUM_FUEL = ITEMS.register("ingot_neptunium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.5));
    public static final RegistryObject<Item> INGOT_MOX_FUEL = ITEMS.register("ingot_mox_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> INGOT_AMERICIUM_FUEL = ITEMS.register("ingot_americium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.75));
    public static final RegistryObject<Item> INGOT_SCHRABIDIUM_FUEL = ITEMS.register("ingot_schrabidium_fuel", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> INGOT_HES = ITEMS.register("ingot_hes", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85));
    public static final RegistryObject<Item> INGOT_LES = ITEMS.register("ingot_les", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.85));
    public static final RegistryObject<Item> INGOT_AUSTRALIUM = ITEMS.register("ingot_australium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> INGOT_LANTHANIUM = ITEMS.register("ingot_lanthanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_lanthanium.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_ACTINIUM = ITEMS.register("ingot_actinium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30));
    public static final RegistryObject<Item> INGOT_DESH = ITEMS.register("ingot_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_FERROURANIUM = ITEMS.register("ingot_ferrouranium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_STARMETAL = ITEMS.register("ingot_starmetal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INGOT_SATURNITE = ITEMS.register("ingot_saturnite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INGOT_EUPHEMIUM = ITEMS.register("ingot_euphemium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_euphemium.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_DINEUTRONIUM = ITEMS.register("ingot_dineutronium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_ELECTRONIUM = ITEMS.register("ingot_electronium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_SMORE = ITEMS.register("ingot_smore", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_OSMIRIDIUM = ITEMS.register("ingot_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INGOT_STEEL_DUSTED = ITEMS.register("ingot_steel_dusted", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.literal("Non Usable, for now").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    });
    public static final RegistryObject<Item> INGOT_CHAINSTEEL = ITEMS.register("ingot_chainsteel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_METEORITE = ITEMS.register("ingot_meteorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_METEORITE_FORGED = ITEMS.register("ingot_meteorite_forged", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BLADE_METEORITE = ITEMS.register("blade_meteorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_PHOSPHORUS = ITEMS.register("ingot_phosphorus", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> LITHIUM = ITEMS.register("lithium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> INGOT_ZIRCONIUM = ITEMS.register("ingot_zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> INGOT_SEMTEX = ITEMS.register("ingot_semtex", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_semtex.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_semtex.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_semtex.tooltip.3"));
        }
    });
    public static final RegistryObject<Item> INGOT_C4 = ITEMS.register("ingot_c4", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_CRUDE = ITEMS.register("oil_tar.crude", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_CRACK = ITEMS.register("oil_tar.crack", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_COAL = ITEMS.register("oil_tar.coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_WOOD = ITEMS.register("oil_tar.wood", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_WAX = ITEMS.register("oil_tar.wax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> OIL_TAR_PARAFFIN = ITEMS.register("oil_tar.paraffin", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
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
    public static final RegistryObject<Item> INGOT_FIBERGLASS = ITEMS.register("ingot_fiberglass", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_fiberglass.tooltip"));
        }
    });
    public static final RegistryObject<Item> INGOT_ASBESTOS = ITEMS.register("ingot_asbestos", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 1, false, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.ingot_asbestos.tooltip"));
        }
    });
    public static final RegistryObject<Item> BILLET_URANIUM = ITEMS.register("billet_uranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.175));
    public static final RegistryObject<Item> BILLET_U233 = ITEMS.register("billet_u233", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> BILLET_U235 = ITEMS.register("billet_u235", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.5));
    public static final RegistryObject<Item> BILLET_U238 = ITEMS.register("billet_u238", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.125));
    public static final RegistryObject<Item> BILLET_TH232 = ITEMS.register("billet_th232", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.05));
    public static final RegistryObject<Item> BILLET_PLUTONIUM = ITEMS.register("billet_plutonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> BILLET_PU238 = ITEMS.register("billet_pu238", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> BILLET_PU239 = ITEMS.register("billet_pu239", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.5));
    public static final RegistryObject<Item> BILLET_PU240 = ITEMS.register("billet_pu240", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> BILLET_PU241 = ITEMS.register("billet_pu241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            12.5));
    public static final RegistryObject<Item> BILLET_PU_MIX = ITEMS.register("billet_pu_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.125));
    public static final RegistryObject<Item> BILLET_AM241 = ITEMS.register("billet_am241", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.25));
    public static final RegistryObject<Item> BILLET_AM242 = ITEMS.register("billet_am242", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.75));
    public static final RegistryObject<Item> BILLET_AM_MIX = ITEMS.register("billet_am_mix", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.5));
    public static final RegistryObject<Item> BILLET_NEPTUNIUM = ITEMS.register("billet_neptunium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.25));
    public static final RegistryObject<Item> BILLET_POLONIUM = ITEMS.register("billet_polonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            37.5));
    public static final RegistryObject<Item> BILLET_TECHNETIUM = ITEMS.register("billet_technetium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.375));

    public static final RegistryObject<Item> BILLET_COBALT = ITEMS.register("billet_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_CO60 = ITEMS.register("billet_co60", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> BILLET_SR90 = ITEMS.register("billet_sr90", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> BILLET_AU198 = ITEMS.register("billet_au198", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            250, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> BILLET_PB209 = ITEMS.register("billet_pb209", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5000, 0, 0, true, false, true, false));
    public static final RegistryObject<Item> BILLET_RA226 = ITEMS.register("billet_ra226", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3.75));
    public static final RegistryObject<Item> BILLET_ACTINIUM = ITEMS.register("billet_actinium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15));
    public static final RegistryObject<Item> BILLET_SCHRABIDIUM = ITEMS.register("billet_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            7.5, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> BILLET_SOLINIUM = ITEMS.register("billet_solinium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            8.75, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> BILLET_GH336 = ITEMS.register("billet_gh336", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            2.5){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.billet_gh336.tooltip"));
        }
    });
    public static final RegistryObject<Item> BILLET_AUSTRALIUM = ITEMS.register("billet_australium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BILLET_AUSTRALIUM_LESSER = ITEMS.register("billet_australium_lesser", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BILLET_AUSTRALIUM_GREATER = ITEMS.register("billet_australium_greater", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BILLET_URANIUM_FUEL = ITEMS.register("billet_uranium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.25));
    public static final RegistryObject<Item> BILLET_THORIUM_FUEL = ITEMS.register("billet_thorium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.875));
    public static final RegistryObject<Item> BILLET_PLUTONIUM_FUEL = ITEMS.register("billet_plutonium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.125));
    public static final RegistryObject<Item> BILLET_NEPTUNIUM_FUEL = ITEMS.register("billet_neptunium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.75));
    public static final RegistryObject<Item> BILLET_MOX_FUEL = ITEMS.register("billet_mox_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.25));
    public static final RegistryObject<Item> BILLET_AMERICIUM_FUEL = ITEMS.register("billet_americium_fuel", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.375));
    public static final RegistryObject<Item> BILLET_LES = ITEMS.register("billet_les", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925));
    public static final RegistryObject<Item> BILLET_SCHRABIDIUM_FUEL = ITEMS.register("billet_schrabidium_fuel", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925, 0, 0, false, false, true, false));
    public static final RegistryObject<Item> BILLET_HES = ITEMS.register("billet_hes", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            2.925));
    public static final RegistryObject<Item> BILLET_PO210BE = ITEMS.register("billet_po210be", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            112.5));
    public static final RegistryObject<Item> BILLET_RA226BE = ITEMS.register("billet_ra226be", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            11.25));
    public static final RegistryObject<Item> BILLET_PU238BE = ITEMS.register("billet_pu238be", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            15));
    public static final RegistryObject<Item> BILLET_BERYLLIUM = ITEMS.register("billet_beryllium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_BISMUTH = ITEMS.register("billet_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_ZIRCONIUM = ITEMS.register("billet_zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_ZFB_BISMUTH = ITEMS.register("billet_zfb_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_ZFB_PU241 = ITEMS.register("billet_zfb_pu241", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_ZFB_AM_MIX = ITEMS.register("billet_zfb_am_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_YHARONITE = ITEMS.register("billet_yharonite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BILLET_BALEFIRE_GOLD = ITEMS.register("billet_balefire_gold", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON),
            250));
    public static final RegistryObject<Item> BILLET_FLASHLEAD = ITEMS.register("billet_flashlead", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON),
            6250, 0, 0, true, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.billet_flashlead.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.billet_flashlead.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> BILLET_NUCLEAR_WASTE = ITEMS.register("billet_nuclear_waste", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> CINNEBAR = ITEMS.register("cinnebar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_MERCURY_TINY = ITEMS.register("nugget_mercury_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> NUGGET_MERCURY = ITEMS.register("nugget_mercury", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BOTTLE_MERCURY = ITEMS.register("bottle_mercury", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COKE_COAL = ITEMS.register("coke.coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> COKE_LIGNITE = ITEMS.register("coke.lignite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 16; // 16 Items
        }
    });
    public static final RegistryObject<Item> COKE_PETROLEUM = ITEMS.register("coke.petroleum", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
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
    public static final RegistryObject<Item> COAL_INFERNAL = ITEMS.register("coal_infernal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 24; // 24 Items
        }
    });
    public static final RegistryObject<Item> BRIQUETTE_COAL = ITEMS.register("briquette.coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 10; // 10 Items
        }
    });
    public static final RegistryObject<Item> BRIQUETTE_LIGNITE = ITEMS.register("briquette.lignite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 8; // 8 Items
        }
    });
    public static final RegistryObject<Item> BRIQUETTE_WOOD = ITEMS.register("briquette.wood", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 2; // 2 Items
        }
    });
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> SALPETER = ITEMS.register("salpeter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_COAL = ITEMS.register("powder_coal", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 9, 0, false, false, false, false){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 8; // 8 Items
        }
    });
    public static final RegistryObject<Item> POWDER_COAL_TINY = ITEMS.register("powder_coal_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 1, 0, false, false, false, false));
    public static final RegistryObject<Item> POWDER_IRON = ITEMS.register("powder_iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_GOLD = ITEMS.register("powder_gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_LAPIS = ITEMS.register("powder_lapis", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_QUARTZ = ITEMS.register("powder_quartz", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_DIAMOND = ITEMS.register("powder_diamond", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_EMERALD = ITEMS.register("powder_emerald", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_URANIUM = ITEMS.register("powder_uranium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.05));
    public static final RegistryObject<Item> POWDER_PLUTONIUM = ITEMS.register("powder_plutonium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22.5));
    public static final RegistryObject<Item> POWDER_NEPTUNIUM = ITEMS.register("powder_neptunium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> POWDER_POLONIUM = ITEMS.register("powder_polonium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            225, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_CO60 = ITEMS.register("powder_co60", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            90, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_SR90 = ITEMS.register("powder_sr90", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> POWDER_SR90_TINY = ITEMS.register("powder_sr90_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            4.5, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> POWDER_I131 = ITEMS.register("powder_i131", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            450, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_I131_TINY = ITEMS.register("powder_i131_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_XE135 = ITEMS.register("powder_xe135", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            3750, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_XE135_TINY = ITEMS.register("powder_xe135_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            375, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_CAESIUM = ITEMS.register("powder_caesium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            60, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> POWDER_CS137_TINY = ITEMS.register("powder_cs137_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            6, 0, 0, true, true, false, false));
    public static final RegistryObject<Item> POWDER_AU198 = ITEMS.register("powder_au198", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_RA226 = ITEMS.register("powder_ra226", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22.5));
    public static final RegistryObject<Item> POWDER_ASTATINE = ITEMS.register("powder_astatine", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            22500, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> POWDER_TITANIUM = ITEMS.register("powder_titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_COPPER = ITEMS.register("powder_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_RED_COPPER = ITEMS.register("powder_red_copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_ADVANCED_ALLOY = ITEMS.register("powder_advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_TUNGSTEN = ITEMS.register("powder_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_ALUMINIUM = ITEMS.register("powder_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_STEEL = ITEMS.register("powder_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_STEEL_TINY = ITEMS.register("powder_steel_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_TCALLOY = ITEMS.register("powder_tcalloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_LEAD = ITEMS.register("powder_lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_BISMUTH = ITEMS.register("powder_bismuth", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CALCIUM = ITEMS.register("powder_calcium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CADMIUM = ITEMS.register("powder_cadmium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_COLTAN_ORE = ITEMS.register("powder_coltan_ore", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 3, false, false, false, false));
    public static final RegistryObject<Item> POWDER_COLTAN = ITEMS.register("powder_coltan", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_TANTALIUM = ITEMS.register("powder_tantalium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_tantalium.tootlip"));
        }
    });
    public static final RegistryObject<Item> POWDER_TEKTITE = ITEMS.register("powder_tektite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_PALEOGENITE = ITEMS.register("powder_paleogenite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_PALEOGENITE_TINY = ITEMS.register("powder_paleogenite_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_IMPURE_OSMIRIDIUM = ITEMS.register("powder_impure_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_BORAX = ITEMS.register("powder_borax", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CHLOROCALCYTE = ITEMS.register("powder_chlorocalcite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_YELLOWCAKE = ITEMS.register("powder_yellowcake", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).food(NTMFoods.YELLOWCAKE),
            1.05){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_yellowcake.tooltip"));
        }
    });
    public static final RegistryObject<Item> POWDER_BERYLLIUM = ITEMS.register("powder_beryllium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_DURA_STEEL = ITEMS.register("powder_dura_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_POLYMER = ITEMS.register("powder_polymer", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_BAKELITE = ITEMS.register("powder_bakelite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_SCHRABIDIUM = ITEMS.register("powder_schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            45, 0, 0, false, false, true   , false));
    public static final RegistryObject<Item> POWDER_SCHRABIDATE = ITEMS.register("powder_schrabidate", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.RARE),
            4.5, 0, 0, false, false, true   , false));

    public static final RegistryObject<Item> POWDER_MAGNETIZED_TUNGSTEN = ITEMS.register("powder_magnetized_tungsten", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CHLOROPHYTE = ITEMS.register("powder_chlorophyte", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_COMBINE_STEEL = ITEMS.register("powder_combine_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_LITHIUM = ITEMS.register("powder_lithium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> POWDER_LITHIUM_TINY = ITEMS.register("powder_lithium_tiny", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, true, false, false));
    public static final RegistryObject<Item> POWDER_ZIRCONIUM = ITEMS.register("powder_zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_LIGNITE = ITEMS.register("powder_lignite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 9, 0, false, false, false, false){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 * 6; // 6 Items
        }
    });
    public static final RegistryObject<Item> POWDER_NEODYMIUM = ITEMS.register("powder_neodymium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_NEODYMIUM_TINY = ITEMS.register("powder_neodymium_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_AUSTRALIUM = ITEMS.register("powder_australium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> POWDER_COBALT = ITEMS.register("powder_cobalt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_COBALT_TINY = ITEMS.register("powder_cobalt_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_NIOBIUM = ITEMS.register("powder_niobium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_NIOBIUM_TINY = ITEMS.register("powder_niobium_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CERIUM = ITEMS.register("powder_cerium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_CERIUM_TINY = ITEMS.register("powder_cerium_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_LANTHANIUM = ITEMS.register("powder_lanthanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_LANTHANIUM_TINY = ITEMS.register("powder_lanthanium_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_ACTINIUM = ITEMS.register("powder_actinium", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC),
            90));
    public static final RegistryObject<Item> POWDER_ACTINIUM_TINY = ITEMS.register("powder_actinium_tiny", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            9));
    public static final RegistryObject<Item> POWDER_BORON = ITEMS.register("powder_boron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POWDER_BORON_TINY = ITEMS.register("powder_boron_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_ASBESTOS = ITEMS.register("powder_asbestos", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 3, false, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_asbestos.tooltip"));
        }
    });

    public static final RegistryObject<Item> POWDER_MAGIC = ITEMS.register("powder_magic", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_CLOUD = ITEMS.register("powder_cloud", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_SAWDUST = ITEMS.register("powder_sawdust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> POWDER_FLUX = ITEMS.register("powder_flux", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_FERTILIZER = ITEMS.register("powder_fertilizer", () -> new BoneMealItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_BALEFIRE = ITEMS.register("powder_balefire", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            500));
    public static final RegistryObject<Item> POWDER_SEMTEX_MIX = ITEMS.register("powder_semtex_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_DESH_MIX = ITEMS.register("powder_desh_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_DESH_READY = ITEMS.register("powder_desh_ready", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_DESH = ITEMS.register("powder_desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_NITAN_MIX = ITEMS.register("powder_nitan_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_SPARK_MIX = ITEMS.register("powder_spark_mix", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_METEORITE = ITEMS.register("powder_meteorite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_METEORITE_TINY = ITEMS.register("powder_meteorite_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_EUPHEMIUM = ITEMS.register("powder_euphemium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.EPIC)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_euphemium.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.powder_euphemium.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> POWDER_DINEUTRONIUM = ITEMS.register("powder_dineutronium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> REDSTONE_DEPLETED = ITEMS.register("redstone_depleted", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> DUST = ITEMS.register("dust", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.dust.tooltip"));
        }
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> DUST_TINY = ITEMS.register("dust_tiny", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> FALLOUT = ITEMS.register("fallout", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            30));
    public static final RegistryObject<Item> POWDER_ASH_WOOD = ITEMS.register("powder_ash.wood", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> POWDER_ASH_COAL = ITEMS.register("powder_ash.coal", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200; // 1 Items
        }
    });
    public static final RegistryObject<Item> POWDER_ASH_MISC = ITEMS.register("powder_ash.misc", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200 / 2; // 0.5 Items
        }
    });
    public static final RegistryObject<Item> POWDER_RED_PHOSPHORUS = ITEMS.register("powder_red_phosphorus", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, true, false, false, false){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_red_phosphorus.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.powder_red_phosphorus.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> POWDER_ICE = ITEMS.register("powder_ice", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_POISON = ITEMS.register("powder_poison", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.powder_poison.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.powder_poison.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> POWDER_THERMITE = ITEMS.register("powder_thermite", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> POWDER_ENERGY = ITEMS.register("powder_energy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CORDITE = ITEMS.register("cordite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> BALLISTITE = ITEMS.register("ballistite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> BALL_DYNAMITE = ITEMS.register("ball_dynamite", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0, 0, 0, false, false, false, true));
    public static final RegistryObject<Item> BALL_TNT = ITEMS.register("ball_tnt", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BALL_TATB = ITEMS.register("ball_tatb", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> BALL_FIRECLAY = ITEMS.register("ball_fireclay", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item>[] ORE_BEDROCK = registerBedrockOres();
    public static final RegistryObject<Item>[] ORE_BEDROCK_BYPRODUCT = registerBedrockByproducts();
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
    public static final RegistryObject<Item> CRYSTAL_CINNEBAR = ITEMS.register("crystal_cinnebar", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> CRYSTAL_TRIXITE = ITEMS.register("crystal_trixite", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            250));
    public static final RegistryObject<Item> CRYSTAL_OSMIRIDIUM = ITEMS.register("crystal_osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> GEM_TANTALIUM = ITEMS.register("gem_tantalium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.gem_tantalium.tooltip"));
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
            pTooltipComponents.add(Component.translatable("item.ntm.nugget_tantalium.tooltip"));
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
            pTooltipComponents.add(Component.translatable("item.ntm.nugget_gh336.tooltip"));
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
            pTooltipComponents.add(Component.translatable("item.ntm.nugget_euphemium.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.nugget_euphemium.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.ntm.nugget_euphemium.tooltip.3"));
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
            pTooltipComponents.add(Component.translatable("item.ntm.plate_bismuth.tooltip"));
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
    public static final RegistryObject<Item> PLATE_CAST_IRON = ITEMS.register("plate_cast.iron", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_GOLD = ITEMS.register("plate_cast.gold", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_SCHRABIDIUM = ITEMS.register("plate_cast.schrabidium", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            45, 0, 0, false ,false, true, false));
    public static final RegistryObject<Item> PLATE_CAST_TITANIUM = ITEMS.register("plate_cast.titanium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_COPPER = ITEMS.register("plate_cast.copper", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ALUMINIUM = ITEMS.register("plate_cast.aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_LEAD = ITEMS.register("plate_cast.lead", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ZIRCONIUM = ITEMS.register("plate_cast.zirconium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_OSMIRIDIUM = ITEMS.register("plate_cast.osmiridium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_STEEL = ITEMS.register("plate_cast.steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_ADVANCED_ALLOY = ITEMS.register("plate_cast.advanced_alloy", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_DESH = ITEMS.register("plate_cast.desh", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_TECHNETIUM_STEEL = ITEMS.register("plate_cast.technetium_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_CADMIUM_STEEL = ITEMS.register("plate_cast.cadmium_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> PLATE_CAST_COMBINE_STEEL = ITEMS.register("plate_cast.combine_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
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
            pTooltipComponents.add(Component.translatable("item.ntm.plant_item.mustardwillow.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.plant_item.mustardwillow.tooltip.2"));
        }
    });
    public static final RegistryObject<Item> ENTANGLEMENT_KIT = ITEMS.register("entanglement_kit", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.entanglement_kit.tooltip.1"));
            pTooltipComponents.add(Component.translatable("item.ntm.entanglement_kit.tooltip.2"));
            pTooltipComponents.add(Component.translatable("item.ntm.entanglement_kit.tooltip.3"));
        }
    });
    public static final RegistryObject<Item> COMPONENT_LIMITER = ITEMS.register("component_limiter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> COMPONENT_EMITTER = ITEMS.register("component_emitter", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_SMALL_STEEL = ITEMS.register("hull_small_steel", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));
    public static final RegistryObject<Item> HULL_SMALL_ALUMINIUM = ITEMS.register("hull_small_aluminium", () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)){
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            pTooltipComponents.add(Component.translatable("item.ntm.hull_small_aluminium.tooltip"));
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
        RegistryObject<?>[] toReturn = new RegistryObject[EDyeColors.values().length];
        EnumSet.allOf(EDyeColors.class).forEach(dye -> {
            String name = "dye." + unlocalizedName + "." + dye.dictName;
            toReturn[dye.ordinal()] = ITEMS.register(name, () -> new MultiColorItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), -1, dye.color));
        });
        return (RegistryObject<T>[]) toReturn;
    }
    private static <T extends Item> RegistryObject<T>[] registerBedrockOres(){
        RegistryObject<?>[] toReturn = new RegistryObject[EBedrockOres.values().length * EBedrockOreTypes.values().length];
        EnumSet.allOf(EBedrockOreTypes.class).forEach(type -> {
            EnumSet.allOf(EBedrockOres.class).forEach(ore -> {
                String name = "ore." + type.oreName + "." + ore.oreName;
                toReturn[(type.ordinal() * EBedrockOres.values().length) + ore.ordinal()]
                = ITEMS.register(name, () -> new MultiColorItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), -1, ore.color){
                    // Code formatted name cuz i'm lazy
                    @Override
                    public Component getName(ItemStack pStack) {
                        String typeNameResourceLocation = "item.ntm.bedrock_ore.type." + type.oreName;
                        String oreNameResourceLocation = "item.ntm.bedrock_ore.ore." + ore.oreName;
                        return Component.literal(Component.translatable(typeNameResourceLocation).getString()
                                + " " + Component.translatable(oreNameResourceLocation).getString()
                                + " " + Component.translatable("item.ntm.bedrock_ore.postfix").getString());
                    }
                });
            });
        });

        return (RegistryObject<T>[]) toReturn;
    }
    private static <T extends Item> RegistryObject<T>[] registerBedrockByproducts(){
        RegistryObject<?>[] toReturn = new RegistryObject[EBedrockOreByproducts.values().length];
        EnumSet.allOf(EBedrockOreByproducts.class).forEach(byproduct -> {
            String name = "byproduct." + byproduct.oreName;
            toReturn[byproduct.ordinal()] = ITEMS.register(name, () -> new MultiColorItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS), byproduct.color){
                // Code formatted name cuz i'm lazy
                @Override
                public Component getName(ItemStack pStack) {
                    String oreNameResourceLocation = "item.ntm.bedrock_ore.byproduct." + byproduct.oreName;
                    return Component.literal(Component.translatable("item.ntm.bedrock_ore.byproduct.prefix").getString()
                            + " " + Component.translatable(oreNameResourceLocation).getString()
                            + " " + Component.translatable("item.ntm.bedrock_ore.byproduct.postfix").getString());
                }
            });
        });
        return (RegistryObject<T>[]) toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
