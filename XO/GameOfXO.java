// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..
package JavaBook.XO;
//import JavaBook.stanfStd.*;
import java.util.Arrays.*;

public class GameOfXO {

    private static final int DEFAULT_SIZE = 3;
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 10;
    public int size;
    public int currentTurn;
    public char[][] board;
    public int[][] turnsHistory;

    public GameOfXO(int size) {
        // @ make an exception for invalid size
        if (size >= MIN_SIZE && size < MAX_SIZE) 
            this.size = size;
        else {
            System.out.println("Your input was wrong, beginning default game 3x3.");
            size = DEFAULT_SIZE;
        }
        this.board = new char [size][size];
        //for
        //    for
        //        putChar' '
        this.turnsHistory = new int [size*size][2];
        this.currentTurn = 0; 
    }
    
    public GameOfXO() {
        // @ make an exception for invalid size
        this(DEFAULT_SIZE);
    }
    
    public void printBoard (int turn) {
        for (int i = 0; i < size; i++)
            System.out.println(java.util.Arrays.toString(boardOnTurn(turn)[i]));
    }
    
    public void printBoard () {
        printBoard(this.currentTurn);
    }
    
    public char[][] boardOnTurn (int turn) {
        if (turn == currentTurn) {
            return this.board;
        } 
        else {
            char[][] historyBoard = new char[size][size];
            for (int i = 0; i < turn; i++) {
                putChar(whoseTurn(i),turnsHistory[i]);
            }
            return historyBoard;
        }
    }
        
    public char whoseTurn (int turn) {
        if (turn%2 == 0) return 'X';
        else return 'O';
    }
    
    public void putChar(char inputChar, int[] coords) {
        this.board[coords[0]][coords[1]] = inputChar;
    }
    
    public boolean check4win(char checkChar) {
        // checks rows and columns
        int countRow = 0;
        int countColumn = 0;
        for (int i = 0; i < size; i++) { 
            if (countRow == size-1 || countColumn == size-1)
                return true;
            countRow = 0;
            countColumn = 0;
            for(int j = 0; j < size; j++) {
                    if (this.board[i][j]==checkChar)
                        countRow++;
                    if (this.board[j][i]==checkChar) 
                        countColumn++;
            }
        }
        //check diagonals
        int countDiag1 = 0;
        int countDiag2 = 0;
        for (int i = 0; i < size; i++) {
                if (this.board[i][i]==checkChar) 
                    countDiag1++;
                if (this.board[size-1-i][i]==checkChar) 
                    countDiag2++;
        }
        if (countDiag1 == size-1 || countDiag2 == size-1) 
            return true;
        return false;
    }

    public static void endGame(boolean tie, char winnerChar){
        if (tie) System.out.println("Game ended in a tie.");
        else System.out.println("Congratulations to the player who played " + winnerChar + "! You WON!");
            // add which player won ("Congratulations to " + Player1.toString() + "who played " + winnerChar + '!') and determining whether human or ai (instanceOf) 
    }

    // PrintHistory
    // replay
    
    public void revertLastTurn() {
        // int[] lastCoord = int[]
        this.putChar(' ', turnsHistory[currentTurn-1]);
        int[] newArray = new int[2];
        turnsHistory[currentTurn-1] = newArray;
        currentTurn--;
       
    }
    
    //public static String readInput () {
    
}


