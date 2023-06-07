
public class Tile extends Point {
    public TileColor tileColor;
    public boolean occupied;
    Tile(int x, int y, TileColor color) {
        super(x, y);
        this.tileColor = color;
        this.occupied = false;
    }
}
