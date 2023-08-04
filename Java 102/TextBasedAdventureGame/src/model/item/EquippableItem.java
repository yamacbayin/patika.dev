package model.item;

import model.entity.character.Character;

public abstract class EquippableItem extends Item {
    protected boolean isEquipped;
    // Constructor
    public EquippableItem(String name, int value) {
        super(name, value);
        isEquipped = false;
    }

    // Method to apply the effects of equipping the item
    public abstract void equip(Character character);

    // Method to remove the effects of unequipping the item
    public abstract void unequip(Character character);

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }
}
