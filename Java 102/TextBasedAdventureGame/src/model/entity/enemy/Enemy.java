package model.entity.enemy;

import model.entity.Entity;

public abstract class Enemy extends Entity {

    public Enemy(String name, int minDamage, int maxDamage, int maxHealth, int gold) {
        super(name, minDamage, maxDamage, maxHealth, gold);
    }
}
