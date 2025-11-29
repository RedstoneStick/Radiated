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
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.StreamServerDataProvider;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

import java.util.List;

public enum BrickFurnaceComponentProvider implements IBlockComponentProvider, StreamServerDataProvider<BlockAccessor, BrickFurnaceComponentProvider.Data> {
    INSTANCE;

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "brick_furnace");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        BrickFurnaceComponentProvider.Data data = this.decodeFromData(blockAccessor).orElse(null);
        if (data != null) {
            IElementHelper helper = IElementHelper.get();
            iTooltip.add(helper.item(data.inventory.get(0)));
            iTooltip.append(helper.item(data.inventory.get(1)));
            iTooltip.append(helper.spacer(4, 0));
            iTooltip.append(helper.progress((float)data.progress / (float)data.total).translate(new Vec2(-2.0F, 0.0F)));
            iTooltip.append(helper.item(data.inventory.get(2)));
            iTooltip.append(helper.item(data.inventory.get(3)));

            final int maxAsh = BrickFurnaceBlockEntity.ASH_THRESHOLD;
            iTooltip.add(Component.translatable("tooltip.jade.brick_furnace.ash", (int) (data.ashCoal * 100.0f / maxAsh), (int) (data.ashWood * 100.0f / maxAsh), (int) (data.ashMisc * 100.0f / maxAsh)));

            boolean isClogged = data.ashCoal >= maxAsh * 16 || data.ashWood >= maxAsh * 16 || data.ashMisc >= maxAsh * 16;
            if (isClogged) {
                iTooltip.add(Component.translatable("tooltip.jade.brick_furnace.clogged").withStyle(ChatFormatting.RED));
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    public BrickFurnaceComponentProvider.Data streamData(BlockAccessor accessor) {
        BrickFurnaceBlockEntity furnace = (BrickFurnaceBlockEntity)accessor.getBlockEntity();
        return new BrickFurnaceComponentProvider.Data(furnace.getDataCookingProgress(), furnace.getDataCookingTotalTime(),furnace.getDataAshCoal(), furnace.getDataAshWood(), furnace.getDataAshMisc() , List.of(furnace.getItem(0), furnace.getItem(1), furnace.getItem(2), furnace.getItem(3)));
    }

    public StreamCodec<RegistryFriendlyByteBuf, BrickFurnaceComponentProvider.Data> streamCodec() {
        return BrickFurnaceComponentProvider.Data.STREAM_CODEC;
    }

    public static record Data(int progress, int total, int ashCoal, int ashWood, int ashMisc, List<ItemStack> inventory) {
        public static final StreamCodec<RegistryFriendlyByteBuf, BrickFurnaceComponentProvider.Data> STREAM_CODEC;

        public Data(int progress, int total, int ashCoal, int ashWood, int ashMisc, List<ItemStack> inventory) {
            this.progress = progress;
            this.total = total;
            this.ashCoal = ashCoal;
            this.ashWood = ashWood;
            this.ashMisc = ashMisc;
            this.inventory = inventory;
        }

        public int progress() {
            return this.progress;
        }

        public int total() {
            return this.total;
        }

        public int ashCoal() {
            return this.ashCoal;
        }

        public int ashWood() {
            return this.ashWood;
        }

        public int ashMisc() {
            return this.ashMisc;
        }

        public List<ItemStack> inventory() {
            return this.inventory;
        }

        static {
            STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, BrickFurnaceComponentProvider.Data::progress, ByteBufCodecs.VAR_INT, BrickFurnaceComponentProvider.Data::total, ByteBufCodecs.VAR_INT, BrickFurnaceComponentProvider.Data::ashCoal, ByteBufCodecs.VAR_INT, BrickFurnaceComponentProvider.Data::ashWood, ByteBufCodecs.VAR_INT, BrickFurnaceComponentProvider.Data::ashMisc, ItemStack.OPTIONAL_LIST_STREAM_CODEC, BrickFurnaceComponentProvider.Data::inventory, BrickFurnaceComponentProvider.Data::new);
        }
    }
}
