/*
 * The MIT License
 *
 * Copyright 2014 jeff.
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
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jeff Crone
 */
public class CommandLineArgumentsTest {
    
    public CommandLineArgumentsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of the setArgs and getArgs methods of class CommandLineArguments.
     * It sets the args with setArgs, returns them with getArgs and compares the return with the original.
     */
    @Test
    public void testSetArgs() 
    {
        System.out.println("setArgs and getArgs");
        
        //Set up the object to use.
        String[] newArgs = {"-i", "newoutput.txt", "-o=output.txt", "-p", "-q", "1", "-t", "test text" };
        CommandLineArguments instance = new CommandLineArguments( null );
        
        //Give instance the arguments.
        instance.setArgs(newArgs);
        
        //Use the getArgs method to verify it returns the same values.
        Assert.assertArrayEquals( newArgs, instance.getArgs() );
    }

    /**
     * Test of parse method of class CommandLineArguments.
     * It gives some args as a String array, has the object parse the args and verifys the return value is what's expected.
     */
    @Test
    public void testParse() 
    {
        System.out.println("parse");
        
        //Set up the objects.
        String[] args = {"-i", "newoutput.txt", "-o=output.txt", "-p", "-q", "1", "-t", "test text" };//Input
        CommandLineArguments instance = new CommandLineArguments( args );//The object being tested.
        Map<String, String> expResult = new HashMap<>();//The expected results.
        expResult.put( "t", "test text" );
        expResult.put( "q", "1" );
        expResult.put( "p", "" );
        expResult.put( "o", "output.txt" );
        expResult.put( "i", "newoutput.txt" );
        Map<String, String> result = null;//The actual results.
        
        //Go ahead and parse the args.
        try {
            result = instance.parse();
        } catch (Exception ex) {
            fail( "parse() threw an exception: " + ex.getMessage() );
        }
        
        //Check to make sure the parse returned the expected results.
        assertEquals(expResult, result);
    }
    
}
