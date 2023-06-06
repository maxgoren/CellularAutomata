import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class World {
    public static int HEIGHT; 
    public static int WIDTH;
    public Tile[][] grid;
    public List<Ant> ants;
    public int numIters;
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
        Random rng = new Random();
        List<Direction> dirs = List.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);
        for (int i = 0; i < numAnts; i++) {
            ants.add(new Ant(rng.nextInt(WIDTH), rng.nextInt(HEIGHT), dirs.get(rng.nextInt(dirs.size())), HEIGHT, WIDTH));
        }
    }
    void doStep() {
        for (int i = 0; i < numIters; i++) {
            ants.forEach(ant -> ant.move(grid));
        }
    }
}
