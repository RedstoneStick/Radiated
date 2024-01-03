package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.guwy.ntm.content.blocks.machines.rtg.RTGMenu;
import net.guwy.ntm.content.blocks.machines.turbine.TurbineMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, NTM.MOD_ID);



    public static final RegistryObject<MenuType<TurbineMenu>> TURBINE_MENU =
            registerMenuType(TurbineMenu::new, "turbine_menu");

    public static final RegistryObject<MenuType<RTGMenu>> RTG_MENU =
            registerMenuType(RTGMenu::new, "rtg_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
