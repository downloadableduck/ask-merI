package org.merl;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.network.chat.Component;

public class AskMerl {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("askmerl")
                .then(ClientCommandManager.argument("question", StringArgumentType.greedyString())
                        .executes(context -> {
                            String question = StringArgumentType.getString(context, "question");
                                context.getSource().getClient().execute(() -> {
                                context.getSource().getClient().setScreen(new MerlToast(Component.literal("merl")));
                            });
                            return 1;
                        })
                )
        );
    }
}