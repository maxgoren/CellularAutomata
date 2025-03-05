import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class World {
    private int HEIGHT; 
    private int WIDTH;
    public Tile[][] grid;
    private List<Ant> ants;
    private int numIters;
    private StateMaps stateMaps;
    public World(int maxIters, int numAnts, int ht, int wt) {
        HEIGHT = ht;
        WIDTH = wt;
        grid = (Tile[][]) new Tile[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = new Tile(j,i , TileColor.WHITE);
            }
        }  
        numIters = maxIters;
        ants = new LinkedList<Ant>();
        stateMaps = new StateMaps();
        Random rng = new Random();
        List<Direction> dirs = List.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);
        for (int i = 0; i < numAnts; i++) {
            int sx = 0, sy = 0;
            do {
                sx = rng.nextInt(WIDTH);
                sy = rng.nextInt(HEIGHT);
            } while (grid[sy][sx].isOccupied());
            grid[sy][sx].setOccupied(true);
            ants.add(new Ant(sx, sy, i, dirs.get(rng.nextInt(dirs.size())), HEIGHT, WIDTH, stateMaps));
        }
    }
    void doStep() {
            ants.forEach(ant -> ant.move(grid));
    }
    public int getHeight() {
        return HEIGHT;
    }
    public int getWidth() {
        return WIDTH;
    }
    public List<Ant> getAnts() {
        return ants;
    }
}
