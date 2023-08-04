package model.zone;

import model.Player;
import service.GameMap;
import service.PlayerMovementService;
import util.CharacterManager;
import util.InventoryManager;
import util.UserInputHelper;

import java.util.Scanner;

public class SafeHouse extends AbstractZone {
    public SafeHouse(String name, String description) {
        super(name, description);
    }

    @Override
    public void interact(Scanner scanner, Player player, PlayerMovementService playerMovementService, GameMap gameMap) {
        System.out.println("You find yourself within the confines of the Safe House. The ambiance is soothing and inviting.");


        // Player actions within the Safe House
        boolean stayInSafeHouse = true;
        while (stayInSafeHouse) {
            System.out.println("Select an action:");
            System.out.println("1. Rest and recuperate");
            System.out.println("2. Examine your character");
            System.out.println("3. Examine your inventory");
            System.out.println("4. Depart the Safe House");

            int choice = UserInputHelper.takeIntegerInput(scanner, 1, 4);
            switch (choice) {
                case 0:
                    System.out.println("As you rest, your wounds mend and your strength is renewed.");
                    player.getCharacter().healCompletely();
                    System.out.println("Current health: " + player.getCharacter().getCurrentHealth());
                    break;
                case 1:
                    CharacterManager.examineCharacter(scanner, player.getCharacter());
                    break;
                case 2:
                    InventoryManager.manageInventory(scanner, player.getCharacter());
                    break;
                case 3:
                    // Leave the Safe House and move to another zone
                    playerMovementService.movePlayer(scanner, player, gameMap);
                    stayInSafeHouse = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
