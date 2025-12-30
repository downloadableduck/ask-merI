package org.merl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.core.Registry;
import net.minecraft.resources.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import static org.merl.IrreliventFile.MOD_ID;

public class Initialize implements ClientModInitializer {

    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static final SoundEvent I_DONT_KNOW = registerSound("i_dont_know");

    public static final SoundEvent VIOLATED_CONTENT_POLICY = registerSound("violated_content_policy");

    public static final SoundEvent QUESTION_RELATED_TO_MINECRAFT = registerSound("question_related_to_minecraft");

    public static final SoundEvent QUESTION_RELATED_TO_MINECRAFT2 = registerSound("question_related_to_minecraft2");
    //minecraft 2 confirmed???

    public static final SoundEvent CANT_ASSIST_WITH_TOPIC = registerSound("cant_assist_with_topic");

    public static final SoundEvent ENGLISH = registerSound("english");

    public static final SoundEvent HIGH_TRAFFIC = registerSound("high_traffic");

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
                AskMerl.register(dispatcher)
        );
    }
}
