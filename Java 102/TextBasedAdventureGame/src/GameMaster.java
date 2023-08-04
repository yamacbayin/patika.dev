import model.Player;
import service.GameMap;
import service.PlayerMovementService;
import service.PlayerService;
import service.ZoneLoaderService;
import util.EndGameUtil;

import java.util.Random;
import java.util.Scanner;

public class GameMaster {
    private Scanner scanner;
    private Random random;
    private Player player;
    private GameMap gameMap;
    private PlayerMovementService playerMovementService;
    private PlayerService playerService;

    public GameMaster() {
        scanner = new Scanner(System.in);
        random = new Random();
        playerService = new PlayerService(scanner);
        gameMap = new GameMap();
        new ZoneLoaderService(random).loadZones(gameMap);
        playerMovementService = new PlayerMovementService();
    }

    public void run() {
        System.out.println("Text Based Adventure Game");
        player = playerService.createPlayer();
        System.out.println("Welcome to the dark and mysterious lands, " + player.getName() + "!");
        player.setCurrentZone("Safe House");
        boolean isPlayerAlive = true;
        boolean hasPlayerWon = false;
        while (true) {

            if (player.getCharacter().getCurrentHealth() <= 0) {
                isPlayerAlive = false;
                break;
            }

            if (EndGameUtil.checkEndGame()) {
                hasPlayerWon = true;
                break;
            }

            // Get the current zone object based on the current zone name
            gameMap.getZone(player.getCurrentZone()).interact(scanner, player, playerMovementService, gameMap);
        }

        if (!isPlayerAlive) {
            System.out.println("YOU DIED!");
        }

        if (hasPlayerWon) {
            System.out.println("You won the game.");
        }
    }


}
