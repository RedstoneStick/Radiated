package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceMenu;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE =
            DeferredRegister.create(Registries.MENU, NTMMain.MODID);


    public static final Supplier<MenuType<BrickFurnaceMenu>> BRICK_FURNACE_MENU = MENU_TYPE.register("brick_furnace_menu",
            () -> new MenuType<>(BrickFurnaceMenu::new, FeatureFlags.DEFAULT_FLAGS));


    public static void register(IEventBus eventBus) {
        MENU_TYPE.register(eventBus);
    }



    @EventBusSubscriber(modid = NTMMain.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ScreenRegistry {
        @SubscribeEvent // on the mod event bus only on the physical client
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(BRICK_FURNACE_MENU.get(), BrickFurnaceScreen::new);
        }
    }
}
