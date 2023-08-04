package service;

import model.entity.character.Archer;
import model.entity.character.Knight;
import model.entity.character.Character;
import model.entity.character.Wizard;
import util.UserInputHelper;

import java.util.Scanner;

public class CharacterFactory {
    private Scanner scanner;

    public CharacterFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Character createCharacter() {
        System.out.println("Enter a name for your character: ");
        String charName = scanner.nextLine();

        System.out.println("#################################################");
        System.out.println("1. Wizard \t Damage: 35-99 \t Health: 150 \t Gold: 100");
        System.out.println("2. Archer \t Damage: 23-60 \t Health: 200 \t Gold: 100");
        System.out.println("3. Knight \t Damage: 18-46 \t Health: 250 \t Gold: 100");

        System.out.println("Enter the number of the character you want to choose: ");
        int selection = UserInputHelper.takeIntegerInput(scanner, 1, 3);
        return switch (selection) {
            case 0 -> new Wizard(35, 99, 150, 100, charName);
            case 1 -> new Archer(23, 60, 200, 100, charName);
            case 2 -> new Knight(18, 46, 250, 100, charName);
            default -> throw new IllegalArgumentException("Invalid character selection.");
        };
    }
}
