import arc.*;
import java.awt.*;
import java.awt.image.*;

public class CPTKyle{
	public static void main(String[] args){
		Console con = new Console("Connect 4", 1280,720);
		
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
		
		if(strChoice.equalsIgnoreCase("p")){
			
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
			int intRows = 6;
			int intColumns = 7;
			int intBoard[][];
			intBoard = new int[intRows][intColumns];
			
			//Reset game board
			boolean blnPlayAgain = true;
			
			while(blnPlayAgain){
				for(int intRow = 0; intRow < intRows; intRow++){
					for(int intColumn = 0; intColumn < intColumns; intColumn++){
						intBoard[intRow][intColumn] = 0;
					}	
				}
			
			//Set boolean variable for a win to false
			boolean blnWon = false;
			int intCurrentPlayer = 1;
			
			//Player Turn
			int intPlayerTurn = 1;
			
			while(blnWon == false){
				con.clear();
				//Make and print board
				con.println("Game Start!");
				con.println("   1  2  3  4  5  6  7");
				for(int intRow = 0; intRow < intRows; intRow++){
					con.print((intRow+1) + " ");
					for(int intColumn = 0; intColumn < intColumns; intColumn++){
						if(intBoard[intRow][intColumn] == 0){
							con.print("[ ]");	
						}else{
							con.print("[" + intBoard[intRow][intColumn] + "]");
						}
					}
					con.println();
				}
				//blnWon = true; 
				//Asks Player which column their piece goes into
				String strPlayerName;
				
				if(intCurrentPlayer == 1){
					strPlayerName = strNameP1;
				}else{
					strPlayerName = strNameP2;
					
				}
				con.print(strPlayerName + " choose a column ");
				
				int intChosenColumn;
				boolean blnValidColumn = false;
			
				while(blnValidColumn == false){
					intChosenColumn = con.readInt();
					if(intChosenColumn >= 0 && intChosenColumn < intColumns){
						if(intBoard[0][intChosenColumn] == 0){
							blnValidColumn = true;
							
							boolean blnDroppedPiece = false;
							int intRow = intRows - 1; 
							while(blnDroppedPiece == false && intRow >= 0){
								if(intBoard[intRow][intChosenColumn] == 0){
									intBoard[intRow][intChosenColumn] = intCurrentPlayer;
									blnDroppedPiece = true;
								}else{
									intRow--;
								}
							}
							}else{
								con.println("Column is full, choose another one");
						}
					}else{
						con.println("Invalid, please choose a number from 1 to 6");
					}
				}
			
               //Check for a win, four in a row
               boolean blnWin = false;
               for(int intRow = 0; intRow < intRows; intRow++){
				   for(int intColumn = 0; intColumn < intColumns; intColumn++){
					  
					   //Horizontal Check
					   if(intColumn + 3 < intColumns && intBoard[intRow][intColumn] == intCurrentPlayer && intBoard[intRow][intColumn + 1] == intCurrentPlayer &&
						  intBoard[intRow][intColumn + 2] == intCurrentPlayer && intBoard[intRow][intColumn + 3] == intCurrentPlayer){
							  blnWin = true;
						}
						
						//Vertical Check
						if(intRow + 3 < intRows && intBoard[intRow][intColumn] == intCurrentPlayer && intBoard[intRow + 1][intColumn] == intCurrentPlayer &&
						   intBoard[intRow + 2][intColumn] == intCurrentPlayer &&  intBoard[intRow + 3][intColumn] == intCurrentPlayer){
							   blnWin = true;
						}
						
						//Diagonal Check - Bottom Left to Top Right
						if(intRow + 3 < intRow && intColumn + 3 < intColumns && intBoard[intRow][intColumn] == intCurrentPlayer && intBoard[intRow + 1][intColumn + 1] == intCurrentPlayer &&
						   intBoard[intRow + 2][intColumn + 2] == intCurrentPlayer &&  intBoard[intRow + 3][intColumn + 3] == intCurrentPlayer){
							   blnWin = true;
						   }
						//Diagonal Check - Top Left to Bottom Right
						if(intRow - 3 >= 0 && intColumn + 3 < intColumns && intBoard[intRow][intColumn] == intCurrentPlayer && intBoard[intRow - 1][intColumn - 1] == intCurrentPlayer &&
						   intBoard[intRow - 2][intColumn - 2] == intCurrentPlayer &&  intBoard[intRow - 3][intColumn - 3] == intCurrentPlayer){
							   blnWin = true;
							}
						}
					}
						
				}
			}
               
               
               
                
		}
	}
			
}
	

