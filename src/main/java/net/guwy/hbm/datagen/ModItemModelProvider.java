package net.guwy.hbm.datagen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NTMMain.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(NTMResourcesNParts.TEST_ITEM.get());

        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_URANIUM.get(), "hbm:item/21/raw_uranium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_THORIUM.get(), "hbm:item/21/raw_thorium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_TITANIUM.get(), "hbm:item/21/raw_titanium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_TUNGSTEN.get(), "hbm:item/21/raw_tungsten");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_ALUMINIUM.get(), "hbm:item/21/raw_aluminium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_BERYLLIUM.get(), "hbm:item/21/raw_beryllium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_LEAD.get(), "hbm:item/21/raw_lead");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_AUSTRALIUM.get(), "hbm:item/21/raw_australium");
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.RAW_COBALT.get(), "hbm:item/21/raw_cobalt");
    }

    public ItemModelBuilder basicItemWithSpecialTextureLoc(Item item, String texture) {
        ResourceLocation itemResLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        ResourceLocation textureResLoc = ResourceLocation.parse(texture);
        return getBuilder(itemResLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", textureResLoc);
                //.texture("layer0", ResourceLocation.fromNamespaceAndPath(textureResLoc.getNamespace(), "item/" + textureResLoc.getPath()));
    }
}
