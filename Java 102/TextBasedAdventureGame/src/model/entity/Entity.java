package model.entity;

public abstract class Entity {
    protected String name;
    protected int minDamage;
    protected int maxDamage;
    protected int maxHealth;
    protected int currentHealth;
    protected int gold;

    public Entity(String name, int minDamage, int maxDamage, int maxHealth, int gold) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.gold = gold;
    }

    public Entity(int minDamage, int maxDamage, int maxHealth, int gold) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.gold = gold;
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }

    public void heal(int amount) {
        this.currentHealth += amount;
    }

    public void healCompletely() {
        this.currentHealth = this.maxHealth;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name=" + name +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", gold=" + gold +
                '}';
    }
}
