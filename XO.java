// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..

public class GameOfXO {

    private final int DEFAULT_SIZE = 3;

    private int size;
    private int currentTurn;
    private char[][] board;
    private int[][] turnsHistory;

    public GameOfXO(int size) {
        // @ make an exception for invalid size
        if (size > 1) {
            this.size = size;
            this.board = new char [size][size];
            this.turnsHistory = new int [size*size][2];
            this.currentTurn = 0;
        }
    }
    
    public GameOfXO() {
        // @ make an exception for invalid size
        this(DEFAULT_SIZE);
    }
    
    public void printBoard (int turn) {
        for (int i = 0; i < size; i++)
            System.out.println(java.util.Arrays.toString(boardOnTurn(turn)[i]);
    }
    
    public char[][] boardOnTurn (int turn) {
        if (turn == currentTurn) {
            return this.board;
        } 
        else {
            char[][] historyBoard = new char[][];
            for (int i = 0; i < turn; i++) {
                putChar(whoseTurn(i),turnsHistory[i]);
            }
            return historyBoard;
        }
    }
    
    public void printBoard () {
        printBoard(this.currentTurn);
    }
    
    private char whoseTurn (int turn) {
        if (turn%2 == 0) return 'X';
        else return 'O';
    }
    
    private void putChar(char inputChar, int[] coords) {
        board[coords[0]][coords[1]] = inputChar;
    }
    
    public boolean check4win(char checkChar) {
        // checks rows and columns
        int countRow = 0;
        int countColumn = 0;
        for (int i = 0; i < size; i++) { 
            if (countRow == size-1 || countColumn == size-1)
                return true;
            count = 0;
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

	PrintHistory
    replay
	revertLastTurn
	read user input
    
    public static void beginGame() {
            initialize field
            create players
        {
        ask for size
        size = input;
        }
            while !win
        do {
                print board
                prompt
                player.readCoordinates user input1
                    or revert and goto prompt
                    or {
                        set PutChar = x/o(whoseTurn)
                        put symbol into field
                    }
                write history coordinates[turn] = input1;
               turn ++;
        }
                    while(	check for win)
                           
    }
}

    class players
        readCoordinates

	human extends players
        read
    AI extends players
        read
        +
        making decision based on (reading field )
        1. random
        2. win algo
