package common.baseObjects;

import server.ServerStatusRegister;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Dragon implements Comparable<Dragon>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private Integer wingspan; //Значение поля должно быть больше 0, Поле не может быть null
    private DragonType type; //Поле не может быть null
    private Person killer; //Поле может быть null

    public Dragon(String name, Coordinates coordinates, int age, String description, Integer wingspan, DragonType type, Person killer) {
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.type = type;
        this.killer = killer;
        this.id = generateId();
        this.creationDate = generateDate();
    }

    public Dragon() {}

    public int generateId() {
        int number = (int) (Math.random() * 100000 + 1);
        if (ServerStatusRegister.idList.contains(number)) {
            return generateId();
        }
        ServerStatusRegister.idList.add(number);
        return number;
    }

    public ZonedDateTime generateDate() {
        return ZonedDateTime.now();
    }

    public String getDescription() {
        if (description == null) return null;
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setWingspan(Integer wingspan) {
        this.wingspan = wingspan;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public DragonType getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public Integer getWingspan() {
        return wingspan;
    }

    public Person getKiller() {
        if (killer == null) return null;
        return killer;
    }

    @Override
    public String toString() {
        return "common.baseObjects.Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", wingspan=" + wingspan +
                ", type=" + type +
                ", killer=" + killer +
                '}';
    }

    @Override
    public int compareTo(Dragon o) {
        return this.wingspan - o.wingspan;
    }


}
