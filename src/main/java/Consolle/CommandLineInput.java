package Consolle;

import java.util.HashMap;
import java.util.Map;

public enum CommandLineInput {
    FIND_ALL('1'), FIND_BY_NAME('2'),FIND_BY_AUTHOR('3'), ADD('4'), CHANGE('5'), DELETE('6'), EXIT('7');

    private final static Map<Character, CommandLineInput> INPUTS;

    static {
        INPUTS = new HashMap<Character, CommandLineInput>();
        for(CommandLineInput input: values()){
            INPUTS.put(input.getShortCmd(),input);
        }
    }

    private final char shortCmd;

    private CommandLineInput(char shortCmd){
        this.shortCmd = shortCmd;
    }

    public char getShortCmd(){
        return shortCmd;
    }

    public static CommandLineInput getCommandLineInputForInput(char input){
        return  INPUTS.get(input);
    }
}
