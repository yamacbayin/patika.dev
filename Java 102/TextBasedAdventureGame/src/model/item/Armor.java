package model.item;

import model.entity.character.Character;

public class Armor extends EquippableItem {
    private int armorRating;
    private int healthBonus;
    private ArmorType armorType;

    public Armor(String name, int value, int armorRating, int healthBonus, ArmorType armorType) {
        super(name, value);
        this.armorRating = armorRating;
        this.healthBonus = healthBonus;
        this.armorType = armorType;
    }

    @Override
    public void equip(Character character) {
        this.isEquipped = true;
        character.addBonusHealth(healthBonus);
        character.increaseArmorRating(armorRating);

    }

    @Override
    public void unequip(Character character) {
        this.isEquipped = false;
        character.removeBonusHealth(healthBonus);
        character.decreaseArmorRating(armorRating);
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "armorRating=" + armorRating +
                ", healthBonus=" + healthBonus +
                ", armorType=" + armorType +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", isEquipped=" + isEquipped +
                '}';
    }
}
