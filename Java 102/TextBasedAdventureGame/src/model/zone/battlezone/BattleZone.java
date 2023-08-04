package model.zone.battlezone;

import model.entity.enemy.Enemy;
import model.zone.Zone;

import java.util.List;
import java.util.Random;

public abstract class BattleZone implements Zone {
    protected String name;
    protected String description;
    protected List<Enemy> enemyList;
    protected boolean isCleared;
    protected Random random;

    public BattleZone(String name, String description, Random random) {
        this.name = name;
        this.description = description;
        this.random = random;
    }

    public BattleZone(String name, String description, List<Enemy> enemyList, Random random) {
        this.name = name;
        this.description = description;
        this.enemyList = enemyList;
        this.isCleared = false;
        this.random = random;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public void setCleared(boolean cleared) {
        isCleared = cleared;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "BattleZone{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", enemyList=" + enemyList +
                ", isCleared=" + isCleared +
                '}';
    }
}
