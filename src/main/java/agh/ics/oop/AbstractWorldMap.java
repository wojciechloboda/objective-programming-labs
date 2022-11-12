package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{
    protected final MapVisualizer mVis;
    protected final ArrayList<IMapElement> mapElementsList = new ArrayList<IMapElement>();
    protected int placedElementsCount = 0;

    AbstractWorldMap(){
        mVis = new MapVisualizer(this);
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        placedElementsCount += 1;
        mapElementsList.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return !(objectAt(position) == null);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object res = null;
        for(var placedElement : mapElementsList){
            if(placedElement.isAt(position)){
                res = placedElement;
            }
        }
        return res;
    }

    protected abstract Vector2d getRightUpperBound();
    protected abstract Vector2d getLeftLowerBound();

    public String toString(){
        System.out.println("here");
        return mVis.draw(getLeftLowerBound(), getRightUpperBound());
    }


}
