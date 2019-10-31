import Consolle.CommandLineInput;
import Consolle.CommandLineInputHandler;

public class Main {
    public static final char DEFAULT_INPUT = '\u0000';
    public static void main(String[] args) {

        CommandLineInputHandler commandLineInputHandler =
                new CommandLineInputHandler();

        char command = DEFAULT_INPUT;

        while(CommandLineInput.EXIT.getShortCmd()!= command){
            CommandLineInputHandler.printOptions();
            String input = commandLineInputHandler.readInput();
            char[] inputsChar = input.length() ==1 ? input.toCharArray(): new char[]{DEFAULT_INPUT};
            command = inputsChar[0];
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }
    }
}
