/*
 * The MIT License
 *
 * Copyright 2014 Code Hobby
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/*
 * See the GitHub repository at
 * https://github.com/CodeHobbyNet/Command-Line-Arguments-Java
 */

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
