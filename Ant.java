import java.util.List;

public class Ant {
    public static int HEIGHT;
    public static int WIDTH;
    public Point location;
    public StateMaps stateMaps;
    private List<Point> compass;
    private Direction direction;
    public int id;
    boolean infiniteGrid;
    public Ant(int sx, int sy, int uid, Direction sdirection, int ht, int wt, StateMaps sm) {
        infiniteGrid = true;
        id = uid;
        HEIGHT = ht;
        WIDTH = wt;
        direction = sdirection;
        location = new Point(sx, sy);
        compass = List.of(new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0));
        stateMaps = sm;
    }
    public void move(Tile[][] grid) {
        changeColorAndDirectionState(grid, stateMaps.rules.get(grid[location.y][location.x].tileColor));
        takeStep(grid);
    }
    private void flipColor(Tile[][] grid, TileColor color) {
        grid[location.y][location.x].tileColor = color;
    }
    private void changeColorAndDirectionState(Tile[][] grid, RulePair rule) {
        if (rule.turning == TurnDirection.LEFT) {
            turnLeft();
            flipColor(grid, rule.nextColor);
        } else {
            turnRight();
            flipColor(grid, rule.nextColor);
        }
    }
    private void takeStep(Tile[][] grid) {
        int nextX = (Math.abs(((location.x + compass.get(direction.ordinal()).x) + WIDTH) % WIDTH));
        int nextY = (Math.abs(((location.y + compass.get(direction.ordinal()).y) + HEIGHT) % HEIGHT));
        if (grid[nextY][nextX].occupied == false) {
            grid[location.y][location.x].occupied = false;
            location.x = nextX;
            location.y = nextY;
            grid[location.y][location.x].occupied = true;
        }
    }
    public Point getLocation() {
        return this.location;
    }
    private void turnRight() {
        direction = stateMaps.rightTurns.get(direction);
    }
    private void turnLeft() {
        direction = stateMaps.leftTurns.get(direction);
    }
}