package service;

import model.Player;
import model.zone.Zone;
import model.zone.battlezone.BattleZone;
import util.UserInputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerMovementService {
    public boolean movePlayer(Scanner scanner, Player player, GameMap gameMap) {
        String currentZone = player.getCurrentZone();
        List<Zone> availablePaths = getAvailablePaths(currentZone, gameMap);


        System.out.println("Available paths from " + currentZone + ":");
        for (int i = 0; i < availablePaths.size(); i++) {
            System.out.println((i + 1) + ". " + availablePaths.get(i).getName());
        }

        System.out.print("Enter the number of the path to move: ");
        int selection = UserInputHelper.takeIntegerInput(scanner, 1, availablePaths.size());
        Zone destinationZone = availablePaths.get(selection);

        boolean isCleared = false;
        if (destinationZone instanceof BattleZone) {
            isCleared = ((BattleZone) destinationZone).isCleared();
        }

        // Check if the destination zone is a valid connection from the current zone
        if (gameMap.getConnections(currentZone).contains(destinationZone)) {
            // Move the player to the new zone
            if (isCleared) {
                System.out.println("You already cleared the zone " + destinationZone.getName());
                return false;
            } else {
                player.setCurrentZone(destinationZone.getName());
                return true;
            }

        } else {
            System.out.println("You cannot move to " + destinationZone.getName() + " from here.");
            return false;
        }
    }

    private List<Zone> getAvailablePaths(String currentZone, GameMap gameMap) {
        return new ArrayList<>(gameMap.getConnections(currentZone));
    }
}
