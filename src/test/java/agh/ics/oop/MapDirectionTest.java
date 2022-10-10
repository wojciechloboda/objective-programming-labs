package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {
    @Test
    public void testMapDirection_next(){
        Assertions.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }
}
