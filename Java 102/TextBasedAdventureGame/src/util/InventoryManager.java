package util;

import model.Inventory;
import model.entity.character.Character;
import model.item.EquippableItem;

import java.util.Scanner;

public class InventoryManager {

    public static void manageInventory(Scanner scanner, Character character) {
        Inventory inventory = character.getInventory();

        boolean stayInInventoryManager = true;
        while (stayInInventoryManager) {

            if(inventory.getItemList().isEmpty()) {
                System.out.println("Inventory is empty.");
                break;
            }

            inventory.printInventory();
            System.out.print("Enter 0 to exit. Select an item to manage: ");
            int selection = UserInputHelper.takeIntegerInput(scanner, 0, inventory.getItemList().size());
            if (selection == -1) {
                stayInInventoryManager = false;
            } else {
                System.out.println("What would you like to do with " + inventory.getItemList().get(selection).getName() + "?");
                EquippableItem selectedItem = (EquippableItem) inventory.getItemList().get(selection);
                boolean isSelectedItemEquipped = selectedItem.isEquipped();
                String equipOrUnequip = isSelectedItemEquipped ? "Unequip" : "Equip";

                System.out.println("1. " + equipOrUnequip);
                System.out.println("2. Drop");
                System.out.println("3. Deselect item");
                int optionSelection = UserInputHelper.takeIntegerInput(scanner, 1, 3);

                switch (optionSelection) {
                    case 0:
                        if (isSelectedItemEquipped) {
                            character.unequipItem(selectedItem);
                            System.out.println("Unequipped item " + selectedItem.getName());
                        } else {

                            character.equipItem(selectedItem);
                            System.out.println("Equipped item " + selectedItem.getName());
                        }
                        break;
                    case 1:
                        if (isSelectedItemEquipped) {
                            System.err.println("Cannot drop equipped items");
                        } else {
                            inventory.removeItem(selectedItem);
                            System.out.println(selectedItem.getName() + " is removed from your inventory.");
                        }
                        break;
                    case 2:
                    default:
                        break;
                }


            }


        }
    }

}
