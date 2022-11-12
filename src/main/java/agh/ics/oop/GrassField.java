package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{
    private final int grassElementsCount;
    private Vector2d upperRightSightLimit;
    private Vector2d lowerLeftSightLimit;

    public GrassField(int grassElementsCount){
        super();
        this.grassElementsCount = grassElementsCount;
        this.initGrass();

        upperRightSightLimit = mapElementsList.get(0).getPosition();
        lowerLeftSightLimit = mapElementsList.get(0).getPosition();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position) && objectAt(position) instanceof Animal){
            return false;
        }

        if(objectAt(position) instanceof Grass){
            int ind = getIndexOfElementAtPosition(position);
            mapElementsList.remove(ind);
            placeGrass();
        }

        return true;
    }

    @Override
    protected Vector2d getLeftLowerBound(){
        for(var placedElement : mapElementsList){
            lowerLeftSightLimit = lowerLeftSightLimit.lowerLeft(placedElement.getPosition());
        }
        return lowerLeftSightLimit;
    }

    @Override
    protected Vector2d getRightUpperBound() {
        for(var placedElement : mapElementsList){
            upperRightSightLimit = upperRightSightLimit.upperRight(placedElement.getPosition());
        }
        return upperRightSightLimit;
    }

    private Vector2d generateRandomPositionForGrass(){
        int x;
        int y;
        x = ThreadLocalRandom.current().nextInt((int)Math.sqrt(this.grassElementsCount * 10));
        y = ThreadLocalRandom.current().nextInt((int)Math.sqrt(this.grassElementsCount * 10));
        return new Vector2d(x, y);
    }

    private void placeGrass(){
        Vector2d generatedPosition;
        do{
            generatedPosition = generateRandomPositionForGrass();
        }
        while(isOccupied(generatedPosition));

        mapElementsList.add(new Grass(generatedPosition));
    }

    private void initGrass(){
        for(int i = 0; i < this.grassElementsCount; i++){
            placeGrass();
        }
    }

    private int getIndexOfElementAtPosition(Vector2d position){
        for(int i = 0; i < mapElementsList.size(); i++){
            if(mapElementsList.get(i).isAt(position)){
                return i;
            }
        }
        return -1;
    }
}
