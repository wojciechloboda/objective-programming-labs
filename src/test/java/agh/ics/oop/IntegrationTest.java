package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {

    @Test
    public void testAnimalOrientation(){
        Animal animal = new Animal();
        Assertions.assertEquals("(2,2), Polnoc", animal.toString());
        animal.move(MoveDirection.RIGHT);
        Assertions.assertEquals("(2,2), Wschod", animal.toString());
        animal.move(MoveDirection.LEFT);
        Assertions.assertEquals("(2,2), Polnoc", animal.toString());
    }
    @Test
    public void testAnimalMove(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(2, 3)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(2, 1)));
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animal.isAt(new Vector2d(3, 1)));
    }

    @Test
    public void testAnimalInBounds(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals("(2,4), Polnoc", animal.toString());

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        Assertions.assertEquals("(4,4), Wschod", animal.toString());

        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals("(0,4), Wschod", animal.toString());
    }

    @Test
    public void testParse(){
        var args = new String[] {"f", "forward", "right", "f", "l", "left", "backward", "b"};
        var expected = new ArrayList<MoveDirection>(List.of(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD
        ));

        Assertions.assertEquals(expected, OptionsParser.parse(args));
    }
}
