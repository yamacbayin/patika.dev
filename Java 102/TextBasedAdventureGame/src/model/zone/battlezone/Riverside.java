package model.zone.battlezone;

import model.Player;
import model.entity.enemy.Enemy;
import model.item.Item;
import service.BattleService;
import service.GameMap;
import service.ItemFactory;
import service.PlayerMovementService;
import util.CharacterManager;
import util.EndGameUtil;
import util.InventoryManager;
import util.UserInputHelper;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Riverside extends BattleZone {

    public Riverside(String name, String description, List<Enemy> enemyList, Random random) {
        super(name, description, enemyList, random);
    }

    public Riverside(String name, String description, Random random) {
        super(name, description, random);
    }

    @Override
    public void interact(Scanner scanner, Player player, PlayerMovementService playerMovementService, GameMap gameMap) {
        System.out.println("You are in " + this.getName());
        List<Item> drops = new ItemFactory(random).createDrops(2, 10,
                50, 100,
                80, 100,
                70, 100);


        boolean alreadyExplored = false;
        boolean stayInTheZone = true;
        while (stayInTheZone) {
            System.out.println("Select an action:");
            System.out.println("1. Explore the zone");
            System.out.println("2. Examine your character");
            System.out.println("3. Examine your inventory");
            System.out.println("4. Depart " + this.getName());

            int selection = UserInputHelper.takeIntegerInput(scanner, 1, 4);

            switch (selection) {
                case 0 -> {
                    if (alreadyExplored) {
                        System.out.println("You have already explored the zone.");
                    } else {
                        System.out.println("CREATURES APPROACH YOU TEXT HERE");
                        boolean battleResult = new BattleService(player, enemyList, scanner, random, drops).beginBattle();
                        alreadyExplored = true;
                        if (battleResult) {
                            EndGameUtil.setIsAquaticPearlCollected(Boolean.TRUE);
                            this.setCleared(Boolean.TRUE);
                        } else {
                            player.setCurrentZone("Safe House");
                            stayInTheZone = false;
                        }
                    }
                }
                case 1 -> CharacterManager.examineCharacter(scanner, player.getCharacter());
                case 2 -> InventoryManager.manageInventory(scanner, player.getCharacter());
                case 3 -> {
                    playerMovementService.movePlayer(scanner, player, gameMap);
                    stayInTheZone = false;
                }
            }

        }
    }
}
