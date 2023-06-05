import java.util.List;

public class Ant {
    public static int HEIGHT;
    public static int WIDTH;
    public Point location;
    public List<Point> compass;
    public List<String> directions;
    public Direction direction;
    public Ant(int sx, int sy, Direction sdirection, int ht, int wt) {
        HEIGHT = ht;
        WIDTH = wt;
        direction = sdirection;
        location = new Point(sx, sy);
        compass = List.of(new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0));
        directions = List.of("North", "South", "East", "West");
    }
    public void move(Tile[][] grid) {
        //System.out.println("Location: " + location.x + "/" + location.y + " Facing " + directions.get(direction.ordinal()));
        switch (grid[location.y][location.x].tileColor) {
            case BLACK:
                turnRight();
                grid[location.y][location.x].tileColor = TileColor.WHITE;
                break;
            case WHITE:
                turnLeft();
                grid[location.y][location.x].tileColor = TileColor.BLACK;
                break;
        }
        location.x = Math.abs(((location.x + compass.get(direction.ordinal()).x) + WIDTH) % WIDTH);
        location.y = Math.abs(((location.y + compass.get(direction.ordinal()).y) + HEIGHT) % HEIGHT);
        //System.out.println("New Location: " + location.x + "/" + location.y + " Facing " + directions.get(direction.ordinal()));
    }
    public void turnRight() {
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
    public void turnLeft() {
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