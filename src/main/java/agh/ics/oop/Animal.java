package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
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
                this.position = newPosition;
            }
        }
    }
}
