package model;

public enum ElementalTypeEnum {
    EARTH("Earth"),
    WATER("Water"),
    FIRE("Fire"),
    ELECTRIC("Electric");

    private final String typeString;

    ElementalTypeEnum(String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString() {
        return typeString;
    }

}
