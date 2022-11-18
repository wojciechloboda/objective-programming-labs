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

        if(!elementsMap.isEmpty()){
            Vector2d existingPosition = elementsMap.keySet().iterator().next();
            upperRightSightLimit = elementsMap.get(existingPosition).getPosition();
            lowerLeftSightLimit = elementsMap.get(existingPosition).getPosition();
        }
        else{
            lowerLeftSightLimit = new Vector2d(0 ,0);
            upperRightSightLimit = new Vector2d(0, 0);
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position) instanceof Animal){
            return false;
        }

        if(objectAt(position) instanceof Grass){
            elementsMap.remove(position);
            placeGrass();
        }

        return true;
    }

    @Override
    protected Vector2d getLeftLowerBound(){
        if(elementsMap.isEmpty()){
            lowerLeftSightLimit = new Vector2d(0, 0);
        }

        lowerLeftSightLimit = elementsMap.keySet().iterator().next();
        for(var placedElementPosition : elementsMap.keySet()){
            lowerLeftSightLimit = lowerLeftSightLimit.lowerLeft(placedElementPosition);
        }
        return lowerLeftSightLimit;
    }

    @Override
    protected Vector2d getRightUpperBound() {
        if(elementsMap.isEmpty()){
            upperRightSightLimit = new Vector2d(0, 0);
            return upperRightSightLimit;
        }

        upperRightSightLimit = elementsMap.keySet().iterator().next();
        for(var placedElementPosition : elementsMap.keySet()){
            upperRightSightLimit = upperRightSightLimit.upperRight(placedElementPosition);
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

        elementsMap.put(generatedPosition, new Grass(generatedPosition));
    }

    private void initGrass(){
        for(int i = 0; i < this.grassElementsCount; i++){
            placeGrass();
        }
    }
}
