package net.guwy.hbm.compat.jade;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

import java.util.List;

public enum CustomItemStorageDisplayComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "remove_default_item_storage_display");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE);
    }

    @Override
    public int getDefaultPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }
}
