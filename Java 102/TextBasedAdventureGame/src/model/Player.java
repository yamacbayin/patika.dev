package model;

import model.entity.character.Character;

public class Player {
    private Inventory inventory;
    private String name;
    private Character character;
    private String currentZone;

    public Player(String name) {
        this.name = name;
    }

    public Player(Inventory inventory, String name, Character character, String currentZone) {
        this.inventory = inventory;
        this.name = name;
        this.character = character;
        this.currentZone = currentZone;
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

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(String currentZone) {
        this.currentZone = currentZone;
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + inventory +
                ", name='" + name + '\'' +
                ", character=" + character +
                ", currentZone=" + currentZone +
                '}';
    }
}
