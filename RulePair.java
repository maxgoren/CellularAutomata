
public class RulePair {
    private TurnDirection turning;
    private TileColor nextColor;
    public RulePair(TurnDirection t, TileColor c) {
        turning = t;
        nextColor = c;
    }
    public TurnDirection getTurnDirection() {
        return turning;
    }
    public void setTurnDirection(TurnDirection dir) {
        turning = dir;
    }
    public TileColor getNextColor() {
        return nextColor;
    }
    public void setNextColor(TileColor nc) {
        nextColor = nc;
    }
}