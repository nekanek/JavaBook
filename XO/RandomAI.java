package JavaBook.XO;
//import JavaBook.stanfStd.*;


public class RandomAI extends Player {
    private final boolean isAI; 
    
    public boolean getIsAI() {
        return isAI;
    }
    
    public RandomAI() {
        this.isAI = true;
    }    
    
    public int[] returnCoordinates(char[][] board) {
        System.out.println("AI makes decision...");
        int[] result = new int[2];
        result[0] = (int) (Math.random()* board.length);
        result[1] = (int) (Math.random()* board.length);
            if ( (board[result[0]][result[1]] != 'X') && (board[result[0]][result[1]] != 'O') ) {
                return result;
            }
            else {
                return returnCoordinates(board);
            }
    }
    
    //private int[] makeDecision (char[][] board){
        // check isNull
    //}

    //private int[] checkNull (char[][] board){
        // check isNull
    //}

    
}   
