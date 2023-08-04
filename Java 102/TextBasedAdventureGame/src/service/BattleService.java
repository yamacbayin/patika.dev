package service;

import model.Player;
import model.entity.Entity;
import model.entity.character.Character;
import model.entity.enemy.Enemy;
import model.item.Item;
import util.UserInputHelper;

import java.util.*;

public class BattleService {

    private Player player;
    private List<Enemy> enemyList;
    private Scanner scanner;
    private Random random;
    private List<Item> drops;
    private int goldDrop;
    private Set<Integer> deadEnemyIndexSet;

    public BattleService(Player player, List<Enemy> enemyList, Scanner scanner, Random random, List<Item> drops) {
        this.player = player;
        this.enemyList = enemyList;
        this.scanner = scanner;
        this.random = random;
        this.drops = drops;
        this.deadEnemyIndexSet = new HashSet<>();
        calculateGoldDrop();
    }

    public boolean beginBattle() {

        int round = 1;
        boolean isBattleOver = false;
        while (!isBattleOver) {
            System.out.println("Round " + round + " ---------------------");
            if (random.nextBoolean()) {
                //player attacks first
                playerAttack();
                creepAttack();
            } else {
                creepAttack();
                playerAttack();
            }
            ++round;
            isBattleOver = checkBattleOver();
        }

        if (player.getCharacter().getCurrentHealth() <= 0) {
            return false;
        } else {
            System.out.println(drops.size() + " items are added to your inventory.");
            player.getCharacter().getInventory().addItems(drops);
            System.out.println(goldDrop + " gold is added to your stash.");
            player.getCharacter().setGold(player.getCharacter().getGold() + goldDrop);
            return true;
        }
    }

    private boolean checkBattleOver() {
        int remainingCreepHealth = 0;
        for (Enemy enemy : enemyList) {
            if (!(enemy.getCurrentHealth() <= 0))
                remainingCreepHealth += enemy.getCurrentHealth();
        }

        if (remainingCreepHealth <= 0) {
            return true;
        }

        return player.getCharacter().getCurrentHealth() <= 0;
    }

    private void playerAttack() {
        Character character = player.getCharacter();
        if (character.getCurrentHealth() <= 0) {
            return;
        }
        System.out.println(character.getName() + "'s turn to attack! Choose an enemy");

        for (int i = 0; i < enemyList.size(); i++) {
            Enemy enemy = enemyList.get(i);
            String isDeadString = enemy.getCurrentHealth() <= 0 ? " -DEAD- " : "";
            System.out.println((i + 1) + ". " + enemy.getName() + " - HP: "
                    + enemy.getCurrentHealth() + "/" + enemy.getMaxHealth() + isDeadString);
        }
        int selection = -1;
        boolean userSelectedADeadEnemy = true;
        while (userSelectedADeadEnemy) {
            selection = UserInputHelper.takeIntegerInput(scanner, 1, enemyList.size());
            if (enemyList.get(selection).getCurrentHealth() > 0) {
                userSelectedADeadEnemy = false;
            } else {
                System.err.print("Selected enemy is dead. Select another enemy: ");
            }
        }

        int damage = calculateDamage(character);
        Enemy enemyToHit = enemyList.get(selection);
        enemyToHit.takeDamage(damage);

        System.out.println(character.getName() + " hits " + enemyToHit.getName() + " for " + damage + " damage.");
        System.out.println(enemyToHit.getName() + "'s current HP: "
                + enemyToHit.getCurrentHealth() + "/" + enemyToHit.getMaxHealth());


    }

    private void creepAttack() {
        Enemy enemyToAttack;

        while (true) {
            if (deadEnemyIndexSet.size() == enemyList.size()) {
                return;
            }

            int selection = random.nextInt(enemyList.size());
            if (deadEnemyIndexSet.contains(selection)) {
                continue;
            } else if (enemyList.get(selection).getCurrentHealth() <= 0) {
                deadEnemyIndexSet.add(selection);
            } else {
                enemyToAttack = enemyList.get(selection);
                break;
            }
        }

        int damage = calculateDamage(enemyToAttack);
        player.getCharacter().takeDamage(damage);
        System.out.println(enemyToAttack.getName() + " hits " + player.getCharacter().getName()
                + " for " + damage + " damage!");
        System.out.println(player.getCharacter().getName() + "'s current HP: " + player.getCharacter().getCurrentHealth()
                + "/" + player.getCharacter().getMaxHealth());
    }

    private int calculateDamage(Entity entity) {
        int min = entity.getMinDamage();
        int range = entity.getMaxDamage() - min;
        return random.nextInt(range + 1) + min;
    }

    private void calculateGoldDrop() {
        for (Enemy enemy : enemyList) {
            goldDrop += enemy.getGold();
        }
    }
}
