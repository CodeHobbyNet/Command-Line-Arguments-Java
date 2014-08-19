
package net.codehobby;

import java.util.HashMap;
import java.util.Map;

/**
 * This will parse command line arguments into a map that's easier to use in a program. 
 * It's meant to parse types of arguments like "-i 0" or "-i=0" with either one or two dashes.
 * @author Jeff Crone
 * @version 1.0
 */
public class CommandLineArguments
{
    private String[] args;
    
    /**
     * A constructor with the arguments to parse.
     * @param newArgs The arguments to parse.
     */
    public CommandLineArguments( String[] newArgs )
    {
        args = newArgs;
    }
    
    /**
     * A method to set the arguments to parse.
     * @param newArgs The arguments to parse.
     */
    public void setArgs( String[] newArgs )
    {
        args = newArgs;
    }
    
    public Map<String, String> parse() throws Exception
    {
        Map<String, String> argMap = new HashMap<String, String>();//Create the map that'll be returned.
        String arg = "";//A temporary holder for each argument.
        
        int i = 0;
        while( i < args.length )
        {
            if( args[i].startsWith("--") )
            {//If it starts with two dashes, put the argument as all but those two dashes.
                arg = args[i].substring(2);
            }
            else if( args[i].startsWith("-") )
            {//If it starts with one dash, put the argument as all but that dash.
                arg = args[i].substring(1);
            }
            else
            {
                throw new Exception( "Couldn't parse the arguments. Please use arguments like \"-i 0\" or \"-i=0\" or \"-i\"." );
            }
            
            if( arg.contains("=") )
            {//If the argument contains an equals sign, meaning it's something like "-i=0", parse it as such.
                String[] argParts = arg.split( "=", 2 );//Split the argument into before and after the equals sign.
                argMap.put( argParts[0], argParts[1] );//Put the two-part argument in the map.
            }
            else if( (i+1 < args.length) && !(args[i+1].contains("-")) )
            {//If this isn't an equals type of argument, meaning it might be something like "-i 0", check if the next one has a hyphen. If it doesn't, put both parts in the map.
                argMap.put( arg, args[i+1] );//Put the two-part argument in the map.
                i++;//Increment i so the method will move past the second part of this argument.
            }
            else
            {//This is just a single argument without an equals sign, like "-i", so just add it to the map with a null value.
                argMap.put( arg, "" );
            }
            
            i++;//Increment i to go to the next value.
        }
        
        return argMap;
    }
}
