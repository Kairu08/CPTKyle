import arc.*;
import java.awt.*;
import java.awt.image.*;

public class CPTKyle{
	public static void main(String[] args){
		Console con = new Console(1280,720);
		
		//Background Image
		BufferedImage imgconnectfour = con.loadImage("connectfour.jpg");
		con.drawImage(imgconnectfour,0,0);
		
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
			
			con.clear();
			
			//Creating the Array and Variables
			int intP1Wins = 0;
			int intP2Wins = 0;
			int introws = 6;
			int intcolumns = 7;
			int intBoard[][];
			intBoard = new int[introws][intcolumns];
			
			//Reset game board
			boolean blnPlayAgain = true;
			
			while(blnPlayAgain){
				for(int introw = 0; introw < introws; introw++){
					for(int intcolumn = 0; intcolumn < intcolumns; intcolumn++){
						intBoard[introw][intcolumn] = 0;
					}	
				}
			
			//Set boolean variable for a win to false
			boolean blnWon = false;
			int intcurrentplayer = 1;
			
			//Player Turn
			int intPlayerTurn = 1;
			
			while(blnWon == false){
				con.clear();
				//Make and print board
				con.println("Game Start!");
				con.println("   1  2  3  4  5  6  7");
				for(int introw = 0; introw < introws; introw++){
					con.print((introw+1) + " ");
					for(int intcolumn = 0; intcolumn < intcolumns; intcolumn++){
						if(intBoard[introw][intcolumn] == 0){
							con.print("[ ]");	
						}else{
							con.print("[" + intBoard[introw][intcolumn] + "]");
						}
					}
					con.println();
				}
				//blnWon = true; 
				//Asks Player which column their piece goes into
				String strPlayerName;
				
				if(intcurrentplayer == 1){
					strPlayerName = strNameP1;
				}else{
					strPlayerName = strNameP2;
					
				}
				con.print(strPlayerName + " choose a column ");
				
				int intChosenColumn;
				boolean blnvalidColumn = false;
			
				while(blnvalidColumn == false){
					intChosenColumn = con.readInt();
					if(intChosenColumn >= 0 && intChosenColumn < intcolumns){
						if(intBoard[0][intChosenColumn] == 0){
							blnvalidColumn = true;
							
							boolean blnDroppedPiece = false;
							for(int introw = introws - 1; blnDroppedPiece == false && introw >= 0; introw--){
								if(intBoard[introw][intChosenColumn] == 0){
									intBoard[introw][intChosenColumn] = intcurrentplayer;
									blnDroppedPiece = true;
									}
								}
							}else{
								con.println("Column is full, choose another one");
						}
					}else{
						con.println("Invalid, please choose a number from 1 to 6");
					}
				}
			
                
			}
		}
			
		}
	}
}
