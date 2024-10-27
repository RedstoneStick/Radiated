package net.guwy.hbm.datagen;

import net.guwy.hbm.datagen.loot_tables.OreBlockLootTableRegistry;
import net.guwy.hbm.datagen.loot_tables.SimpleBlockLootTableRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);

        SimpleBlockLootTableRegistry.init();
        OreBlockLootTableRegistry.init();
    }

    /**
     * Do not use this to add loot tables, instead use the registry classes
     * @see SimpleBlockLootTableRegistry#init()
     * @see OreBlockLootTableRegistry#init()
     */
    @Override
    protected void generate() {
        SimpleBlockLootTableRegistry.selfDroppingBlockList.forEach(block -> {
            dropSelf(block);
        });
        SimpleBlockLootTableRegistry.itemDroppingBlockMap.forEach((minedBlock, item) -> {
            add(minedBlock,
                    block -> createItemFromBlockDrop(minedBlock, item));
        });
        SimpleBlockLootTableRegistry.itemDroppingBlockNoSilkTouchMap.forEach((minedBlock, item) -> {
            dropOther(minedBlock, item);
        });

        OreBlockLootTableRegistry.oreBlockToItemMap.forEach((oreBlock, item) -> {
            add(oreBlock,
                    block -> createOreDrop(oreBlock, item));
        });
        OreBlockLootTableRegistry.oreBlockToMultiItemMap.forEach((oreBlock, item) -> {
            add(oreBlock,
                    block -> createOreDrop(oreBlock, item,
                            OreBlockLootTableRegistry.oreBlockToMultiItemMinMap.get(oreBlock),
                            OreBlockLootTableRegistry.oreBlockToMultiItemMaxMap.get(oreBlock)));
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> list = new ArrayList<>();

        list.addAll(SimpleBlockLootTableRegistry.selfDroppingBlockList);
        list.addAll(SimpleBlockLootTableRegistry.itemDroppingBlockMap.keySet());
        list.addAll(SimpleBlockLootTableRegistry.itemDroppingBlockNoSilkTouchMap.keySet());

        list.addAll(OreBlockLootTableRegistry.oreBlockToItemMap.keySet());
        list.addAll(OreBlockLootTableRegistry.oreBlockToMultiItemMap.keySet());

        return list;
    }

    /**
     * Creates an ore loot table that'll drop between a min/max value.
     * Has the same name as the default {@link  BlockLootSubProvider#createOreDrop(Block, Item) createOreDrop()} for convenience
     * @param pBlock Block to drop when mined with silktouch
     * @param item Item to drop
     * @param minDrops Min amount of items to drop
     * @param maxDrops Max amount of items to drop
     */
    protected LootTable.Builder createOreDrop(Block pBlock, Item item, int minDrops, int maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    /**
     * Creates a loot table that'll drop a item.
     * If mined with Silk Touch it'll instead drop the block item
     * @param pBlock Block to drop when mined with silktouch
     * @param item Item to drop
     */
    protected LootTable.Builder createItemFromBlockDrop(Block pBlock, Item item) {
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)));
    }

    protected LootTable.Builder createOreDrop(Block pBlock, Item item, int maxDrops) {
        return this.createOreDrop(pBlock, item, 1, maxDrops);
    }
}
