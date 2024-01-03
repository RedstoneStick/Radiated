package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.guwy.ntm.recipes.RTGDecayRecipe;
import net.guwy.ntm.recipes.UsageRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NTM.MOD_ID);

    public static final RegistryObject<RecipeSerializer<RTGDecayRecipe>> RTG_DECAY_SERIALIZER =
            SERIALIZERS.register("rtg_decay", () -> RTGDecayRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<UsageRecipe>> USAGE_RECIPE_SERIALIZER =
            SERIALIZERS.register("usage", () -> UsageRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
