package agh.ics.oop;
import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        ArrayList<MoveDirection> directionList = OptionsParser.parse(args);
        for(MoveDirection dir : directionList){
            animal.move(dir);
            System.out.println(animal.toString());
        }
    }
}

