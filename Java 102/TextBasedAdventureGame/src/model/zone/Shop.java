package model.zone;

import model.Inventory;
import model.Player;
import model.item.EquippableItem;
import model.item.Item;
import service.GameMap;
import service.ItemFactory;
import service.PlayerMovementService;
import util.CharacterManager;
import util.InventoryManager;
import util.UserInputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shop extends AbstractZone {

    Inventory shopInventory;

    public Shop(String name, String description) {
        super(name, description);
        shopInventory = new Inventory();
    }

    @Override
    public void interact(Scanner scanner, Player player, PlayerMovementService playerMovementService, GameMap gameMap) {

        shopInventory.setItemList(new ItemFactory(new Random()).createShopItems(4, 10));

        System.out.println("You find yourself in " + this.getName() + ". " +
                "The air is filled with the enticing aroma of various wares.");

        boolean stayInShop = true;
        while (stayInShop) {
            System.out.println("What would you like to do?");
            System.out.println("1. Browse the collection of items");
            System.out.println("2. Offer your belongings for sale");
            System.out.println("3. Examine your character");
            System.out.println("4. Examine your inventory");
            System.out.println("5. Leave " + this.getName());

            int choice = UserInputHelper.takeIntegerInput(scanner, 1, 5);
            switch (choice) {
                case 0 -> {
                    buyItems(scanner, player);
                }
                case 1 -> {
                    sellItems(scanner, player);
                }
                case 2 -> {
                    CharacterManager.examineCharacter(scanner, player.getCharacter());
                }
                case 3 -> {
                    InventoryManager.manageInventory(scanner, player.getCharacter());
                }
                case 4 -> {
                    // Leave the Shop and move to another zone
                    playerMovementService.movePlayer(scanner, player, gameMap);
                    stayInShop = false;
                }
                default -> System.out.println("Invalid choice. Please choose again.");
            }
        }

    }

    private void buyItems(Scanner scanner, Player player) {
        boolean stayInBuyItems = true;
        while (stayInBuyItems) {
            System.out.println("Your gold: " + player.getCharacter().getGold());
            shopInventory.printInventory();
            System.out.println("Enter the number of item you want to buy. Enter 0 to exit.");
            int selection = UserInputHelper.takeIntegerInput(scanner, 0, shopInventory.getItemList().size());

            if (selection == -1) {
                stayInBuyItems = false;
            } else {
                Item item = shopInventory.getItemList().get(selection);
                if (item.getValue() <= player.getCharacter().getGold()) {
                    player.getCharacter().setGold(player.getCharacter().getGold() - item.getValue());
                    player.getCharacter().getInventory().addItem(item);
                    shopInventory.removeItem(selection);
                    System.out.println(item.getName() + " is added to your inventory.");
                } else {
                    System.err.println("Not enough gold.");
                }
            }
        }
    }

    private void sellItems(Scanner scanner, Player player) {
        boolean stayInSellItems = true;
        Inventory playerInventory = player.getCharacter().getInventory();
        while (stayInSellItems) {
            if(playerInventory.getItemList().isEmpty()) {
                System.out.println("Your inventory is empty. There is nothing to sell.");
                break;
            }
            playerInventory.printInventory();
            System.out.println("Enter the number of item you want to sell. Enter 0 to exit.");
            int selection = UserInputHelper.takeIntegerInput(scanner, 0, playerInventory.getItemList().size());

            if (selection == -1) {
                stayInSellItems = false;
            } else {
                Item item = playerInventory.getItemList().get(selection);
                if (item instanceof EquippableItem && !((EquippableItem) item).isEquipped()) {
                    player.getCharacter().setGold(player.getCharacter().getGold() + item.getValue());
                    playerInventory.removeItem(item);
                    shopInventory.addItem(item);
                    System.out.println("You sold " + item.getName() + " for " + item.getValue() + " gold.");
                } else {
                    System.err.println("You can't sell equipped items.");
                }
            }
        }
    }

}
