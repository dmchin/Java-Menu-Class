// David Chin
// Menu.java
// dchin5@my.smccd.edu
// 10-10-2013

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu
{
	// This version will default to the console with a prompt of "choice: "
	public static int display( String[] options )
	{
		// Call the full display method with default parameters
		return display( options, "Choice: ", true );
	}	
	public static int display( String[] options, String prompt, boolean console )
	{
		// Set up variables
		int choice = -1;
		String display = "";
		String input = "";
		do
		{
			// Create the display for menu options
			for( int i = 0; i < options.length; ++i )
			{
				if( console )
				{
					System.out.println( "[" + i + "] " + options[ i ] );
				}
				else
				{
					display += "[" + i + "] " + options[ i ] + "\n";
				}
			}
			display += prompt;
			/* Input menu option
			   At the moment, it has two versions: Console or JOptionPane
			   These were the two main input/output methods during the
			   programming courses at CSM
			*/
			if( console )
			{
				System.out.print( display );
				input = new Scanner( System.in ).nextLine();
			}
			else
			{
				input = JOptionPane.showInputDialog(
					null, display, "Menu", JOptionPane.QUESTION_MESSAGE );
			}
			// Validate option: Default to -1 if invalid
			choice = ( input.matches( "\\d+" ) ? Integer.parseInt( input ) : -1 );
		}
		// Repeat if the choice isn't valid
		while( choice < 0 || choice >= options.length );
		return choice;
	}
}
