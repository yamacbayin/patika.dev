package model;

public enum WeatherTypeEnum {
    RAIN("Rain"),
    SUNNY("Sunny"),
    SANDSTORM("Sandstorm"),
    THUNDERSTORM("Thunderstorm");

    private final String weatherString;

    WeatherTypeEnum(String weatherString) {
        this.weatherString = weatherString;
    }

    public String getString() {
        return weatherString;
    }
}