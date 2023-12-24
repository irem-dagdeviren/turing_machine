import java.util.HashMap;
import java.util.Map;

public class TuringMachineSimulator {

		private Map<String, State> states;
	    private String currentState;
	    private StringBuilder tape;
	    private int headPosition;

	    public TuringMachineSimulator() {
	    }
	    public TuringMachineSimulator( String input, Map<String, State> states, State startState) {
	        this.states = states;
	        this.currentState = startState.getName();
	        this.tape = new StringBuilder(input);
	        this.headPosition = 0;
	    }

	    public void run() {
	        System.out.print(currentState + " ");
	        while (!currentState.equals("qA") && !currentState.equals("qR")) {
	            char currentSymbol = getCurrentSymbol();
	            State currentStateObj = states.get(currentState);

	            if (currentStateObj == null || currentStateObj.getTransition(currentSymbol) == null) {
	                System.out.println("\nResult: Rejected");
	                return;
	            }

	            Transition transition = currentStateObj.getTransition(currentSymbol);
	            tape.setCharAt(headPosition, transition.getWriteSymbol());
	            currentState = transition.getToState();
	            moveHead(transition.getDirection());
	            System.out.print(currentState + " ");
	        }

	        System.out.println("\nResult: " + (currentState.equals("qA") ? "Accepted" : "Rejected"));
	    }

	    private char getCurrentSymbol() {
	        if (headPosition < 0 || headPosition >= tape.length()) {
	            return 'b'; // Assume blank symbol for out-of-bounds positions
	        }
	        return tape.charAt(headPosition);
	    }

	    private void moveHead(Direction direction) {
	        switch (direction) {
	            case LEFT:
	                if (headPosition == 0) {
	                    tape.insert(0, 'b'); // Insert blank symbol at the beginning if moving left from the leftmost position
	                } else {
	                    headPosition--;
	                }
	                break;
	            case RIGHT:
	                headPosition++;
	                if (headPosition == tape.length()) {
	                    tape.append('b'); // Assume blank symbol for extending the tape to the right
	                }
	                break;
	        }
	    }
	}

