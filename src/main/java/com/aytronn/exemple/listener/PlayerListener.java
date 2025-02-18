package com.aytronn.exemple.listener;

import com.aytronn.exemple.Exemple;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {


  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    event.setJoinMessage("Welcome to the server " + event.getPlayer().getName());
    Exemple.getInstance().getLogger().info("Player " + event.getPlayer().getName() + " joined the server");
  }
}
