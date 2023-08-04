package model.zone;

public abstract class AbstractZone implements Zone {
    protected String name;
    protected String description;

    public AbstractZone(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BaseZone{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
