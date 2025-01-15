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
		
		//Makes an Array to show highscores 
		String[][] strScores = new String[2][999]; 
		int intWins = 0;
		
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
					con.setTextColor(Color.BLACK);
					con.print((intRow+1) + " ");
					for(int intColumn = 0; intColumn < intColumns; intColumn++){
						if(intBoard[intRow][intColumn] == 0){
							con.setTextColor(Color.BLACK);
							con.print("[ ]");	
						}else{
							con.setTextColor(Color.BLACK);
							con.print("[" + intBoard[intRow][intColumn] + "]");
						}
					}
					con.println();
				}
				
				//Asks Player which column their piece goes into
				String strPlayerName;
				
				if(intCurrentPlayer == 1){
					strPlayerName = strNameP1;
				}else{
					strPlayerName = strNameP2;
					
				}
			
				
				int intChosenColumn = -1;
				boolean blnValidColumn = false;
				
				//Inserting Piece into Column
				while(blnValidColumn == false){
					con.print(strPlayerName + " choose a column ");
					intChosenColumn = con.readInt();
					
					if(intChosenColumn >= 1 && intChosenColumn <= intColumns){
							intChosenColumn--;
							
							if(intBoard[0][intChosenColumn] == 0){
									blnValidColumn = true;
							
							boolean blnDroppedPiece = false;
							for(int intRow = intRows - 1; intRow >= 0 && blnDroppedPiece == false; intRow--){
								if(intBoard[intRow][intChosenColumn] == 0){
									intBoard[intRow][intChosenColumn] = intCurrentPlayer;
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
				
					con.clear();
					con.println("   1  2  3  4  5  6  7");
					for(int intRow = 0; intRow < intRows; intRow++){
						con.print((intRow + 1) + " ");
						for(int intColumn = 0; intColumn < intColumns; intColumn++){
							if(intBoard[intRow][intColumn] == 0){
								con.print("[ ]");
							} else {
								con.print("[" + intBoard[intRow][intColumn] + "]");
							}
						}
							con.println();
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
						if(intRow + 3 < intRows && intColumn + 3 < intColumns && 
						   intBoard[intRow][intColumn] == intCurrentPlayer && 
						   intBoard[intRow + 1][intColumn + 1] == intCurrentPlayer &&
						   intBoard[intRow + 2][intColumn + 2] == intCurrentPlayer &&  
						   intBoard[intRow + 3][intColumn + 3] == intCurrentPlayer){
							   blnWin = true;
						   }
						//Diagonal Check - Top Left to Bottom Right
						if(intRow - 3 >= 0 && intColumn + 3 < intColumns && 
						   intBoard[intRow][intColumn] == intCurrentPlayer && 
						   intBoard[intRow - 1][intColumn + 1] == intCurrentPlayer &&
						   intBoard[intRow - 2][intColumn + 2] == intCurrentPlayer &&  
						   intBoard[intRow - 3][intColumn + 3] == intCurrentPlayer){
							   blnWin = true;
							}
						}
					}
					
					//You win statement
					if(blnWin){
						con.println(strPlayerName + " wins!!");
						//Counting Player Wins
						if(intCurrentPlayer == 1){
								intP1Wins++;
						}else{
								intP2Wins++;
							
						}
					
						blnWon = true;
						
						String strPlayAgain;
						con.println("Do you want to play again (y/n)?");
						strPlayAgain = con.readLine();
						if(strPlayAgain.equalsIgnoreCase("y")){
							System.out.println("suisei");
							blnPlayAgain = true;
						}else{
							blnPlayAgain = false;
							
							//Write Score to another file
							TextOutputFile HighScores = new TextOutputFile("highscores.txt", true);
							HighScores.println(strNameP1 + "|" + intP1Wins);
							HighScores.println(strNameP2 + "|" + intP2Wins);
							HighScores.close();
							
							con.closeConsole();	
					}
					
					}else{
						//Checking for a tie - game board is full
						boolean blnFull = true;
						for(int intColumn = 0; intColumn < intColumns; intColumn++){
							if(intBoard[0][intColumn] == 0)
								blnFull = false;
						}
						
						if(blnFull){
							con.println("It's a tie!");
							blnWon = true;
							//Game is not actually won, just making the program reset
							
						String strPlayAgain;
						con.println("Do you want to play again (y/n)?");
						strPlayAgain = con.readLine();
						if(strPlayAgain.equalsIgnoreCase("y")){
							System.out.println("suisei");
							blnPlayAgain = true;
						}else{
							blnPlayAgain = false;
							
							//Write Score to another file
							TextOutputFile HighScores = new TextOutputFile("highscores.txt", true);
							HighScores.println(strNameP1 + "|" + intP1Wins);
							HighScores.println(strNameP2 + "|" + intP2Wins);
							
							strScores[intWins][0] = strNameP1;
							strScores[intWins][1] = intP1Wins + "";
							
							intWins += 1;
							strScores[intWins][0] = strNameP2;
							strScores[intWins][1] = intP2Wins + "";
							
							HighScores.close();
							
							con.closeConsole();
						}
							
						}else{
							//Switching player after turn is finished and computer checks for win
							if(intCurrentPlayer == 1){
								intCurrentPlayer = 2;
							}else{
								intCurrentPlayer = 1;
							}
						}
					}
				}
				
				TextInputFile HighScoresInput = new TextInputFile("highscores.txt");
				int intIndex = 0;
	
					//Put the name and score into the 2D array
					while(HighScoresInput.eof() == false){
						String strLine = HighScoresInput.readLine();
						strScores[intIndex][0] = strLine;
						intIndex++;
					}
					HighScoresInput.close();
					
					//Bubble sorting
					int intCount;
					String strTempName;
					int intTempScore;
					int intRow;
					int intRow2;
					for(intRow2 = 0; intRow2 < intIndex - 1; intRow2++){
						for(intRow = 0; intRow < intIndex - 1 - intRow2; intRow++){
							
							//Making sure that both scores are not null before I compare the values
							if(strScores[intRow][1] !=null && strScores[intRow+1][1] !=null){
								int intScore1 = Integer.parseInt(strScores[intRow][1]);
								int intScore2 = Integer.parseInt(strScores[intRow+1][1]);
								if(intScore1 > intScore2){
									
									//Swapping Names
									strTempName = strScores[intRow][0];
									strScores[intRow][0] = strScores[intRow+1][0];
									strScores[intRow][1] = strScores[intRow+1][1];
								
									//Swap Scores
									intTempScore = Integer.parseInt(strScores[intRow][1]);
									strScores[intRow+1][0] = strTempName;
									strScores[intRow+1][1] = intTempScore + "";
								}
							}
						}
					}
					
					
				
				
		
				
               
               
           }      
		}
		
		
		
		
		
		
	}			
}
	

