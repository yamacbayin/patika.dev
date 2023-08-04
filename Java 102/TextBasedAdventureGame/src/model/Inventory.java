package model;

import model.item.Armor;
import model.item.Item;
import model.item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {



    private List<Item> itemList;

    public Inventory() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void addItems(List<Item> itemList) {
        this.itemList.addAll(itemList);
    }

    public void removeItem(int index) {
        itemList.remove(index);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void printInventory() {
        if (itemList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i) instanceof Weapon weapon) {
                    String isEquipped = weapon.isEquipped() ? " -EQUIPPED- " : "";
                    System.out.println((i + 1) + ". " + weapon.getName() + " - Damage: " + weapon.getMinDamage()
                            + "-" + weapon.getMaxDamage() + " Type: " + weapon.getWeaponType()
                            + " Price: " + weapon.getValue() + isEquipped);
                } else {
                    Armor armor = (Armor) itemList.get(i);
                    String isEquipped = armor.isEquipped() ? " -EQUIPPED- " : "";
                    System.out.println((i + 1) + ". " + armor.getName() + " - Armor Rating: " + armor.getArmorRating()
                            + " Health Bonus: " + armor.getHealthBonus() + " Type: " + armor.getArmorType()
                            + " Price: " + armor.getValue() + isEquipped);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemList=" + itemList +
                '}';
    }
}
