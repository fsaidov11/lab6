package common.baseObjects;

import java.io.Serializable;

public class Location implements Serializable {
    private Double x; //Поле не может быть null
    private float y;
    private String name; //Поле не может быть null

    public Location(Double x, float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Location() {

    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "common.baseObjects.Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
