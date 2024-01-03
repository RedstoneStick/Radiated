package net.guwy.ntm.content.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CoffeeItem extends Item {
    public CoffeeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Player player = (Player) pLivingEntity;
        player.getInventory().placeItemBackInInventory(new ItemStack(Items.GLASS_BOTTLE));
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
