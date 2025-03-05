
public class Tile extends Point {
    private TileColor tileColor;
    private boolean occupied;
    Tile(int x, int y, TileColor color) {
        super(x, y);
        tileColor = color;
        occupied = false;
    }
    public TileColor getTileColor() {
        return tileColor;
    }
    public void setTileColor(TileColor color) {
        tileColor = color;
    }
    public boolean isOccupied() {
        return occupied;
    }
    public void setOccupied(boolean status) {
        occupied = status;
    }
}
