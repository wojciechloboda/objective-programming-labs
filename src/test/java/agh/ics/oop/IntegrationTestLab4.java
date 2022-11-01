package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class IntegrationTestLab4 {

    @Test
    void test1AnimalMove(){
        String[] args = {"f", "f", "f", "f"};
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);

        IWorldMap map = new RectangularMap(5, 5);
        ArrayList<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();


        Assertions.assertEquals(new Vector2d(2, 5), engine.getAnimals().get(0).getPosition());
    }

    @Test
    void test2AnimalsMove(){
        String[] args = {"f", "r", "f", "f"};
        ArrayList<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(2, 3));

        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(new Vector2d(2, 2), engine.getAnimals().get(0).getPosition());
        Assertions.assertEquals(new Vector2d(3, 3), engine.getAnimals().get(1).getPosition());
    }

    @Test
    void test2AnimalsPlacement(){
        String[] args = {"f", "r", "f", "f"};
        ArrayList<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(3,3));
        positions.add(new Vector2d(3, 3));

        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(1, engine.getAnimals().size());
    }
}
