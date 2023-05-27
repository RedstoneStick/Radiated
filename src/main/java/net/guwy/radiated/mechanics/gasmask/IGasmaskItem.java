package net.guwy.radiated.mechanics.gasmask;

import net.guwy.radiated.content.items.FilterItem;
import net.guwy.radiated.index.RDTTools;
import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.ItemIdFix;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public interface IGasmaskItem {

    String TAG_FILTER_ID = "filter_id";
    String TAG_FILTER_DURABILITY = "filter_durability";



    static FilterItem getFilterItem(ItemStack gasmaskItem){
        return (FilterItem) Item.byId(ItemTagUtils.getInt(gasmaskItem, TAG_FILTER_ID));
    }



    static int getDurability(ItemStack gasmaskItem){
        return gasmaskItem.getMaxDamage() - gasmaskItem.getDamageValue();
    }

    static void setDurability(ItemStack gasmaskItem, int set){
        ItemTagUtils.putInt(gasmaskItem, TAG_FILTER_DURABILITY, set);
    }

    static void addDurability(ItemStack gasmaskItem, int add){
        int durability = ItemTagUtils.getInt(gasmaskItem, TAG_FILTER_DURABILITY);
        durability += add;
        ItemTagUtils.putInt(gasmaskItem, TAG_FILTER_DURABILITY, durability);
    }



    static void setFilter(Player player, ItemStack filterItem, InteractionHand interactionHand){
        ItemStack helmetItem = player.getItemBySlot(EquipmentSlot.HEAD);
        int filterId = ItemTagUtils.getInt(helmetItem, TAG_FILTER_ID);

        if(helmetItem.getItem() instanceof IGasmaskItem){
            // Check if the gas mask already has a filter
            if(filterId != 0){

                // If so, take it out
                takeFilterOut(player, helmetItem);
            }

            // Put the new filter in
            ItemTagUtils.putInt(helmetItem, TAG_FILTER_ID, Item.getId(filterItem.getItem()));
            ItemTagUtils.putInt(helmetItem, TAG_FILTER_DURABILITY, (filterItem.getMaxDamage() - filterItem.getDamageValue()));

            // Remove New Filter from player inventory
            player.setItemInHand(interactionHand, new ItemStack(Blocks.AIR));

            // Play Sound

        }
        // If player isn't wearing a gas mask, send them a message
        else {
            player.sendSystemMessage(Component.translatable("message.radiated.gas_mask.filter.fail"));
        }
    }



    static void takeFilterOut(Player player, ItemStack gasMaskItem){

        ItemStack itemStack = new ItemStack(Item.byId(ItemTagUtils.getInt(gasMaskItem, TAG_FILTER_ID)));
        itemStack.setDamageValue(itemStack.getMaxDamage() - ItemTagUtils.getInt(gasMaskItem, TAG_FILTER_DURABILITY));
        player.getInventory().placeItemBackInInventory(itemStack);

        ItemTagUtils.putInt(gasMaskItem, TAG_FILTER_ID, 0);
        ItemTagUtils.putInt(gasMaskItem, TAG_FILTER_DURABILITY, 0);
    }



    static List<Component> FilterTooltip(ItemStack pStack){
        List<Component> pTooltipComponents = new ArrayList<Component>();
        pTooltipComponents.add(Component.literal(""));

        Item filterItem = Item.byId(ItemTagUtils.getInt(pStack, TAG_FILTER_ID));
        int durability = ItemTagUtils.getInt(pStack, TAG_FILTER_DURABILITY);

        if(true){
            ItemStack itemStack = new ItemStack(filterItem);

            String durabilityDisplay = (itemStack.getDisplayName().getString() + " (" + (durability / Math.max(itemStack.getMaxDamage(), 1) * 100) + "%)");
            pTooltipComponents.add(Component.literal(durabilityDisplay).withStyle(ChatFormatting.GRAY));
        }

        return pTooltipComponents;
    }
}
