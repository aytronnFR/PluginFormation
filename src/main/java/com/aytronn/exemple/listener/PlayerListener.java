package com.aytronn.exemple.listener;

import com.aytronn.exemple.Exemple;
import com.aytronn.exemple.utils.CardinalDirection;
import com.aytronn.exemple.utils.LocationUtils;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {


  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    event.setJoinMessage("Welcome to the server " + event.getPlayer().getName());
    Exemple.getInstance().getLogger().info("Player " + event.getPlayer().getName() + " joined the server");
  }

  @EventHandler
  public void playerBreakBlock(BlockBreakEvent event) {
    Block block = event.getBlock();

    event.getPlayer().getLocation().getYaw();

    CardinalDirection cardinalDirection = LocationUtils.getCardinalDirection(event.getPlayer().getLocation());
    List<Vector> offsets;
    if (cardinalDirection == CardinalDirection.NORTH || cardinalDirection == CardinalDirection.SOUTH) {
      offsets = Arrays.asList(
          new Vector(0, -1, 0),
          new Vector(0, 1, 0),
          new Vector(1, 0, 0),
          new Vector(-1, 0, 0),
          new Vector(-1, 1, 0),
          new Vector(-1, -1, 0),
          new Vector(1, 1, 0),
          new Vector(1, -1, 0)
      );
    } else {
      offsets = Arrays.asList(
          new Vector(0, -1, 0),
          new Vector(0, 1, 0),
          new Vector(0, 0, 1),
          new Vector(0,  0, -1),
          new Vector(0,  1, -1),
          new Vector(0,  -1, -1),
          new Vector(0, 1, 1),
          new Vector(0, -1, 1)
      );
    }



    for (Vector offset : offsets) {
      Block relative = block.getRelative(offset.getBlockX(), offset.getBlockY(), offset.getBlockZ());

      if (relative.getType() != Material.AIR) {
        relative.breakNaturally();
      }
    }
  }
}
