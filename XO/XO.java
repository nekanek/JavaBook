// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..

public class XO {
    private void makeMove (boolean isAI, char symbol, GameOfXO myGame, Player playerName) {
        if (isAI) {
            currentCoord = Player1.returnCoordinates();
        }
        else {
            "make yr move""
            String input = readInput ();    
            
        }
        write history myGame.coordinates[turn] = input1;
    }
    public static void main(String[] args) {
        // create players
        sys "Welcome to game of XO. \nPlease, choose game mode:\n1) Human vs Human\n2)...\n "
        "wanna play first?"
        read input
        switch
            
                Player1
                Player2
            boolean Player1isAI = ;
            boolean Player2isAI = 
        Player1isAI

        // create game
        prompt and read
        int size = 
        if (size is ok) {
            GameOfXO myGame = new GameOfXO(size);
        }
        else {
            "Your input was wrong, beginning default game 3x3."
            GameOfXO myGame = new GameOfXO();
        }
        
        // main cycle
        int[] currentCoord = new int[2];
        char winnerChar;
        
        do {
            print board
            print whether player
                - revert and goto prompt
                - close game
            input
            if (input == "revert") {
                
            }
            else if (input == "end") {
                
            }
            else {
                if myGame.CurrentTurn%2==0 { // even turn, Xs, Player 1
                    makeMove(Player1isAI, 'X', myGame, Player1);
                    winnerChar = 'X';
                }
                else { // odd turn, Os, Player 2
                    makeMove(Player2isAI, 'O', myGame, Player2);
                    winnerChar = 'O';
                }
                myGame.CurrentTurn++;
            }
        }
        while (!check4Win(winnerChar) && (currentTurn < size*size))
        
        if check4Win {
            endGame(false, winnerChar);  
        }
                
        else if (currentTurn >= size*size) {
            endGame(true, winnerChar); 
        }                      
    }
        

    
}


