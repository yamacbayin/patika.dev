package model.item;

import model.entity.character.Character;

public class Weapon extends EquippableItem {
    private int minDamage;
    private int maxDamage;
    private WeaponType weaponType;

    public Weapon(String name, int value, int minDamage, int maxDamage, WeaponType weaponType) {
        super(name, value);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.weaponType = weaponType;
    }

    @Override
    public void equip(Character character) {
        this.isEquipped = true;
        character.increaseAttackPower(this.minDamage, this.maxDamage);
    }

    @Override
    public void unequip(Character character) {
        this.isEquipped = false;
        character.decreaseAttackPower(this.minDamage, this.maxDamage);
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

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", weaponType=" + weaponType +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", isEquipped=" + isEquipped +
                '}';
    }
}
