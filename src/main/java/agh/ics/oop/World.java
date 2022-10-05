package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
    }

    private static void run(String strarr[]){

        for(String str : strarr){
            switch (str) {
                case "f":
                    System.out.println("Zwierzak idzie Do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie Do tyłu");
                    break;
                case "r":
                    System.out.println("Zwierzak idzie W prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak idzie W lewo");
                    break;
            }
        }

        /*
        System.out.println("zwierzak idzie do przodu");
        for(int i = 0; i < strarr.length; i++){
            System.out.print(strarr[i]);
            if(i != strarr.length - 1 )
                System.out.print(", ");
            else
                System.out.println();
        }
        */
    }
    /*
    private static Direction[] getEnumArr(String args[])
    {
        Direction enumArr[] = new Direction[] {} ;
        for(String str : args){
            switch (str) {
                case "f":
                    System.out.println("Zwierzak idzie Do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie Do tyłu");
                    break;
                case "r":
                    System.out.println("Zwierzak idzie W prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak idzie W lewo");
                    break;
            }
        }
    }
    */
}

