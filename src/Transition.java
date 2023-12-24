
public class Transition {
    private State toState;
    private char writeSymbol;
    private Direction direction;

    public Transition(State toState, char writeSymbol, Direction direction) {
        this.toState = toState;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }

    public String getToState() {
        return toState.getName();
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public Direction getDirection() {
        return direction;
    }
}