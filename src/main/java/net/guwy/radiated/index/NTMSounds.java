package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Radiated.MOD_ID);



    public static final RegistryObject<SoundEvent> RADAWAY = registerSoundEvent("radaway");

    public static final RegistryObject<SoundEvent> GEIGER1 = registerSoundEvent("geiger1");
    public static final RegistryObject<SoundEvent> GEIGER2 = registerSoundEvent("geiger2");
    public static final RegistryObject<SoundEvent> GEIGER3 = registerSoundEvent("geiger3");
    public static final RegistryObject<SoundEvent> GEIGER4 = registerSoundEvent("geiger4");
    public static final RegistryObject<SoundEvent> GEIGER5 = registerSoundEvent("geiger5");
    public static final RegistryObject<SoundEvent> GEIGER6 = registerSoundEvent("geiger6");

    public static final RegistryObject<SoundEvent> DUCT_TAPE = registerSoundEvent("duct_tape");
    public static final RegistryObject<SoundEvent> GAS_MASK_SCREW = registerSoundEvent("gas_mask_screw");

    public static final RegistryObject<SoundEvent> TECH_BOOP = registerSoundEvent("tech_boop");

    public static final RegistryObject<SoundEvent> VOMIT = registerSoundEvent("vomit");
    public static final RegistryObject<SoundEvent> COUGH1 = registerSoundEvent("cough1");
    public static final RegistryObject<SoundEvent> COUGH2 = registerSoundEvent("cough2");
    public static final RegistryObject<SoundEvent> COUGH3 = registerSoundEvent("cough3");
    public static final RegistryObject<SoundEvent> COUGH4 = registerSoundEvent("cough4");



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
