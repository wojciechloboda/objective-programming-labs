package agh.ics.oop;
//test
public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] enumArr = getEnumArr(args);
        run(enumArr);
        System.out.println("Stop");
    }

    private static void run(Direction[] enumArr){
        for(Direction dir : enumArr){
            switch (dir) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca W lewo");
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

