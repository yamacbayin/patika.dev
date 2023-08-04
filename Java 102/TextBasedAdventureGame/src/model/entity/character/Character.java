package model.entity.character;

import model.Inventory;
import model.entity.Entity;
import model.item.Armor;
import model.item.EquippableItem;
import model.item.Weapon;

public abstract class Character extends Entity {
    private String name;
    private int armorRating;
    private Armor equippedArmor;
    private Weapon equippedWeapon;
    private Inventory inventory;

    public Character(int minDamage, int maxDamage, int maxHealth, int gold, String name) {
        super(minDamage, maxDamage, maxHealth, gold);
        this.name = name;
        this.armorRating = 0;
        this.inventory = new Inventory();
    }

    @Override
    public void takeDamage(int damage) {
        int armorRatingReduction = armorRating / 4;
        int damageAfterReduction = Math.max(damage - armorRatingReduction, 0);
        this.currentHealth -= damageAfterReduction;
    }

    public void equipItem(EquippableItem item) {
        if (item instanceof Armor) {
            if (equippedArmor != null) {
                equippedArmor.unequip(this);
            }
            equippedArmor = (Armor) item;
            equippedArmor.equip(this);
        } else if (item instanceof Weapon) {
            if (equippedWeapon != null) {
                equippedWeapon.unequip(this);
            }
            equippedWeapon = (Weapon) item;
            equippedWeapon.equip(this);
        }
    }

    public void unequipItem(EquippableItem item) {
        if (item instanceof Armor) {
            equippedArmor.unequip(this);
            equippedArmor = null;
        } else if (item instanceof Weapon) {
            equippedWeapon.unequip(this);
            equippedWeapon = null;
        }
    }

    public void increaseAttackPower(int minDamage, int maxDamage) {
        this.minDamage += minDamage;
        this.maxDamage += maxDamage;
    }

    public void decreaseAttackPower(int minDamage, int maxDamage) {
        this.minDamage -= minDamage;
        this.maxDamage -= maxDamage;
    }

    public void increaseArmorRating(int amount) {
        this.armorRating += amount;
    }

    public void decreaseArmorRating(int amount) {
        this.armorRating -= amount;
        if (armorRating < 0) {
            armorRating = 0;
        }
    }

    public void addBonusHealth(int amount) {
        this.maxHealth += amount;
        this.currentHealth += amount;
    }

    public void removeBonusHealth(int amount) {
        this.maxHealth -= amount;
        if (this.currentHealth - amount <= 0) {
            currentHealth = 1;
        } else {
            this.currentHealth -= amount;
        }
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", armorRating=" + armorRating +
                ", equippedArmor=" + equippedArmor +
                ", equippedWeapon=" + equippedWeapon +
                ", inventory=" + inventory +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", gold=" + gold +
                '}';
    }
}
