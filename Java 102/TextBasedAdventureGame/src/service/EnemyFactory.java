package service;

import model.entity.enemy.*;
import model.zone.battlezone.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFactory {
    private final Random random;

    public EnemyFactory(Random random) {
        this.random = random;
    }


    public List<Enemy> createEnemiesForZone(BattleZone battleZone, int numEnemies,
                                            int minDamage, int maxDamage, int minHealth, int maxHealth,
                                            int minGold, int maxGold) {
        List<Enemy> enemies = new ArrayList<>();
        int enemyNumber = random.nextInt(numEnemies) + 1;

        for (int i = 0; i < enemyNumber; i++) {
            enemies.add(createRandomEnemy(battleZone, minDamage, maxDamage, minHealth, maxHealth, minGold, maxGold));
        }

        return enemies;
    }

    private Enemy createRandomEnemy(BattleZone battleZone,
                                    int minDamage, int maxDamage, int minHealth, int maxHealth,
                                    int minGold, int maxGold) {
        int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
        int health = random.nextInt(maxHealth - minHealth + 1) + minHealth;
        int gold = random.nextInt(maxGold - minGold + 1) + minGold;

        if (battleZone instanceof Caves) {
            return new CaveGoblin("Cave Goblin", minDamage, damage, health, gold);
        } else if (battleZone instanceof Forest) {
            return new ForestTroll("Forest Troll", minDamage, damage, health, gold);
        } else if (battleZone instanceof Riverside) {
            return new WaterNymph("Water Nymph", minDamage, damage, health, gold);
        } else if (battleZone instanceof Mines) {
            return new DwarvenMiner("Dwarven Miner", minDamage, damage, health, gold);
        } else {
            throw new IllegalArgumentException("Unsupported battle zone type: " + battleZone.getClass().getName());
        }
    }

}
