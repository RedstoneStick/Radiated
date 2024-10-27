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
        basicItemWithSpecialTextureLoc(NTMResourcesNParts.TEST_ITEM.get(), "hbm:item/21/test_item");
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
