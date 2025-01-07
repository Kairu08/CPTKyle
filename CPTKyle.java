import arc.*;
import java.awt.*;
import java.awt.image.*;

public class CPTKyle{
	public static void main(String[] args){
		Console con = new Console();
		
		String strChoice;
		
		//Main Menu
		con.println("Welcome to Connect 4");
		con.println("Play game (p)");
		con.println("View High Scores (s)");
		con.println("Themes (t)");
		con.println("Help (h)");
		con.println("Quit (q)");

		
		con.println("What would you like to do?: ");
		strChoice = con.readLine();
		
		//If statment 
		
		if(strChoice.equals("p"));{
			
			//Name Variables
			String strNameP1;
			String strNameP2;
			
			con.clear();
			
			//Ask for P1 and P2 name
			con.print("What is P1's name: ");
			strNameP1 = con.readLine();
			con.print("What is P2's name: ");
			strNameP2 = con.readLine();
			
			//Creating the Array
			int introws = 7;
			int intcolumns = 8;
			int intBoard[][];
			intBoard = new int[introws][intcolumns];
			
			//Make and print board
			con.println("Game Start!");
			con.println("   0  1  2  3  4  5  6  7");
			
			for(int introw = 0; introw < introws; introw++){
				con.print(introw + " ");
				for(int intcolumn = 0; intcolumn < intcolumns; intcolumn++){
					con.print("[ ]");	
				}
				con.println();
			}
			

			
		}
	}
}
