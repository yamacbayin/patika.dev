package util;

import model.entity.character.Character;

import java.util.Scanner;

public class CharacterManager {

    public static void examineCharacter(Scanner scanner, Character character) {
        System.out.println("-------------------------------------------------------");
        System.out.println(character.getName());
        System.out.println("HP: " + character.getCurrentHealth() + "/" + character.getMaxHealth()
                + " Armor Rating: " + character.getArmorRating());
        System.out.println("Damage: " + character.getMinDamage() + "-" + character.getMaxDamage());
        if (character.getEquippedArmor() == null) {
            System.out.println("Equipped Armor: None");
        } else {
            System.out.println("Equipped Armor: " + character.getEquippedArmor().getName()
                    + " Armor Rating: " + character.getEquippedArmor().getArmorRating()
                    + " Bonus HP: " + character.getEquippedArmor().getHealthBonus());
        }

        if (character.getEquippedWeapon() == null) {
            System.out.println("Equipped Weapon: None");
        } else {
            System.out.println("Equipped Weapon: " + character.getEquippedWeapon().getName()
                    + " Damage: " + character.getEquippedWeapon().getMinDamage()
                    + "-"
                    + character.getEquippedWeapon().getMaxDamage());
        }
        System.out.println("Inventory items: " + character.getInventory().getItemList().size());
        System.out.println("Gold: " + character.getGold());
        System.out.println("-------------------------------------------------------");
    }

}
