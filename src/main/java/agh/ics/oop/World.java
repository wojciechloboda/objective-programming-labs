package agh.ics.oop;
import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        ArrayList<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,5));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}

