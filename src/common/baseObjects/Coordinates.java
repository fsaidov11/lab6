package common.baseObjects;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int x; //Максимальное значение поля: 461
    private Long y; //Поле не может быть null

    public Coordinates(int x, Long y) {
        this.x = x;
        this.y = y;

    }

    public Coordinates() {

    }

    public int getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "common.baseObjects.Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
