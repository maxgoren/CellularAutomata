import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Langton extends JFrame {
    private World world;
    private JPanel panel;
    private static final int ZOOM = 4;
    public Langton() {
        world = new World(27000, 9, 175, 300);
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                world.doStep();
                for (int y = 0; y < world.HEIGHT; y++) {
                    for (int x = 0; x < world.WIDTH; x++) {
                        g.setColor(world.grid[y][x].getTileColor() == TileColor.WHITE ? Color.WHITE:Color.BLACK);
                        g.fillRect(x * ZOOM, y * ZOOM, ZOOM, ZOOM);
                    }
                }
            }
        };
        panel.setSize(world.WIDTH, world.HEIGHT);
        add(panel);
        setSize(ZOOM * world.WIDTH, ZOOM * world.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    public static void main(String[] args) {
        Langton app = new Langton();
    }
}
