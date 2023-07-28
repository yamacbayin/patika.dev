package model.trainerskill;

import model.ElementalTypeEnum;

public class TrainerSkill {
    private String skillName;
    private int skillEffectAmount;
    private final int maxUses;
    private int remainingUses;
    private TrainerSkillTypeEnum skillType;

    public TrainerSkill(String skillName, int skillEffectAmount, int maxUses, TrainerSkillTypeEnum skillType) {
        this.skillName = skillName;
        this.skillEffectAmount = skillEffectAmount;
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

    public int getSkillEffectAmount() {
        return skillEffectAmount;
    }

    public void setSkillEffectAmount(int skillEffectAmount) {
        this.skillEffectAmount = skillEffectAmount;
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public TrainerSkillTypeEnum getSkillType() {
        return skillType;
    }

    public void setSkillType(TrainerSkillTypeEnum skillType) {
        this.skillType = skillType;
    }

    @Override
    public String toString() {
        return "Trainer Skill: " + skillName +
                ", Effect Amount: " + skillEffectAmount +
                ", Max Uses: " + maxUses +
                ", Skill Type: " + skillType;
    }
}
