import arc.*;
import java.awt.*;
import java.awt.image.*;

public class CPTKyle{
	public static void main(String[] args){
		Console con = new Console("Connect 4", 1280,720);
		
		boolean blnMainMenu = true;
		
		//Background Image
		BufferedImage imgconnectfour = con.loadImage("connectfour.jpg");
		con.drawImage(imgconnectfour,0,0);
		
		char chrChoice;
		
		//Bubble Sorting variables
		int intCount;
		String strTempName;
		String strTempScore;
		int intIndex = 0;
		
		//Makes an Array to show highscores 
		int intWins = 0;
		int intRow = 0;
		int intRow2 = 0;
		
		int intTheme = 0;
		// ask user for the theme and change the intTheme to that
		// Change the colours when you set the colours
		
		
		
		//Set boolean variable for a win to false
		boolean blnWon = false;
		int intCurrentPlayer = 1;
		
		while(blnMainMenu == true){
			//Main Menu
			con.println("Welcome to Connect 4");
			con.println("Play game (p)");
			con.println("View High Scores (v)");
			con.println("Themes (t)");
			con.println("Help (h)");
			con.println("Quit (q)");
			con.println("What would you like to do?: ");
			chrChoice = con.readChar();
		
		//If statment 
		if(chrChoice == 'p'){
			
			
			blnMainMenu = false;
			
			//Name Variables
			String strNameP1;
			String strNameP2;
			
			con.clear();
			
			//Ask for P1 and P2 name
			con.print("What is P1's name: ");
			strNameP1 = con.readLine();
			con.print("What is P2's name: ");
			strNameP2 = con.readLine();
			
			con.setTextColor(Color.RED);
			
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
				for(intRow = 0; intRow < intRows; intRow++){
					for(int intColumn = 0; intColumn < intColumns; intColumn++){
						intBoard[intRow][intColumn] = 0;
					}	
				}
			
				//Player Turn
				int intPlayerTurn = 1;
				
				while(blnWon == false){
					con.clear();
					//Make and print board
					con.println("Game Start!");
					con.println("   1  2  3  4  5  6  7");
					for(intRow = 0; intRow < intRows; intRow++){
						con.print((intRow+1) + " ");
						for(int intColumn = 0; intColumn < intColumns; intColumn++){
							if(intBoard[intRow][intColumn] == 0){
								con.print("[ ]");	
							}else if(intBoard[intRow][intColumn] == 1){
								con.print("[x]");
							}else if(intBoard[intRow][intColumn] == 2){
								con.print("[o]");
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
							for(intRow = intRows - 1; intRow >= 0 && blnDroppedPiece == false; intRow--){
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
				for(intRow = 0; intRow < intRows; intRow++){
					con.print((intRow + 1) + " ");
					for(int intColumn = 0; intColumn < intColumns; intColumn++){
						if(intBoard[intRow][intColumn] == 0){
							con.print("[ ]");
						} else if(intBoard[intRow][intColumn] == 1){
							con.print("[x]");
						}else if(intBoard[intRow][intColumn] == 2){
							con.print("[o]");
						}
					}
					con.println();
				}
			
               //Check for a win, four in a row
               boolean blnWin = false;
               
               for(intRow = 0; intRow < intRows; intRow++){
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
							blnPlayAgain = true;
							System.out.println("Suisei");
						}else if(strPlayAgain.equalsIgnoreCase("n")){
							blnPlayAgain = false;
							
							//Write Score to another file
							TextOutputFile HighScores = new TextOutputFile("highscores.txt", true);
							HighScores.println(strNameP1);
							HighScores.println(intP1Wins);
							HighScores.println(strNameP2);
							HighScores.println(intP2Wins);
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
								con.sleep(1000);
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
							//Switching player after turn is finished and computer checks for win
							if(intCurrentPlayer == 1){
								intCurrentPlayer = 2;
							}else{
								intCurrentPlayer = 1;
							}
						}
						if(intCurrentPlayer == 1){
							con.setTextColor(Color.RED);
						}else{
							con.setTextColor(Color.YELLOW);
						}
					}
				}
				
				
						
				}//dont delete
		
		}else if(chrChoice == 'v'){
			blnMainMenu = false;
			TextInputFile HighScoresOutput = new TextInputFile("highscores.txt");
			con.clear();
			
			String strUser;
			String strUserScore;
			intIndex = 0;
			String[][] strScoresTotal = new String[999][2];
				
				
			while(HighScoresOutput.eof() == false){
				strUser = HighScoresOutput.readLine();
				strUserScore = HighScoresOutput.readLine();
					
				if(strUser != null && strUserScore != null){
					System.out.println("TEST " + strUser);
					System.out.println("TEST " + strUserScore);
					strScoresTotal[intIndex][0] = strUser;
					strScoresTotal[intIndex][1] = strUserScore;
					intIndex++;
				}
			}
				
			for(intRow2 = 0; intRow2 < intIndex - 1; intRow2++){
				for(intRow = 0; intRow < intIndex - 1 - intRow2; intRow++){
					if(strScoresTotal[intRow] != null && strScoresTotal[intRow+1] != null && strScoresTotal[intRow][1] != null && strScoresTotal[intRow+1][1] != null){
						int intScore1 = Integer.parseInt(strScoresTotal[intRow][1]);
						int intScore2 = Integer.parseInt(strScoresTotal[intRow+1][1]);
						
						System.out.println("Bubble Sort");
						if(intScore1 < intScore2){
							strTempName = strScoresTotal[intRow][0];
							strTempScore = strScoresTotal[intRow][1];
							
							System.out.println("TEST " + strTempName);
							System.out.println("TEST " + strTempScore);
							
							strScoresTotal[intRow][0] = strScoresTotal[intRow+1][0];
							strScoresTotal[intRow][1] = strScoresTotal[intRow+1][1];
							strScoresTotal[intRow+1][0] = strTempName;
							strScoresTotal[intRow+1][1] = strTempScore;
						}
					}
				}
			}
				
			for(intRow = 0; intRow < intIndex - 1; intRow++){
				if(strScoresTotal[intRow][0] != null && strScoresTotal[intRow][1] != null){
					con.println(strScoresTotal[intRow][0] + " | " + strScoresTotal[intRow][1]);
				}
			}
				
			HighScoresOutput.close();
				
				
				
			con.println("Press the y key when you want to go back to the main menu");
				
			while(con.getChar() == 'y'){
				blnMainMenu = true;
				con.clear();
				break;
			}
				
		}else if(chrChoice == 't'){
			blnMainMenu = false;
			con.clear();
				
			int intThemeChoice;
				
			con.println("Here are the avaliable Themes:");
			con.println("Default (1)");
			con.println("Christmas (2)");
			con.println("Which theme would you like to use? (1/2)");
			intThemeChoice = con.readInt();
			
		}else if(chrChoice == 's'){
			blnMainMenu = false;
			con.clear();
			
			con.println("Welcome to the secret menu");
			con.sleep(1500);
			con.println("As a reward for finding this menu, I will tell you a joke");
			con.sleep(1500);
			con.println("What's a computer programmer's house made of?");
			con.sleep(2000);
			con.println("Firewalls!!!");
			con.sleep(500);
			con.println("HAHAHAHAHAHAHAHA....I'm so funny");
			con.println("");
			con.println("Press the y key when you want to go back to the main menu");
			
			while(con.getChar() == 'y'){
				blnMainMenu = true;
				con.clear();
				break;
			}	
					
		}else if(chrChoice == 'h'){
			blnMainMenu = false;
			con.clear();
				
			con.println("HOW TO PLAY CONNECT FOUR");
			con.println("");
			con.println("On your turn, drop one of your checkers down ANY of the columns at the top of the grid");
			con.println("");
			con.println("Play alternates until one player gets FOUR pieces in a row.");
			con.println("");
			con.println("The four in a row can either be horizontal, vertical, or diagonal");
			con.println("");
			con.println("Would you like to go back to the main menu? (y)");
			
			while(con.getChar() == 'y'){
				blnMainMenu = true;
				con.clear();
				break;
			}	
		}
		if(chrChoice != 'p' && chrChoice != 'v' && chrChoice != 't' && chrChoice != 's' && chrChoice != 'h' && chrChoice != 'q'){
			con.println("That letter is not an option");
			con.println("Please pick a letter represented by the menu");
			con.sleep(1000);
			con.clear();
		}
			
		if(chrChoice == 'q'){
			con.closeConsole();
		}
	}    
}			
}
