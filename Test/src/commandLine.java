/*=============================================================================
 |   Assignment:  Program for HW 6
 |       Author:  Storme Briscoe (stormeb@email.arizona.edu)
 |
 |       Course:  CSC 245    (Discrete Math)
 |   Instructor:  L. McCann
 | Sect. Leader:  Rachel
 |     Due Date:  November 9th, Beginning of class
 |
 |     Language:  Java 
 |     Packages:  java.io
 |  Compile/Run:  JDK:  Compile: javac Hmwk6.java
 |
 +-----------------------------------------------------------------------------
 |  Description:  This program calculates the cantor expression of an integer that is passed in through the command line
 |
 |        Input:  The user is required to enter in a valid integer that can be turned into a cantor expression
 |
 |       Output:  A string that displays the cantor expression
 |
 |   Techniques:  The program's steps are as follows:
 |
 |                      1.  Input is detected as a valid int
 |                      2.  The highest factorial is found
 |                      3.  Detect how many times it is found in the given int
 |                      4.  Find any zero factorials
 |                      5.  Repeat 2 and 3 until the given int equals 0
 |                      6.  Find any remaining 0 factorials
 |                      
 |
 |   Required Features Not Included:  All required features are included.
 |
 |   Known Bugs:  None; the program operates correctly.
 |
 *===========================================================================*/

import java.io.*;

public class commandLine {
	
	/*---------------------------------------------------------------------
    |  Method calculate_factorial
    |
    |  Purpose: This method correctly calculates factorial by doing a while loop and multiplying some variable by the current
    |  value of some variable, then decrementing the value passed into the function.
    |  
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters:
    |      x  -- This variable is passed in because the factorial of it will be computed
    |
    |  Returns:  It returns the factorial of x (x is the only parameter passed in
    *-------------------------------------------------------------------*/
	public static int calculate_factorial(int x){
		int z = 1;
		//A loop that will calculate the factorial
		for (int i = 1; i < x+1; i++){
			z *= i;
		}
		return z;
	}
	
	/*---------------------------------------------------------------------
    |  Method find_factorial
    |
    |  Purpose: This method correctly finds the highest factorial from the parameter given. Factorials are computed
    |  by the calculate_factorial function
    |  
    |  Pre-condition:  calculate_factorial works
    |
    |  Post-condition: That the highest factorial is given.
    |
    |  Parameters:
    |      x  -- This variable is passed in because the highest factorial needs to be found
    |
    |  Returns:  It returns the highest factorial that can be found from the given input
    *-------------------------------------------------------------------*/
	public static int find_factorial(int x, int y){
		while (x >= calculate_factorial(y)){
			y++;
		}
		return y-1;
	}
	
	/*---------------------------------------------------------------------
    |  Method factorial_amount
    |
    |  Purpose: This method correctly calculates how many times the given factorial goes into an integer that is passed in
    |  
    |  Pre-condition:  calculate_factorial works
    |
    |  Post-condition: That the factorial of the input has been calculated
    |
    |  Parameters:
    |      x  -- This variable is passed in because we need to know how many times y! goes into it
    |	   y  -- This variable is the factorial that will be calculated
    |
    |  Returns:  It returns how many times y! goes into the int x
    *-------------------------------------------------------------------*/
	public static int factorial_amount(int x, int y){
		int count = 0;
				
		while (x > 0){
			x -= calculate_factorial(y);
					
			if (x > 0 || x == 0)
				count++;
		}
				
		return count;
	}
	
	/*---------------------------------------------------------------------
    |  Method zero_exist
    |
    |  Purpose: See's if the given factorial cannot fit in the other int that is given
    |  
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters:
    |      x  -- This variable is passed will be compared against calculate_factorial(y) to see if there will be a zero for that factorial
    |      y  -- Used to be compared agaisnt x
    |
    |  Returns:  It returns true or false depending on if x is greater then calculate_factorial(y)
    *-------------------------------------------------------------------*/
	public static boolean zero_exist(int x, int y){
		if (x >= calculate_factorial(y)){
			return false;
		}
		else {
			return true;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method cantor
    |
    |  Purpose: This method correctly calculates factorial by doing a while loop and multiplying some variable by the current
    |  value of some variable, then decrementing the value passed into the function.
    |  
    |  Pre-condition:  None
    |
    |  Post-condition: That the factorial of the input has been calculated
    |
    |  Parameters:
    |      x  -- This variable is passed in because the factorial of it will be computed
    |
    |  Returns:  It returns the factorial of x (x is the only parameter passed in
    *-------------------------------------------------------------------*/
	public static String cantor(int x, String carry){
		if (x == 0)
			return carry;
		else{
			int factorial = find_factorial(x, 0);
			int count = factorial_amount(x, factorial);
			
			if (factorial == 1){
				x = x - calculate_factorial(factorial)*count;
				carry += count + "*" + factorial + "!";
				return cantor(x, carry);
			}
			else {
				x = x - calculate_factorial(factorial)*count;
				carry += count + "*" + factorial + "! + ";
				while(zero_exist(x, factorial-1) && factorial != 1){
					factorial -= 1;
					if (factorial - 1 == 0)
						carry += 0 + "*" + factorial + "!";
					else
						carry += 0 + "*" + factorial + "! + ";
				}
				return cantor(x, carry);
			}
		}
	}
	
	public static void main(String [] args){
		int argument;
		if (args.length != 1){
			System.out.print("Usage: java Hmwk6 <n>, where <n> is the positive Base-10\n\tinteger for which you'd like a Cantor Expansion.\n");
		}
		else {
			try {
		        argument = Integer.parseInt(args[0]);
		        if (argument > 0 && args.length == 1)
					System.out.print("The Cantor Expression of " + argument + " is " + cantor(argument, "") + "\n");
		        else 
		        	System.out.print("Usage: java Hmwk6 <n>, where <n> is the positive Base-10\n\tinteger for which you'd like a Cantor Expansion.\n");
		    } catch (NumberFormatException e) {
		        System.out.print("Usage: java Hmwk6 <n>, where <n> is the positive Base-10\n\tinteger for which you'd like a Cantor Expansion.\n");
		    }
		}
	}
}