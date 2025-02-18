package com.aytronn.exemple;

import com.aytronn.exemple.command.GameModeCommand;
import com.aytronn.exemple.listener.PlayerListener;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Exemple extends JavaPlugin {

  private static Exemple INSTANCE;

  @Override
  public void onEnable() {
    INSTANCE = this;
    // Plugin startup logic
    getLogger().info("Example start !!!");
    registerListener();
    registerCommands();
  }

  private void registerCommands() {
    this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
      commands.registrar().register(new GameModeCommand().getCommand());
    });
  }

  private void registerListener() {
    getServer().getPluginManager().registerEvents(new PlayerListener(), this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    getLogger().info("Example stop !!!");
  }

  public static Exemple getInstance() {
    return INSTANCE;
  }
}
