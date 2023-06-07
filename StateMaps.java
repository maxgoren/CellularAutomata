import java.util.HashMap;

public class StateMaps {
    public final HashMap<Direction, Direction> rightTurns;
    public final HashMap<Direction, Direction> leftTurns;
    public final HashMap<TileColor, RulePair> rules;
    public StateMaps() {
        rightTurns = new HashMap<>();
        leftTurns = new HashMap<>();
        rules = new HashMap<>();
        rightTurns.put(Direction.NORTH, Direction.EAST); 
        rightTurns.put(Direction.SOUTH, Direction.WEST); 
        rightTurns.put(Direction.EAST, Direction.SOUTH); 
        rightTurns.put(Direction.WEST, Direction.NORTH); 

        leftTurns.put(Direction.NORTH, Direction.WEST);
        leftTurns.put(Direction.SOUTH, Direction.EAST);
        leftTurns.put(Direction.EAST, Direction.NORTH);
        leftTurns.put(Direction.WEST, Direction.SOUTH);
        
        rules.put(TileColor.BLACK, new RulePair(TurnDirection.RIGHT, TileColor.WHITE));
        rules.put(TileColor.WHITE, new RulePair(TurnDirection.LEFT, TileColor.GREEN));
        rules.put(TileColor.GREEN, new RulePair(TurnDirection.RIGHT, TileColor.BLUE));
        rules.put(TileColor.BLUE, new RulePair(TurnDirection.LEFT, TileColor.RED));
        rules.put(TileColor.RED, new RulePair(TurnDirection.LEFT, TileColor.MAGENTA));
        rules.put(TileColor.MAGENTA, new RulePair(TurnDirection.RIGHT, TileColor.BLACK));
    }
}