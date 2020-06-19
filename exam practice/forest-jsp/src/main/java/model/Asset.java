package model;

import java.util.Objects;

public class Asset {
    private int id;
    private int user_id;
    private String name;
    private String description;
    private int value;

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return id == asset.id &&
                user_id == asset.user_id &&
                value == asset.value &&
                Objects.equals(name, asset.name) &&
                Objects.equals(description, asset.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, name, description, value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Asset(int id, int user_id, String name, String description, int value) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.value = value;
    }
}
