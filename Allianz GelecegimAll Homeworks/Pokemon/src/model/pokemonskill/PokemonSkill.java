package model.pokemonskill;

import model.ElementalTypeEnum;

public class PokemonSkill {
    private String skillName;
    private int extraDamage;
    private final int maxUses;
    private int remainingUses;
    private ElementalTypeEnum skillType;

    public PokemonSkill(String skillName, int extraDamage, int maxUses, ElementalTypeEnum skillType) {
        this.skillName = skillName;
        this.extraDamage = extraDamage;
        this.maxUses = maxUses;
        this.remainingUses = maxUses;
        this.skillType = skillType;
    }

    public void decreaseRemainingUses() {
        this.remainingUses--;
    }

    public void refreshRemainingUses() {
        this.remainingUses = maxUses;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public ElementalTypeEnum getSkillType() {
        return skillType;
    }

    public void setSkillType(ElementalTypeEnum skillType) {
        this.skillType = skillType;
    }

    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public String toString() {
        return "Skill: " + skillName +
                ", Damage: " + extraDamage +
                ", Max Uses: " + maxUses +
                ", Remaining Uses: " + remainingUses +
                ", Type: " + skillType;
    }
}
