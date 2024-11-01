package net.guwy.hbm.items;

import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CompassItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Random;

public class ColtanCompassItem extends Item {
    public ColtanCompassItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide) {

            long seed = level.getServer().overworld().getSeed();
            Random seededRandom = new Random(seed + 5);
            int randX = (int) (seededRandom.nextGaussian() * 1500);
            int randZ = (int) (seededRandom.nextGaussian() * 1500);
            int range = 750;

            player.sendSystemMessage(Component.literal("== Coltass =="));
            player.sendSystemMessage(Component.literal("seed: " + seed));
            player.sendSystemMessage(Component.literal("randX: " + randX));
            player.sendSystemMessage(Component.literal("randZ: " + randZ));
            player.sendSystemMessage(Component.literal("range: " + range));
            player.sendSystemMessage(Component.literal("============="));
        }

        return super.use(level, player, usedHand);
    }
}
