package net.guwy.ntm.datagen;

import net.guwy.ntm.NTM;
import net.guwy.ntm.enums.EBedrockOres;
import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Objects;

public class NTMItemModelProvider extends ItemModelProvider {
    public NTMItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NTM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Item> item : NTMResourcesAndParts.ITEMS.getEntries()){

            // Bedrock Ores (Model base texture change at the end of EBedrockOres to the next type)
            if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(0 * EBedrockOres.values().length, 1 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_bedrock", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(1 * EBedrockOres.values().length, 2 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_centrifuged", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(2 * EBedrockOres.values().length, 3 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_cleaned", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(3 * EBedrockOres.values().length, 4 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_separated", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(4 * EBedrockOres.values().length, 5 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_purified", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(5 * EBedrockOres.values().length, 6 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_nitrated", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(6 * EBedrockOres.values().length, 7 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_nitrocrystalline", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(7 * EBedrockOres.values().length, 8 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_deepcleaned", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(8 * EBedrockOres.values().length, 9 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_seared", "ore_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).toList().subList(9 * EBedrockOres.values().length, 10 * EBedrockOres.values().length)
                    .contains(item)) customColorLayeredItem(item.get(), "ore_enriched", "ore_overlay");

            // Byproducts for bedrock ores
            else if(Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK_BYPRODUCT).toList().contains(item)) customColorLayeredItem(item.get(), "byproduct");

            // Dyes
            else if(Arrays.stream(NTMResourcesAndParts.DYE_CHEM).toList().contains(item)) customColorLayeredItem(item.get(), "chemical_dye", "chemical_dye_overlay");
            else if(Arrays.stream(NTMResourcesAndParts.DYE_CRAYON).toList().contains(item)) customColorLayeredItem(item.get(), "crayon", "crayon_overlay");


            // Final check on the exclusion list for very specific scenarios (like custom models)
            else if(!ItemModelExclusionList.get().contains(item)) simpleItem(item.get());
        }
    }



    private ItemModelBuilder simpleItem(Item item)
    {
        ResourceLocation itemKey = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        return getBuilder(itemKey.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(itemKey.getNamespace(), "items/" + itemKey.getPath()));
    }

    /** @param layer dynamically colored layer*/
    private ItemModelBuilder customColorLayeredItem(Item item, String... layer)
    {
        ResourceLocation itemKey = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        ItemModelBuilder builder = getBuilder(itemKey.toString()).parent(new ModelFile.UncheckedModelFile("item/generated"));
        for(int i = 0; i < layer.length; i++){
            builder.texture(("layer" + i), new ResourceLocation(NTM.MOD_ID, "items/" + layer[i]));
        }
        return builder;
    }
}
