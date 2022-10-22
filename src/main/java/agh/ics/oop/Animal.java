package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection direction = MapDirection.NORTH;

    public String toString(){
        return this.position.toString() + ", " + this.direction.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
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
            if(newPosition.precedes(new Vector2d(4, 4)) && newPosition.follows(new Vector2d(0, 0))){
                this.position = newPosition;
            }
        }
    }


}
