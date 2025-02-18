package com.aytronn.exemple.utils;

import org.bukkit.Location;

public class LocationUtils {

  public static CardinalDirection getCardinalDirection(Location location) {
    float yaw = location.getYaw();
    yaw = (yaw % 360 + 360) % 360; // Normaliser entre 0 et 360°

    if (yaw >= 315 || yaw < 45) {
      return CardinalDirection.SOUTH;
    } else if (yaw >= 45 && yaw < 135) {
      return CardinalDirection.WEST;
    } else if (yaw >= 135 && yaw < 225) {
      return CardinalDirection.NORTH;
    } else {
      return CardinalDirection.EAST;
    }
  }
}
