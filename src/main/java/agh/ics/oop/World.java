package agh.ics.oop;
import java.util.Arrays;
import java.util.stream.*;

public class World {
    public static void main(String[] args) {
        MapDirection dir = MapDirection.NORTH;
        System.out.println(dir.previous().next().toString());
        System.out.println(dir.toUnitVector().toString());
        System.out.println(" ");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}

