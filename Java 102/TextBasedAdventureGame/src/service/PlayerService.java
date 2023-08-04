package service;

import model.Player;
import model.entity.character.Character;

import java.util.Scanner;

public class PlayerService {

    private Scanner scanner;
    private CharacterFactory characterFactory;

    public PlayerService(Scanner scanner) {
        this.scanner = scanner;
        characterFactory = new CharacterFactory(scanner);
    }

    public Player createPlayer() {
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        Character character = characterFactory.createCharacter();
        player.setCharacter(character);
        return player;
    }


}
