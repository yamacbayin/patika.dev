package model.pokemon;

import model.ElementalTypeEnum;
import model.pokemonskill.PokemonSkill;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int normalDamage;
    private ElementalTypeEnum pokemonType;
    private int maxSkillCount;
    private List<PokemonSkill> pokemonSkillList;
    private int pokemonStrength;

    public Pokemon(String name, int maxHealth, int normalDamage, ElementalTypeEnum pokemonType, int maxSkillCount) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.normalDamage = normalDamage;
        this.pokemonType = pokemonType;
        this.maxSkillCount = maxSkillCount;
        this.pokemonSkillList = new ArrayList<>();
        calculateStrength();
    }

    public void heal(int healAmount) {
        this.currentHealth += healAmount;
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }

    public void healCompletely() {
        this.currentHealth = maxHealth;
    }

    public void addSkill(PokemonSkill pokemonSkill) {
        if (pokemonSkillList.size() < maxSkillCount) {
            pokemonSkillList.add(pokemonSkill);
            calculateStrength();
        } else {
            System.out.println("This Pokemon cannot learn more skills!");
        }
    }

    public int useSkill(PokemonSkill pokemonSkill) {
        if (pokemonSkill.getRemainingUses() > 0) {
            pokemonSkill.decreaseRemainingUses();
            return pokemonSkill.getExtraDamage();
        } else {
            System.out.println("No remaining uses are left for this skill!");
            return 0;
        }
    }

    private void calculateStrength() {
        int strength = 0;
        strength += maxHealth;
        for (PokemonSkill skill : pokemonSkillList) {
            strength += skill.getExtraDamage() * skill.getMaxUses();
        }
        this.pokemonStrength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getNormalDamage() {
        return normalDamage;
    }

    public void setNormalDamage(int normalDamage) {
        this.normalDamage = normalDamage;
    }

    public ElementalTypeEnum getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(ElementalTypeEnum pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getMaxSkillCount() {
        return maxSkillCount;
    }

    public void setMaxSkillCount(int maxSkillCount) {
        this.maxSkillCount = maxSkillCount;
    }

    public List<PokemonSkill> getPokemonSkillList() {
        return pokemonSkillList;
    }

    public void setPokemonSkillList(List<PokemonSkill> pokemonSkillList) {
        this.pokemonSkillList = pokemonSkillList;
    }

    public int getPokemonStrength() {
        return pokemonStrength;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", normalDamage=" + normalDamage +
                ", pokemonType=" + pokemonType +
                ", maxSkillCount=" + maxSkillCount +
                ", pokemonSkillList=" + pokemonSkillList +
                '}';
    }

}
