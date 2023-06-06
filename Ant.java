import java.util.List;

public class Ant {
    public static int HEIGHT;
    public static int WIDTH;
    public Point location;
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
        switch (grid[location.y][location.x].tileColor) {
            case BLACK:
                turnRight();
                grid[location.y][location.x].tileColor = TileColor.WHITE;
                break;
            case WHITE:
                turnLeft();
                grid[location.y][location.x].tileColor = TileColor.GREEN;
                break;
            case GREEN:
                turnLeft();
                grid[location.y][location.x].tileColor = TileColor.BLUE;
                break;
            case BLUE:
                turnLeft();
                grid[location.y][location.x].tileColor = TileColor.BLACK;
                break;
        }
        //Infinit Grid, doesnt work so well with multiple ants, just makes a mess.
        //int nextX = (Math.abs(((location.x + compass.get(direction.ordinal()).x) + WIDTH) % WIDTH));
        //int nextY = (Math.abs(((location.y + compass.get(direction.ordinal()).y) + HEIGHT) % HEIGHT));
        int nextX = location.x + compass.get(direction.ordinal()).x;
        int nextY = location.y + compass.get(direction.ordinal()).y;
        if (nextX >= 0 && nextX < WIDTH && nextY >= 0 && nextY < HEIGHT) {
            location.x = nextX;
            location.y = nextY;
        }
    }
    public Point getLocation() {
        return this.location;
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