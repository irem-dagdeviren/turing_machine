import java.util.HashMap;
import java.util.Map;

public class State {
	    private String name;
	    private Map<Character, Transition> transitions;

	    public State(String name) {
	        this.name = name;
	        this.transitions = new HashMap<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public void addTransition(char readSymbol, Transition transition) {
	        transitions.put(readSymbol, transition);
	    }

	    public Transition getTransition(char readSymbol) {
	        return transitions.get(readSymbol);
	    }
	}