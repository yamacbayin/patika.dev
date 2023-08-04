package model.zone;

import model.Player;
import service.GameMap;
import service.PlayerMovementService;

import java.util.Scanner;

public interface Zone {
    void interact(Scanner scanner, Player player, PlayerMovementService playerMovementService, GameMap gameMap);
    String getName();
    String getDescription();
}
