
public class Tile extends Point {
    public TileColor tileColor;
    Tile(int x, int y, TileColor color) {
        super(x, y);
        tileColor = color;
    }
    public void setTileColor(TileColor tileColr) {
        this.tileColor = tileColr;
    }
    public TileColor getTileColor() {
        return tileColor;
    }
}
