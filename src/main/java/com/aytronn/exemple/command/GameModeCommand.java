package com.aytronn.exemple.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class GameModeCommand implements MyCommands {

  @Override
  public LiteralCommandNode<CommandSourceStack> getCommand() {
    return Commands.literal("gm")
        .then(Commands.argument("gameMode", IntegerArgumentType.integer(0, 3))
            .executes(GameModeCommand::changeGameMode)
        ).build();
  }

  private static int changeGameMode(CommandContext<CommandSourceStack> ctx) {
    int gameMode = IntegerArgumentType.getInteger(ctx, "gameMode");
    CommandSender sender = ctx.getSource().getSender();
    Entity executor = ctx.getSource().getExecutor();

    if (!(executor instanceof Player player)) {
      sender.sendPlainMessage("Only players can execute the command!");
      return Command.SINGLE_SUCCESS;
    }

    switch (gameMode) {
      case 0 -> {
        player.setGameMode(org.bukkit.GameMode.SURVIVAL);
        sender.sendPlainMessage("Game mode set to survival!");
      }
      case 1 -> {
        player.setGameMode(org.bukkit.GameMode.CREATIVE);
        sender.sendPlainMessage("Game mode set to creative!");
      }
      case 2 -> {
        player.setGameMode(org.bukkit.GameMode.ADVENTURE);
        sender.sendPlainMessage("Game mode set to adventure!");
      }
      case 3 -> {
        player.setGameMode(org.bukkit.GameMode.SPECTATOR);
        sender.sendPlainMessage("Game mode set to spectator!");
      }
    }
    return Command.SINGLE_SUCCESS;
  }
}
