package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Radiated.MOD_ID);



    public static final RegistryObject<SoundEvent> RADAWAY = registerSoundEvent("radaway");



    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Radiated.MOD_ID, name)));
    }

    private static RegistryObject<SoundEvent> registerSoundEvent(String name, float range){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Radiated.MOD_ID, name), range));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
