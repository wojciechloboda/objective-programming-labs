package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;

public class RectangularMap implements IWorldMap{
    private final MapVisualizer mVis;
    private final ArrayList<Animal> animalList = new ArrayList<Animal>();
    private final Vector2d boundsLowerLeft;
    private final Vector2d boundsUpperRight;
    private int mapElementsCount = 0;

    public RectangularMap(int width, int height){
        boundsLowerLeft = new Vector2d(0, 0);
        boundsUpperRight = new Vector2d(width - 1, height - 1);
        mVis = new MapVisualizer(this);
    }

    public int getMapElementsCount() {
        return mapElementsCount;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(boundsLowerLeft) || !position.precedes(boundsUpperRight)){
            return false;
        }

        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        mapElementsCount += 1;
        animalList.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return !(objectAt(position) == null);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(var placedAnimal : animalList){
            if(placedAnimal.isAt(position)){
                return placedAnimal;
            }
        }
        return null;
    }

    public String toString(){
        return mVis.draw(boundsLowerLeft, boundsUpperRight);
    }
}
