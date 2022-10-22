package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] args){
        var directionList = new ArrayList<MoveDirection>();

        for(String str : args){
            switch (str) {
                case "f", "forward" -> directionList.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionList.add(MoveDirection.BACKWARD);
                case "r", "right" -> directionList.add(MoveDirection.RIGHT);
                case "l", "left" -> directionList.add(MoveDirection.LEFT);
            }
        }

        return directionList;
    }
}
