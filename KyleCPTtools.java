import arc.*;

public class KyleCPTtools{
	public static boolean wincheck(int intCurrentPlayer){
		
		int intRow;
		int intBoard[][];
		int intRows = 6;
		int intColumns = 7;
		intBoard = new int[6][7];
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
	
		return blnWin;
	}
}
