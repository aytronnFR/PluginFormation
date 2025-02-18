package com.aytronn.exemple.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public interface MyCommands {

  LiteralCommandNode<CommandSourceStack> getCommand();
}
