import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Langton extends JFrame {
    private AnimationPanel panel;
    private static final int ZOOM = 4;
    public Langton() {
        panel = new AnimationPanel();
        panel.setSize(panel.world.WIDTH, panel.world.HEIGHT);
        add(panel);
        setSize(ZOOM * panel.world.WIDTH, ZOOM * panel.world.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        animate();
    }

    void animate() {
        while (true) {
            repaint();
        }
    }

    
    public static void main(String[] args) {
        Langton app = new Langton();
    }
    public class AnimationPanel extends JPanel {
        World world;
        AnimationPanel() {
            world = new World(12000, 13, 120, 200);
        }
        @Override
        public void paint(Graphics g) {
            world.doStep();
            for (int y = 0; y < world.HEIGHT; y++) {
                for (int x = 0; x < world.WIDTH; x++) {
                    switch (world.grid[y][x].tileColor) {
                        case WHITE:  
                            g.setColor(Color.WHITE);
                            break;
                        case BLACK: 
                            g.setColor(Color.BLACK);
                            break;
                        case GREEN:
                            g.setColor(Color.GREEN);
                            break;
                        case BLUE:
                            g.setColor(Color.BLUE);
                            break;
                    }
                    g.fillRect(x * ZOOM, y * ZOOM, ZOOM, ZOOM);
                }
            }
            for (Ant ant : world.ants) {
                g.setColor(Color.RED);
                g.fillRect(ant.location.x * ZOOM, ant.location.y * ZOOM, ZOOM, ZOOM);
            }
        }
    }
}
