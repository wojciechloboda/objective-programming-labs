package agh.ics.oop;
import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        try{
            ArrayList<MoveDirection> directions = OptionsParser.parse(args);
            GrassField map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}

