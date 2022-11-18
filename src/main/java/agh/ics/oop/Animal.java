package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;
    private final AbstractWorldMap map;

    private final List<IPositionChangeObserver> observersList;

    public Animal(AbstractWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.observersList = new ArrayList<IPositionChangeObserver>();
        this.addObserver(map);
    }

    public String toString(){
        return switch(direction){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection moveDirection){
        Vector2d newPosition = null;

        switch(moveDirection){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> newPosition = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.direction.toUnitVector());
        };

        if(newPosition != null){
            if(map.canMoveTo(newPosition)){
                positionChanged(this.position, newPosition);
                this.position = newPosition;
            }
        }
    }

    private void addObserver(IPositionChangeObserver observer){
        this.observersList.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer){
        this.observersList.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(var observer : this.observersList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
