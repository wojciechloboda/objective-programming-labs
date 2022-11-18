package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d boundsLowerLeft;
    private final Vector2d boundsUpperRight;

    public RectangularMap(int width, int height){
        super();
        boundsLowerLeft = new Vector2d(0, 0);
        boundsUpperRight = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(boundsLowerLeft) || !position.precedes(boundsUpperRight)){
            return false;
        }

        return !isOccupied(position);
    }

    @Override
    protected Vector2d getLeftLowerBound(){
        return boundsLowerLeft;
    }

    @Override
    protected Vector2d getRightUpperBound(){
        return boundsUpperRight;
    }
}
