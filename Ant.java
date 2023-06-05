import java.util.List;

public class Ant {
    public static int HEIGHT;
    public static int WIDTH;
    private Point location;
    private List<Point> compass;
    private Direction direction;
    public Ant(int sx, int sy, Direction sdirection, int ht, int wt) {
        HEIGHT = ht;
        WIDTH = wt;
        direction = sdirection;
        location = new Point(sx, sy);
        compass = List.of(new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0));
    }
    public void move(Tile[][] grid) {
        switch (grid[location.getY()][location.getX()].getTileColor()) {
            case BLACK:
                turnRight();
                grid[location.getY()][location.getX()].setTileColor(TileColor.WHITE);
                break;
            case WHITE:
                turnLeft();
                grid[location.getY()][location.getY()].setTileColor(TileColor.BLACK);
                break;
        }
        location.setX(Math.abs(((location.getX() + compass.get(direction.ordinal()).getX()) + WIDTH) % WIDTH));
        location.setY(Math.abs(((location.getY() + compass.get(direction.ordinal()).getY()) + HEIGHT) % HEIGHT));
    }
    public Point getLocation() {
        return location;
    }
    private void turnRight() {
        switch(direction) {
            case NORTH: 
                direction = Direction.EAST; 
                break;
            case SOUTH: 
                direction = Direction.WEST; 
                break;
            case EAST: 
                direction = Direction.SOUTH; 
                break;
            case WEST: 
                direction = Direction.NORTH; 
                break;
        }
    }
    private void turnLeft() {
        switch(direction) {
            case NORTH: 
                direction = Direction.WEST; 
                break;
            case SOUTH: 
                direction = Direction.EAST; 
                break;
            case EAST: 
                direction = Direction.NORTH; 
                break;
            case WEST: 
                direction = Direction.SOUTH; 
                break;
        }
    }
}