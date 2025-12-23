package org.merl;

import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.ClientAsset;
import net.minecraft.network.chat.Component;

public class MerlToast extends Screen {
    public int answer = (int) (Math.random() * 7);

    protected MerlToast(Component component) {
        super(component);
    }

    @Override
    public void init() {
        String response = null;
        if (answer == 1) {
            response = "    I don't know.";
            this.minecraft.player.playSound(Initialize.I_DONT_KNOW);
        } else if (answer == 2) {
            response = "    Your last message contains language that violates our content policy. Please reword your response.";
            this.minecraft.player.playSound(Initialize.VIOLATED_CONTENT_POLICY);
        } else if (answer == 3) {
            response = "    I don't know the answer to that. Can I help you with a question related to Minecraft?";
            this.minecraft.player.playSound(Initialize.QUESTION_RELATED_TO_MINECRAFT);
        } else if (answer == 4) {
            response = "    I don't know how to help with that. Can I assist you with a question related to Minecraft?";
            this.minecraft.player.playSound(Initialize.QUESTION_RELATED_TO_MINECRAFT2);
        } else if (answer == 5) {
            response = "    I can't assist with that topic.";
            this.minecraft.player.playSound(Initialize.CANT_ASSIST_WITH_TOPIC);
        } else if (answer == 6) {
            response = "    I can only provide support in English right now. Can I help you with a question related to 'Minecraft'?.";
            this.minecraft.player.playSound(Initialize.ENGLISH);
        } else {
            response = "    We are currently experiencing higher traffic than expected. Please wait a moment and resend your last message.";
            this.minecraft.player.playSound(Initialize.HIGH_TRAFFIC);
        }
        this.minecraft.getToastManager().addToast(
                SystemToast.multiline(this.minecraft, SystemToast.SystemToastId.NARRATOR_TOGGLE, Component.nullToEmpty("    Merl"), Component.nullToEmpty(response))

        );
    }
}
