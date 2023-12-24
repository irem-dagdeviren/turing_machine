import java.util.HashMap;
import java.util.Map;

public class Main {
	    public static void main(String[] args) {
	        // Define states and transitions
	        Map<String, State> states = new HashMap<>();
	        State qA = new State("qA");
	        State qR = new State("qR");

	        State q1 = new State("q1");
	        State q2 = new State("q2");
	        State q3 = new State("q3");
	        State q4 = new State("q4");
	        State q5 = new State("q5");
	        states.put("q1", q1);
	        states.put("q2", q2);
	        states.put("q3", q3);
	        states.put("q4", q4);
	        states.put("q5", q5);

	        q1.addTransition('0', new Transition(q2, 'X', Direction.RIGHT));
	        q1.addTransition('b', new Transition(qR, 'X', Direction.RIGHT));
	        q1.addTransition('X', new Transition(qR, 'X', Direction.RIGHT));
	        q2.addTransition('0', new Transition(q3, 'X', Direction.RIGHT));
	        q2.addTransition('X', new Transition(q2, 'X', Direction.RIGHT));
	        q2.addTransition('b', new Transition(qA, 'b', Direction.RIGHT));
	        q3.addTransition('X', new Transition(q3, 'X', Direction.RIGHT));
	        q3.addTransition('0', new Transition(q4, '0', Direction.RIGHT));
	        q3.addTransition('b', new Transition(q5, 'b', Direction.LEFT));
	        q4.addTransition('X', new Transition(q4, 'X', Direction.RIGHT));
	        q4.addTransition('0', new Transition(q3, 'X', Direction.RIGHT));
	        q4.addTransition('b', new Transition(qR, 'b', Direction.RIGHT));
	        q5.addTransition('0', new Transition(q5, '0', Direction.LEFT));
	        q5.addTransition('X', new Transition(q5, 'X', Direction.LEFT));
	        q5.addTransition('b', new Transition(q2, 'b', Direction.RIGHT));

	        TuringMachineSimulator tm1 = new TuringMachineSimulator("00", states, q1);
	        tm1.run(); // Output: q1 q2 q3 q5 q5 q2 q2 qA (route taken), Accepted

	        TuringMachineSimulator tm2 = new TuringMachineSimulator("000", states, q1);
	        tm2.run(); // Output: q1 q2 q3 q4 qR (route taken), Rejected
	    }
	}