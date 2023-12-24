import java.util.Map;

public class TuringMachineSimulator {

		private Map<String, State> states;
	    private String currentState;
	    private StringBuilder tape;
	    private int headPosition;
	    Main input = new Main();
	    State accept = Main.acceptState;
	    State reject = Main.rejectState;
	    char blank = Main.blankSymbol;
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
	        while (!currentState.equals(accept.getName()) && !currentState.equals(reject.getName())) {
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

	        System.out.println("\nResult: " + (currentState.equals(accept.getName()) ? "Accepted" : "Rejected"));
	    }

	    private char getCurrentSymbol() {
	        if (headPosition < 0 || headPosition >= tape.length()) {
	            return blank; 
	        }
	        return tape.charAt(headPosition);
	    }

	    private void moveHead(Direction direction) {
	        switch (direction) {
	            case LEFT:
	                if (headPosition == 0) {
	                    tape.insert(0, blank); 
	                } else {
	                    headPosition--;
	                }
	                break;
	            case RIGHT:
	                headPosition++;
	                if (headPosition == tape.length()) {
	                    tape.append(blank); 	                }
	                break;
	        }
	    }
	}

