package net.guwy.radiated.mechanics.gasmask;

import net.guwy.radiated.index.ModSounds;
import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public interface IGasmaskItem {

    String TAG_FILTER_ID = "filter_id";
    String TAG_FILTER_DURABILITY = "filter_durability";



    static IFilterItem getFilterItem(ItemStack gasmaskItem){

        // If the gas mask implements the IFilterItem then check the item itself for filtration values
        // This is used for instances if the helmet doesn't have any replaceable filter
        if(gasmaskItem.getItem() instanceof IFilterItem){
            return (IFilterItem) gasmaskItem.getItem();
        } else {

            // If the item is a filter item return it
            Item item = Item.byId(ItemTagUtils.getInt(gasmaskItem, TAG_FILTER_ID));
            if(item instanceof IFilterItem filterItem) return filterItem;
            // else return a new filter item that doesn't have any filtration values
            else return new IFilterItem() {
                @Override
                public List<AirborneHazardTypes> GetFiltrableHazards() {
                    List<AirborneHazardTypes> hazardTypes = new ArrayList<>();
                    return hazardTypes;
                }
            };
        }
    }



    static int getFilterDurability(ItemStack gasmaskItem){
        return ItemTagUtils.getInt(gasmaskItem, TAG_FILTER_DURABILITY);
    }

    static void setFilterDurability(ItemStack gasmaskItem, int set){
        ItemTagUtils.putInt(gasmaskItem, TAG_FILTER_DURABILITY, set);
    }

    static void addFilterDurability(ItemStack gasmaskItem, int add){
        int durability = ItemTagUtils.getInt(gasmaskItem, TAG_FILTER_DURABILITY);
        durability += add;
        ItemTagUtils.putInt(gasmaskItem, TAG_FILTER_DURABILITY, durability);
    }



    static void setFilter(Player player, ItemStack filterItem, InteractionHand interactionHand){
        ItemStack helmetItem = player.getItemBySlot(EquipmentSlot.HEAD);
        int filterId = ItemTagUtils.getInt(helmetItem, TAG_FILTER_ID);

        // Check if the helmet is a gasmask
        if(helmetItem.getItem() instanceof IGasmaskItem){

            // Check if the gas mask doesn't have a non-replaceable filter
            if(!(helmetItem.getItem() instanceof IFilterItem)){

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
                Player soundPlayer = new Player(player.getLevel(), player.getOnPos(), 0, player.getGameProfile(), null) {
                    @Override
                    public boolean isSpectator() {
                        return false;
                    }

                    @Override
                    public boolean isCreative() {
                        return false;
                    }
                };
                soundPlayer.playSound(ModSounds.GAS_MASK_SCREW.get());
                soundPlayer.remove(Entity.RemovalReason.DISCARDED);
            }

            // Else send non-replaceable filter message
            else {
                player.sendSystemMessage(Component.translatable("message.radiated.gas_mask.filter.fail.static_filter"));
            }
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

        Item filterItem = Item.byId(ItemTagUtils.getInt(pStack, TAG_FILTER_ID));
        int durability = ItemTagUtils.getInt(pStack, TAG_FILTER_DURABILITY);

        if(filterItem != Blocks.AIR.asItem()){
            ItemStack itemStack = new ItemStack(filterItem);

            double percent = (double)durability / Math.max(itemStack.getMaxDamage(), 1) * 100;
            percent = Math.floor(percent * 10) / 10; // round percent to 00.0 format
            String durabilityDisplay = (itemStack.getDisplayName().getString() + " (" + percent + "%)");
            pTooltipComponents.add(Component.literal(durabilityDisplay).withStyle(ChatFormatting.GRAY));
        }else {
            pTooltipComponents.add(Component.translatable("tooltip.radiated.armor.gas_mask.warning"));
        }

        pTooltipComponents.add(Component.literal(""));  // Formatting

        return pTooltipComponents;
    }



    /** Damages the filter according to the value and,
     * Returns the amount the gas mask couldn't filter */
    static int ProcessGasMaskFiltration(Player player, int amount, AirborneHazardTypes typeToFilter){
        int unfilteredAmount = amount;

        // Check for gasmask
        ItemStack helmetItemStack = player.getItemBySlot(EquipmentSlot.HEAD);
        if(helmetItemStack.getItem() instanceof IGasmaskItem){

            IFilterItem filterItem = (IFilterItem) IGasmaskItem.getFilterItem(helmetItemStack);
            int durability = getFilterDurability(helmetItemStack);

            // Check if the filter can filter the hazard
            if(filterItem.GetFiltrableHazards().contains(typeToFilter)){

                // Change final val depending on the durability
                unfilteredAmount = Math.max(0, amount - durability);

                // Damage the filter
                addFilterDurability(helmetItemStack, -(amount - unfilteredAmount));
            }
        }
        return unfilteredAmount;
    }
}
