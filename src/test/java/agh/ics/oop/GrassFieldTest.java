package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    private final GrassField map = new GrassField(20);

    @Test
    public void TestPlace(){
        Animal a1 = new Animal(map, new Vector2d(2, 2));
        Animal a2 = new Animal(map, new Vector2d(0, 0));
        Animal a3 = new Animal(map, new Vector2d(0, 0));
        Animal a4 = new Animal(map, new Vector2d(100, 100));

        Assertions.assertTrue(map.place(a1));
        Assertions.assertTrue(map.place(a2));
        Assertions.assertFalse(map.place(a3));
        Assertions.assertTrue(map.place(a4));
    }

    @Test
    public void testIsOccupied(){
        Animal a1 = new Animal(map, new Vector2d(2, 2));
        Animal a2 = new Animal(map, new Vector2d(0, 0));

        map.place(a1);
        map.place(a2);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2, 2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    public void testCanMoveTo(){
        Animal a1 = new Animal(map, new Vector2d(2, 2));

        map.place(a1);

        Assertions.assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(-1000, -1000)));
    }

    @Test
    public void testObjectAt(){
        Animal a1 = new Animal(map, new Vector2d(2, 2));

        map.place(a1);

        Assertions.assertEquals(a1, map.objectAt(new Vector2d(2, 2)));
    }
}
