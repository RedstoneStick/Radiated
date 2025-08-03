package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NTMCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NTMMain.MODID);

    public static final Supplier<CreativeModeTab> PARTS = CREATIVE_MODE_TAB.register("ntm_parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NTMResourcesNParts.RAW_URANIUM.get()))
                    .title(Component.translatable("itemGroup.hbm.parts"))
                    .displayItems((parameters, output) -> {
                        NTMResourcesNParts.ITEMS.getEntries().forEach((item) -> {
                            output.accept(item.get());
                        });
                    }).build());

    public static final Supplier<CreativeModeTab> CONTROL = CREATIVE_MODE_TAB.register("ntm_control",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_parts"))
                    .title(Component.translatable("itemGroup.hbm.control"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> TEMPLATE = CREATIVE_MODE_TAB.register("ntm_template",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_control"))
                    .title(Component.translatable("itemGroup.hbm.template"))
                    .displayItems((parameters, output) -> {
                        //output.accept(Blocks.BARRIER.asItem());
                    })
                    .withSearchBar().build());

    public static final Supplier<CreativeModeTab> BLOCKS = CREATIVE_MODE_TAB.register("ntm_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NTMOresNBlocks.ORE_URANIUM))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_template"))
                    .title(Component.translatable("itemGroup.hbm.blocks"))
                    .displayItems((parameters, output) -> {
                        NTMOresNBlocks.ITEMS.getEntries().forEach((item) -> {
                            output.accept(item.get());
                        });
                    }).build());

    public static final Supplier<CreativeModeTab> MACHINE = CREATIVE_MODE_TAB.register("ntm_machine",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_blocks"))
                    .title(Component.translatable("itemGroup.hbm.machine"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> NUKE = CREATIVE_MODE_TAB.register("ntm_nuke",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_machine"))
                    .title(Component.translatable("itemGroup.hbm.nuke"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    })
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "textures/gui/container/creative_inventory/tab_nuke.png"))
                    .withScrollBarSpriteLocation(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/creative_inventory/scroller_nuke")).build());

    public static final Supplier<CreativeModeTab> MISSILE = CREATIVE_MODE_TAB.register("ntm_missile",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_nuke"))
                    .title(Component.translatable("itemGroup.hbm.missile"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> WEAPON = CREATIVE_MODE_TAB.register("ntm_weapon",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_missile"))
                    .title(Component.translatable("itemGroup.hbm.weapon"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    })
                    .withScrollBarSpriteLocation(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/creative_inventory/scroller_weapon")).build());

    public static final Supplier<CreativeModeTab> CONSUMABLE = CREATIVE_MODE_TAB.register("ntm_consumable",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.BARRIER.asItem()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "ntm_weapon"))
                    .title(Component.translatable("itemGroup.hbm.consumable"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.BARRIER.asItem());
                    })
                    .withScrollBarSpriteLocation(ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "container/creative_inventory/scroller_consumable")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
