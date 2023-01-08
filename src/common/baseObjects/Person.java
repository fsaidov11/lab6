package common.baseObjects;

import java.io.Serializable;

public class Person implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer weight; //Поле не может быть null, Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    public Person(String name, Integer weight, EyeColor eyeColor, HairColor hairColor,
                  Country nationality, Location location) {
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;

    }

    public Person() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getWeight() {
        return weight;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "common.baseObjects.Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

}
