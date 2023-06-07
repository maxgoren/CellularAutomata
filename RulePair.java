
public class RulePair {
    public TurnDirection turning;
    public TileColor nextColor;
    public RulePair(TurnDirection t, TileColor c) {
        turning = t;
        nextColor = c;
    }
}