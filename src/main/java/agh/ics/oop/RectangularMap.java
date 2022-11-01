package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;

public class RectangularMap implements IWorldMap{
    private ArrayList<Animal> animalList = new ArrayList<Animal>();
    private final Vector2d boundsLowerLeft;
    private final Vector2d boundsUpperRight;

    public RectangularMap(int width, int height){
        boundsLowerLeft = new Vector2d(0, 0);
        boundsUpperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(boundsLowerLeft) || !position.precedes(boundsUpperRight)){
            return false;
        }

        for(var placedAnimal : animalList){
            if(placedAnimal.isAt(position)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())){
            return false;
        }

        animalList.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(var placedAnimal : animalList){
            if(placedAnimal.isAt(position)){
                return true;
            }
        }
        return false;
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
        MapVisualizer mVis = new MapVisualizer(this);
        return mVis.draw(boundsLowerLeft, boundsUpperRight);
    }
}
