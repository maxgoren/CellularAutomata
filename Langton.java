import javax.swing.JFrame;

public class Langton extends JFrame {
    public static void main(String[] args) {
        Langton app = new Langton(-1, 13, 20);
    }

    private AnimationPanel panel;
    private static final int ZOOM = 4;
    public Langton(int numIters, int numAnts, int delay) {
        panel = new AnimationPanel(numIters, numAnts, delay);
        panel.setSize(panel.world.WIDTH, panel.world.HEIGHT);
        add(panel);
        setSize(ZOOM * panel.world.WIDTH, ZOOM * panel.world.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
