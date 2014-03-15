// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..

public class XO {
    
    public static void main(String[] args) {
        sys "Welcome to game of XO. \nPlease, choose game mode:\n1) Human vs Human\n2)...\n "
        read input
        // create players
        switch
        
        // read field size
        prompt and read
        int size = 
        if size is ok
            GameOfXO myGame = new GameOfXO(size);
        else {
            "Your input was wrong, beginning default game 3x3."
            GameOfXO myGame = new GameOfXO();
        }
        myGame.beginGame();
        sys "tu"

    }
}


