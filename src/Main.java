import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
	
	static State acceptState;
    static State rejectState;
    static char blankSymbol;
	    public static void main(String[] args) throws FileNotFoundException {
	        Map<String, State> states = new HashMap<>();
	        
	        Scanner scanner = new Scanner(new File("src\\\\input.txt"));
	        int inputAlphabetSize = scanner.nextInt();
        	System.out.println("# variables in input alphabet: " + inputAlphabetSize);

            int tapeAlphabetSize = scanner.nextInt();
        	System.out.println("# variables in tape alphabet: " + tapeAlphabetSize);

            int numberOfStates = scanner.nextInt();
        	System.out.println("# states: " + numberOfStates);

            System.out.print("States: ");
            for (int i = 0; i < numberOfStates; i++) {
                String stateName = scanner.next();
                states.put(stateName, new State(stateName));
            	System.out.print(stateName + " ");

            }
        	System.out.println();
            State startState = new State(scanner.next());
        	System.out.println("start State: " + startState.getName());

            acceptState = new State(scanner.next());
        	System.out.println("Accept State: " + acceptState.getName());

            rejectState = new State(scanner.next());
        	System.out.println("Reject State: " + rejectState.getName());

            blankSymbol = scanner.next().charAt(0);
            System.out.println("Blank Symbol: " + blankSymbol); 

            System.out.print("Tape Alphabet: ");

            String[] tapeAlphabet = new String[tapeAlphabetSize+1];
            for (int i = 0; i < tapeAlphabetSize+1; i++) {
                tapeAlphabet[i] = scanner.next();
            	System.out.print(tapeAlphabet[i] + " ");

            }
        	System.out.println();
            System.out.print("Input Alphabet: ");
            String[] inputAlphabet = new String[inputAlphabetSize];
            for (int i = 0; i < inputAlphabetSize; i++) {
            	inputAlphabet[i] = scanner.next();
            	System.out.print(inputAlphabet[i]);
            }
        	System.out.println();

            ArrayList<String> stringsToDetect = new ArrayList<>();
            
            scanner.nextLine();
            String line = "";
            while (scanner.hasNextLine())
            {
            	line = scanner.nextLine();    
            	String[] parsedLine = line.split(" ");
                if (parsedLine.length == 5){    
                	System.out.println(line);
	                String fromState = parsedLine[0];
	                char readSymbol = parsedLine[1].charAt(0);
	                char writeSymbol = parsedLine[2].charAt(0);
	                Direction direction = Direction.fromString(parsedLine[3]);
	                State toState = states.get(parsedLine[4]);
	
	                State state = states.get(fromState);
	                if (state != null) {
	                    state.addTransition(readSymbol, new Transition(toState, writeSymbol, direction));
	                }
                }
                else {
                	stringsToDetect.add(line);
                }
            }
           
           for ( String input: stringsToDetect) {
           	System.out.println("Strings To Detect: " + input);
   	        TuringMachineSimulator tm1 = new TuringMachineSimulator(input, states, startState);
   	        tm1.run();
           	System.out.println();


           }
            


	       
	    }
	}