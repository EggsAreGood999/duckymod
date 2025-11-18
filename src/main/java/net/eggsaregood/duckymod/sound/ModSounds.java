package net.eggsaregood.duckymod.sound;

import net.eggsaregood.duckymod.DuckyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DuckyMod.MOD_ID);
    public static final RegistryObject<SoundEvent> DUCKY_RIGHTCLICK = registerSoundEvent("ducky_rightclick");

    public static final RegistryObject<SoundEvent> DUCKY_BLOCK_STEP = registerSoundEvent("ducky_block_step");
    public static final RegistryObject<SoundEvent> DUCKY_BLOCK_PLACE = registerSoundEvent("ducky_block_place");
    public static final RegistryObject<SoundEvent> DUCKY_BLOCK_BREAK = registerSoundEvent("ducky_block_break");
    public static final RegistryObject<SoundEvent> DUCKY_BLOCK_HIT = registerSoundEvent("ducky_block_hit");
    public static final RegistryObject<SoundEvent> DUCKY_BLOCK_FALL = registerSoundEvent("ducky_block_fall");


    public static final ForgeSoundType DUCKY_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.DUCKY_BLOCK_PLACE, ModSounds.DUCKY_BLOCK_STEP, ModSounds.DUCKY_BLOCK_BREAK, ModSounds.DUCKY_BLOCK_HIT, ModSounds.DUCKY_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(DuckyMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
