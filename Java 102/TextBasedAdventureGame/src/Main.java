import service.GameMap;
import service.ZoneLoaderService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

/*        GameMap gameMap = new GameMap();
        ZoneLoaderService zoneLoaderService = new ZoneLoaderService(new Random());
        zoneLoaderService.loadZones(gameMap);
        System.out.println(gameMap);

        gameMap.test();*/

        GameMaster gameMaster = new GameMaster();
        gameMaster.run();
    }
}