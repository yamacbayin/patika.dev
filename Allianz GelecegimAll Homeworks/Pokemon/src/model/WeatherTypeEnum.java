package model;

public enum WeatherTypeEnum {
    RAIN("Water"),
    SUNNY("Fire"),
    SANDSTORM("Earth"),
    THUNDERSTORM("Electric");

    private final String weatherString;

    WeatherTypeEnum(String weatherString) {
        this.weatherString = weatherString;
    }

    public String getString() {
        return weatherString;
    }
}