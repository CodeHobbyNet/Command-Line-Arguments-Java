
package net.codehobby;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An app that will use CommandLineArguments to parse the command line arguments.
 * @author Jeff Crone
 */
public class CommandLineArgumentsApp {

    /**
     * The start of execution. Do some testing for the CommandLineArguments class.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        CommandLineArguments cla = new CommandLineArguments( args );
        Map<String, String> arguments = new HashMap<String, String>();
        
        try {
            arguments = cla.parse();
        } catch (Exception ex) {
            System.err.println( "Error parsing the arguments: " + ex.getMessage() );
        }
        
        for( Map.Entry<String, String> argument : arguments.entrySet() )
        {//Go through each argument and print it out.
            if( argument.getValue().equalsIgnoreCase("") )
            {//If it's an argument without a value, like "-i", just print the argument.
                System.out.println( "Argument: " + argument.getKey() );
            }
            else
            {//If it's an argument with a value, like "-i 0", print the argument and value.
                System.out.println( "Argument: " + argument.getKey() + " with value: " + argument.getValue() );
            }
        }
    }
    
}
