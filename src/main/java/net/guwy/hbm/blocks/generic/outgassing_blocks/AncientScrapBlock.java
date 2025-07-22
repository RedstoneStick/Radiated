package net.guwy.hbm.blocks.generic.outgassing_blocks;

import net.minecraft.world.level.block.Blocks;

public class AncientScrapBlock extends OutgasBlock{
    public AncientScrapBlock(Properties properties) {
        //TODO block random ticks
        //TODO emits gas_radon_tomb
        super(properties, Blocks.AIR, 1, true, true);
    }
}
