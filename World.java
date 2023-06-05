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
        for (int i = 0; i < numAnts; i++) {
            ants.add(new Ant(rng.nextInt(WIDTH), rng.nextInt(HEIGHT), Direction.NORTH, HEIGHT, WIDTH));
        }
    }
    void doStep() {
        for (int i = 0; i < numIters; i++)
        for (Ant ant : ants) {
            ant.move(grid);
        }
    }
    /*
    DPRECTAED: 6/5/2023
    void show() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (ant.location.y == i && ant.location.x == j) {
                    System.out.print("%");
                } else {
                    switch (grid[i][j].tileColor) {
                        case BLACK:
                            System.out.print(".");
                            break;
                        case WHITE:
                            System.out.print(" ");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
    */
}
