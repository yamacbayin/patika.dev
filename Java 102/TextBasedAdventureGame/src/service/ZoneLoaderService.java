package service;

import model.zone.SafeHouse;
import model.zone.Shop;
import model.zone.Zone;
import model.zone.battlezone.Caves;
import model.zone.battlezone.Forest;
import model.zone.battlezone.Mines;
import model.zone.battlezone.Riverside;

import java.util.ArrayList;
import java.util.Random;

public class ZoneLoaderService {

    private Random random;
    private EnemyFactory enemyFactory;

    public ZoneLoaderService(Random random) {
        this.random = random;
        enemyFactory = new EnemyFactory(random);
    }

    public void loadZones(GameMap gameMap) {

        Zone safeHouse = new SafeHouse("Safe House", "Welcome to your humble Safe House. " +
                "It's a place of solace and security where you can rest and recover.");
        Shop shop = new Shop("Trinkets Emporium Shop", "Step inside the mystical Trinkets Emporium, " +
                "where curious artifacts and powerful potions await.");
        Caves caves = new Caves("The Forbidden Caves", "Venture into the eerie darkness of the Forbidden " +
                "Caves, where mysterious creatures and hidden treasures lie.", random);
        Forest forest = new Forest("The Enchanted Forest", "Enter the mystical Enchanted Forest, " +
                "where ancient trees whisper secrets and enchantments fill the air.", random);
        Mines mines = new Mines("The Abandoned Mines", "Descend into the depths of the Abandoned Mines, " +
                "where echoing footsteps and forgotten riches dwell.", random);
        Riverside riverside = new Riverside("The Serene Riverside", "You find yourself at the tranquil " +
                "Serene Riverside, where the gentle flow of the river soothes your soul. Lush vegetation and colorful " +
                "flowers line the banks, and the sunlight dances on the water's surface.", random);


        forest.setEnemyList(enemyFactory.createEnemiesForZone(forest, 5, 10,
                30, 70, 100, 15, 50));
        caves.setEnemyList(enemyFactory.createEnemiesForZone(caves, 5, 30,
                60, 80, 110, 25, 60));
        mines.setEnemyList(enemyFactory.createEnemiesForZone(mines, 6, 60,
                80, 90, 120, 35, 70));
        riverside.setEnemyList(enemyFactory.createEnemiesForZone(riverside, 6, 70,
                100, 100, 130, 45, 80));

        gameMap.addZone(safeHouse);
        gameMap.addZone(shop);
        gameMap.addZone(caves);
        gameMap.addZone(forest);
        gameMap.addZone(mines);
        gameMap.addZone(riverside);

        gameMap.addConnection("Safe House", "The Serene Riverside");
        gameMap.addConnection("Safe House", "The Abandoned Mines");
        gameMap.addConnection("Safe House", "The Forbidden Caves");
        gameMap.addConnection("Safe House", "The Enchanted Forest");
        gameMap.addConnection("Safe House", "Trinkets Emporium Shop");

    }
}
