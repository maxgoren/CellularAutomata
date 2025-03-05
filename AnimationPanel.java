import java.util.HashMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel {
    private static final int ZOOM = 4;
    private World world;
    HashMap<TileColor,Color> colorMap;
    public class actionListener implements ActionListener {
        private int counter;
        private int numIter;
        actionListener(int maxIter) {
            this.numIter = maxIter;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            world.doStep();
            counter++;
            if (counter == numIter) {
                ((Timer) e.getSource()).stop();
            }
            repaint();
        }
    }
    AnimationPanel(int numIters, int numAnts, int delay) {
        colorMap = new HashMap<>();
        colorMap.put(TileColor.WHITE, Color.WHITE);
        colorMap.put(TileColor.BLACK, Color.BLACK);
        colorMap.put(TileColor.GREEN, Color.GREEN);
        colorMap.put(TileColor.BLUE, Color.BLUE);
        colorMap.put(TileColor.RED, Color.RED);
        colorMap.put(TileColor.MAGENTA, Color.MAGENTA);
        world = new World(numIters, numAnts, 120, 200);
        Timer timer = new Timer(delay, new actionListener(numIters));
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        world.doStep();
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                g.setColor(colorMap.get(world.grid[y][x].getTileColor()));
                g.fillRect(x * ZOOM, y * ZOOM, ZOOM, ZOOM);
            }
        }
        for (Ant ant : world.getAnts()) {
            g.setColor(Color.RED);
            g.fillRect(ant.getLocation().getX() * ZOOM, ant.getLocation().getY() * ZOOM, ZOOM, ZOOM);
        }
    }
    public World getWorld() {
        return world;
    }
}