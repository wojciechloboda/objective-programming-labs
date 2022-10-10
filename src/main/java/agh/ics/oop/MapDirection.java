package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachod";
            case EAST -> "Wschod";
        };
    }

    public MapDirection next(){
        return val[(ordinal() + 1) % val.length];
    }

    public MapDirection previous(){
        return val[Math.floorMod(ordinal() - 1, val.length)];
    }

    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
    }

    private final static MapDirection[] val = values();
}
