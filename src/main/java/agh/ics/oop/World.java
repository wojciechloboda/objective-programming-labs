package agh.ics.oop;
import java.util.Arrays;
import java.util.stream.*;

public class World {
    public static void main(String[] args) {
        MapDirection dir = MapDirection.NORTH;
        System.out.println(dir.previous().next().toString());
        System.out.println(dir.toUnitVector().toString());
    }
}

