import java.util.List;

public class Ant {
    private int HEIGHT;
    private int WIDTH;
    private Point location;
    private StateMaps stateMaps;
    private List<Point> compass;
    private Direction direction;
    private int id;
    public Ant(int sx, int sy, int uid, Direction sdirection, int ht, int wt, StateMaps sm) {
        id = uid;
        HEIGHT = ht;
        WIDTH = wt;
        direction = sdirection;
        location = new Point(sx, sy);
        compass = List.of(new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0));
        stateMaps = sm;
    }
    public int getId() {
        return id;
    }
    public void move(Tile[][] grid) {
        changeColorAndDirectionState(grid, stateMaps.getRules().get(grid[location.getY()][location.getX()].getTileColor()));
        takeStep(grid);
    }
    public Point getLocation() {
        return this.location;
    }
    private void changeColorAndDirectionState(Tile[][] grid, RulePair rule) {
        if (rule.getTurnDirection().equals(TurnDirection.LEFT)) {
            turnLeft();
            flipColor(grid, rule.getNextColor());
        } else {
            turnRight();
            flipColor(grid, rule.getNextColor());
        }
    }
    private void flipColor(Tile[][] grid, TileColor color) {
        grid[location.getY()][location.getX()].setTileColor(color);
    }
    private void turnRight() {
        direction = stateMaps.getRightTurns().get(direction);
    }
    private void turnLeft() {
        direction = stateMaps.getLeftTurns().get(direction);
    }
    private void takeStep(Tile[][] grid) {
        int nextX = (Math.abs(((location.getX() + compass.get(direction.ordinal()).getX()) + WIDTH) % WIDTH));
        int nextY = (Math.abs(((location.getY() + compass.get(direction.ordinal()).getY()) + HEIGHT) % HEIGHT));
        if (!grid[nextY][nextX].isOccupied()) {
            grid[location.getY()][location.getX()].setOccupied(false);
            location.setX(nextX);
            location.setY(nextY);
            grid[location.getY()][location.getX()].setOccupied( true);
        }
    }
}