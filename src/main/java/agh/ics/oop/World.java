package agh.ics.oop;
import java.util.Arrays;
import java.util.stream.*;

public class World {
    public static void main(String[] args) {
        Stream<String> argsStream = Arrays.stream(args);
        Stream<Direction> directionStream = argsStream.map(str -> switch (str){
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            default -> null;
        });

        System.out.println("Start");
        run(directionStream.toArray(Direction[]::new));
        System.out.println("Stop");
    }

    private static void run(Direction[] enumArr){
        for(Direction dir : enumArr){
            switch (dir) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }

    private static Direction[] getEnumArr(String args[])
    {
        Direction[] enumArr = new Direction[args.length];

        for(int i = 0; i < args.length; i++){
            switch (args[i]) {
                case "f" -> enumArr[i] = Direction.FORWARD;
                case "b" -> enumArr[i] = Direction.BACKWARD;
                case "r" -> enumArr[i] = Direction.RIGHT;
                case "l" -> enumArr[i] = Direction.LEFT;
            }
        }
        return enumArr;
    }

}

