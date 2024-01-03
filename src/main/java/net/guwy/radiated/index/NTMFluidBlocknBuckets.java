package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.fluid.GaseousLiquidBlock;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMFluidBlocknBuckets {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    //Fluids
    public static final RegistryObject<LiquidBlock> UF6_BLOCK = BLOCKS.register("uf6_block",
            () -> new GaseousLiquidBlock(NTMFluids.SOURCE_UF6, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Item> UF6_BUCKET = ITEMS.register("uf6_bucket",
            () -> new BucketItem(NTMFluids.SOURCE_UF6, new Item.Properties().tab(NTMCreativeModeTabs.MACHINE_ITEMS_AND_FUEL)
                    .craftRemainder(Items.BUCKET).stacksTo(1)));



    public static final RegistryObject<LiquidBlock> STEAM_LOW_PRESSURE_BLOCK = BLOCKS.register("steam_low_pressure_block",
            () -> new GaseousLiquidBlock(NTMFluids.SOURCE_STEAM_LOW_PRESSURE, BlockBehaviour.Properties.copy(Blocks.WATER).noOcclusion()));

    public static final RegistryObject<Item> STEAM_LOW_PRESSURE_BUCKET = ITEMS.register("steam_low_pressure_bucket",
            () -> new BucketItem(NTMFluids.SOURCE_STEAM_LOW_PRESSURE, new Item.Properties().tab(NTMCreativeModeTabs.MACHINE_ITEMS_AND_FUEL)
                    .craftRemainder(Items.BUCKET).stacksTo(1)));



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
