package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.NTMArmors;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.guwy.hbm.index.NTMTools;
import net.guwy.hbm.index.NTMWeapons;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NTMMain.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(NTMResourcesNParts.TEST_ITEM.get());

        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_URANIUM.get(), "hbm:item/21/raw_uranium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_THORIUM.get(), "hbm:item/21/raw_thorium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_TITANIUM.get(), "hbm:item/21/raw_titanium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_TUNGSTEN.get(), "hbm:item/21/raw_tungsten_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_ALUMINIUM.get(), "hbm:item/21/raw_aluminium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_BERYLLIUM.get(), "hbm:item/21/raw_beryllium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_LEAD.get(), "hbm:item/21/raw_lead_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_AUSTRALIUM.get(), "hbm:item/21/raw_australium_2");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_COBALT.get(), "hbm:item/21/raw_cobalt_2");

        basicItem(NTMResourcesNParts.SULFUR.get());
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.NITER.get(), "hbm:item/salpeter");
        basicItem(NTMResourcesNParts.FLUORITE.get());
        basicItem(NTMResourcesNParts.LIGNITE.get());
        basicItem(NTMResourcesNParts.INGOT_ASBESTOS.get());
        basicItem(NTMResourcesNParts.CHUNK_ORE_RARE.get());
        basicItem(NTMResourcesNParts.CINNEBAR.get());
        basicItem(NTMResourcesNParts.FRAGMENT_COLTAN.get());
        basicItem(NTMResourcesNParts.INGOT_TITANIUM.get());
        basicItem(NTMResourcesNParts.INGOT_STEEL.get());
        basicItem(NTMResourcesNParts.INGOT_COBALT.get());
        basicItem(NTMResourcesNParts.BILLET_COBALT.get());
        basicItem(NTMResourcesNParts.NUGGET_COBALT.get());
        basicItem(NTMResourcesNParts.INGOT_FIREBRICK.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_COAL.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_WOOD.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_MISC.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_FLY.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_SOOT.get());
        basicItem(NTMResourcesNParts.POWDER_ASH_FULLERENE.get());
        basicItem(NTMResourcesNParts.FIRECLAY_BALL.get());

        toolItem(NTMWeapons.REDSTONE_SWORD.get());
        largeToolItem(NTMWeapons.BIG_SWORD.get());
        toolItem(NTMWeapons.STEEL_SWORD.get());
        largeToolItem(NTMWeapons.TITANIUM_SWORD.get());
        largeToolItem(NTMWeapons.COBALT_SWORD.get());
        toolItem(NTMTools.STEEL_SHOVEL.get());
        toolItem(NTMTools.STEEL_PICKAXE.get());
        toolItem(NTMTools.STEEL_AXE.get());
        toolItem(NTMTools.STEEL_HOE.get());
        toolItem(NTMTools.COBALT_SHOVEL.get());
        toolItem(NTMTools.COBALT_PICKAXE.get());
        toolItem(NTMTools.COBALT_AXE.get());
        toolItem(NTMTools.COBALT_HOE.get());
        toolItem(NTMTools.TITANIUM_SHOVEL.get());
        toolItem(NTMTools.TITANIUM_PICKAXE.get());
        toolItem(NTMTools.TITANIUM_AXE.get());
        toolItem(NTMTools.TITANIUM_HOE.get());
        trimmedArmorItem(NTMArmors.STEEL_HELMET.get());
        trimmedArmorItem(NTMArmors.STEEL_PLATE.get());
        trimmedArmorItem(NTMArmors.STEEL_LEGS.get());
        trimmedArmorItem(NTMArmors.STEEL_BOOTS.get());
        trimmedArmorItem(NTMArmors.TITANIUM_HELMET.get());
        trimmedArmorItem(NTMArmors.TITANIUM_PLATE.get());
        trimmedArmorItem(NTMArmors.TITANIUM_LEGS.get());
        trimmedArmorItem(NTMArmors.TITANIUM_BOOTS.get());
        trimmedArmorItem(NTMArmors.COBALT_HELMET.get());
        trimmedArmorItem(NTMArmors.COBALT_PLATE.get());
        trimmedArmorItem(NTMArmors.COBALT_LEGS.get());
        trimmedArmorItem(NTMArmors.COBALT_BOOTS.get());
    }

    public ItemModelBuilder basicItemWithSpecialTextureLoc(Item item, String texture) {
        ResourceLocation itemResLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        ResourceLocation textureResLoc = ResourceLocation.parse(texture);
        return getBuilder(itemResLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", textureResLoc);
                //.texture("layer0", ResourceLocation.fromNamespaceAndPath(textureResLoc.getNamespace(), "item/" + textureResLoc.getPath()));
    }

    public ItemModelBuilder toolItem(Item item) {
        ResourceLocation itemResLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return getBuilder(itemResLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemResLoc.getNamespace(), "item/" + itemResLoc.getPath()));
    }

    public ItemModelBuilder largeToolItem(Item item) {
        ResourceLocation itemResLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return getBuilder(itemResLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("hbm:item/large_handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemResLoc.getNamespace(), "item/" + itemResLoc.getPath()));
    }



    private void trimmedArmorItem(Item item) {
        ResourceLocation itemResLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        List<ResourceKey<TrimMaterial>> trimMaterials = new ArrayList<>();
        trimMaterials.add(TrimMaterials.QUARTZ);
        trimMaterials.add(TrimMaterials.IRON);
        trimMaterials.add(TrimMaterials.NETHERITE);
        trimMaterials.add(TrimMaterials.REDSTONE);
        trimMaterials.add(TrimMaterials.COPPER);
        trimMaterials.add(TrimMaterials.GOLD);
        trimMaterials.add(TrimMaterials.EMERALD);
        trimMaterials.add(TrimMaterials.DIAMOND);
        trimMaterials.add(TrimMaterials.LAPIS);
        trimMaterials.add(TrimMaterials.AMETHYST);


        if(item instanceof ArmorItem armorItem) {

            trimMaterials.forEach(trimMaterial -> {
                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                //existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                String trimmedArmorPieceName = "item/trimmed_armor/" + itemResLoc.getPath() + "_" + trimMaterial.location().getPath() + "_trim";
                getBuilder(trimmedArmorPieceName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemResLoc.getNamespace(), "item/" + itemResLoc.getPath()))
                        .texture("layer1", ResourceLocation.parse("trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath()))
                ;
            });


            // Non trimmed armor, with default texture and trim_type overrides
            getBuilder(itemResLoc.toString())
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemResLoc.getNamespace(), "item/" + itemResLoc.getPath()))
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.QUARTZ.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.1f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.IRON.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.2f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.NETHERITE.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.3f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.REDSTONE.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.4f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.COPPER.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.5f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.GOLD.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.6f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.EMERALD.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.7f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.DIAMOND.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.8f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.LAPIS.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 0.9f).end()
                    .override().model(new ModelFile.UncheckedModelFile(itemResLoc.getNamespace() + ":item/trimmed_armor/" + itemResLoc.getPath() + "_" + TrimMaterials.AMETHYST.location().getPath() + "_trim")).predicate(ResourceLocation.parse("trim_type"), 1.0f).end()
            ;
        }
    }
}
