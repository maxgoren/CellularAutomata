
public class Tile extends Point {
    public TileColor tileColor;
    Tile(int x, int y, TileColor color) {
        super(x, y);
        this.tileColor = color;
    }
}
