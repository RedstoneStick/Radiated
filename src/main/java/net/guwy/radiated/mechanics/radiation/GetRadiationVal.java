package net.guwy.radiated.mechanics.radiation;

import com.simibubi.create.AllItems;
import net.guwy.sticky_foundations.index.SFTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GetRadiationVal {
    public static double getVal(ItemStack itemStack){
        Item item = itemStack.getItem();

        if(item instanceof RadiatedItem){
            RadiatedItem radiatedItem = (RadiatedItem) item;

            double val = radiatedItem.radiationVal( itemStack);
            val = val * 1000;
            val = (double) Math.round(val);
            val = val / 1000;

            return val;
        }



        else if (itemStack.is(SFTags.Items.URANIUM_INGOT)) {return 0.35;}
        else if (itemStack.is(SFTags.Items.URANIUM_NUGGET)) {return 0.035;}
        else if (itemStack.is(SFTags.Items.URANIUM_RAW)) {return 0.02;}
        else if (itemStack.is(SFTags.Items.URANIUM_PLATE)) {return 0.35;}
        else if (itemStack.is(SFTags.Items.URANIUM_DUST)) {return 1.05;}
        else if (itemStack.is(SFTags.Items.URANIUM_ORE)) {return 0.015;}
        else if (itemStack.is(SFTags.Items.URANIUM_BLOCK)) {return 3.5;}
        else if (itemStack.is(SFTags.Items.URANIUM_BLOCK_RAW)) {return 0.2;}
        else if (itemStack.is(SFTags.Items.URANIUM_CRUSHED)) {return 1.05;}

        else if (itemStack.is(SFTags.Items.THORIUM_INGOT)) {return 0.1;}
        else if (itemStack.is(SFTags.Items.THORIUM_NUGGET)) {return 0.01;}
        else if (itemStack.is(SFTags.Items.THORIUM_RAW)) {return 0.006;}
        else if (itemStack.is(SFTags.Items.THORIUM_PLATE)) {return 0.1;}
        else if (itemStack.is(SFTags.Items.THORIUM_DUST)) {return 0.3;}
        else if (itemStack.is(SFTags.Items.THORIUM_ORE)) {return 0.004;}
        else if (itemStack.is(SFTags.Items.THORIUM_BLOCK)) {return 1.0;}
        else if (itemStack.is(SFTags.Items.THORIUM_BLOCK_RAW)) {return 0.06;}
        else if (itemStack.is(SFTags.Items.THORIUM_CRUSHED)) {return 0.3;}

        else if (itemStack.getItem().equals(AllItems.CRUSHED_URANIUM.get())) {return 1.05;}



        else {
            return 0;
        }
    }

    public static double getStackVal(ItemStack itemStack){
        double val = getVal(itemStack) * itemStack.getCount();
        val = val * 1000;
        val = (double) Math.round(val);
        val = val / 1000;
        return val;

    }
}


