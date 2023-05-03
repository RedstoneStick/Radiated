package net.guwy.radiated.mechanics.gasmask;

import net.guwy.radiated.index.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class VisorWearTick {
    private static final double OVERALL_MULTIPLIER = 0.5;   // used for adjusting overall work rate (timings below are for 1.0) (Use with tick call amount)

    private static final double SAND_ACCUMULATION_RATE = 0.0017 * OVERALL_MULTIPLIER;    // 0 to 1 in 10 min
    private static final double DIRT_ACCUMULATION_RATE = 0.0017 * OVERALL_MULTIPLIER;    // 0 to 1 in 10 min
    private static final double MUD_ACCUMULATION_RATE = 0.003 * OVERALL_MULTIPLIER;      // 0 to 1 in 5 min
    private static final double SOOT_ACCUMULATION_RATE = 0.017 * OVERALL_MULTIPLIER;    // 0 to 1 in 1 min

    private static final double WATER_CLEANSING_RATE_ABOVE_T = -0.1 * OVERALL_MULTIPLIER;
    private static final double WATER_CLEANSING_RATE_BELOW_T = -0.017 * OVERALL_MULTIPLIER;
    private static final double WATER_THRESHOLD = 0.2; // Used for water's effective accumulation and cleansing

    public static void process(Player player){
        ItemStack itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
        Level level = player.getLevel();

        if(itemStack.getItem() instanceof VisorItem){

            /** Processing of Screen Gunk **/

            // Get the block right under the player
            BlockPos pos = new BlockPos(player.getX(), player.getY() - 0.1, player.getZ());
            BlockState onBlock = level.getBlockState(pos);

            if(player.isUnderWater()){
                VisorItem.setOuterWater(itemStack, 1);

                // Water Cleans faster if there is a large quantity of gunk
                // and slower if there is less

                if(VisorItem.getOuterSand(itemStack) > WATER_THRESHOLD) VisorItem.addOuterSand(itemStack, WATER_CLEANSING_RATE_ABOVE_T);
                else VisorItem.addOuterSand(itemStack, WATER_CLEANSING_RATE_BELOW_T);

                if(VisorItem.getOuterDirt(itemStack) > WATER_THRESHOLD) VisorItem.addOuterDirt(itemStack, WATER_CLEANSING_RATE_ABOVE_T);
                else VisorItem.addOuterDirt(itemStack, WATER_CLEANSING_RATE_BELOW_T);

                if(VisorItem.getOuterMud(itemStack) > WATER_THRESHOLD) VisorItem.addOuterMud(itemStack, WATER_CLEANSING_RATE_ABOVE_T);
                else VisorItem.addOuterMud(itemStack, WATER_CLEANSING_RATE_BELOW_T);

                if(VisorItem.getOuterSoot(itemStack) > WATER_THRESHOLD) VisorItem.addOuterSoot(itemStack, WATER_CLEANSING_RATE_ABOVE_T);
                else VisorItem.addOuterSoot(itemStack, WATER_CLEANSING_RATE_BELOW_T);

            } else {

                // Increases the corresponding gunk type depending on the block the player is standing on
                if(onBlock.is(ModTags.Blocks.MASK_SAND)) VisorItem.addOuterSand(itemStack, SAND_ACCUMULATION_RATE);
                if(onBlock.is(ModTags.Blocks.MASK_DIRT)) VisorItem.addOuterDirt(itemStack, DIRT_ACCUMULATION_RATE);
                if(onBlock.is(ModTags.Blocks.MASK_MUD)) VisorItem.addOuterMud(itemStack, MUD_ACCUMULATION_RATE);
                if(onBlock.is(ModTags.Blocks.MASK_SOOT)) VisorItem.addOuterSoot(itemStack, SOOT_ACCUMULATION_RATE);

                // decreases the water accumulation on screen
                // faster if there is more water slower if there is less
                if(VisorItem.getOuterWater(itemStack) > WATER_THRESHOLD) VisorItem.addOuterWater(itemStack, WATER_CLEANSING_RATE_ABOVE_T);
                else VisorItem.addOuterWater(itemStack, WATER_CLEANSING_RATE_BELOW_T);
            }

            // Debug
            player.sendSystemMessage(Component.literal("sand: " + VisorItem.getOuterSand(itemStack)));
            player.sendSystemMessage(Component.literal("dirt: " + VisorItem.getOuterDirt(itemStack)));
            player.sendSystemMessage(Component.literal("mud: " + VisorItem.getOuterMud(itemStack)));
            player.sendSystemMessage(Component.literal("sooth: " + VisorItem.getOuterSoot(itemStack)));
            player.sendSystemMessage(Component.literal("water: " + VisorItem.getOuterWater(itemStack)));
            player.sendSystemMessage(Component.literal("block: " + onBlock.getBlock().getName().getString()));
            player.sendSystemMessage(Component.literal("-----"));
        }
    }
}
