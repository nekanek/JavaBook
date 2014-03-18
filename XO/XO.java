// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..
package JavaBook.XO;
//import JavaBook.stanfStd.*;

public class XO {
    
    private static void makeMove (boolean isAI, char symbol, GameOfXO myGame, Player playerName) {
        int[] currentCoords = playerName.returnCoordinates(myGame.boardOnTurn(myGame.currentTurn));
        myGame.putChar(myGame.whoseTurn(myGame.currentTurn),currentCoords);
        myGame.turnsHistory[myGame.currentTurn][0] = currentCoords[0];
        myGame.turnsHistory[myGame.currentTurn][1] = currentCoords[1];
    }
    
    public static void main(String[] args) {
        // create players
        System.out.println("Welcome to the game of XO. \nPlease, choose game mode:\n1) Human vs Human\n2) Human vs AI\n(type number of the option and hit enter to continue..)");
        // read Scanner input = new Scanner( System.in );
        int input1 = 1;//Integer.parseInteger(input);        
                //Human Player1 = new Human();
                //Human Player2 = new Human();     
        switch (input1) {
            case 1: {
                Human Player1 = new Human();
                Human Player2 = new Human();
                break;
            }    
            case 2: {
                System.out.println("Do you want to play first? (Y/N)");
                // read input
                String input2 = "Y";//Integer.parseInteger(input);
                
                if (input2 == "Y") {
                    Human Player1 = new Human();
                    RandomAI Player2 = new RandomAI();
                }
                else if (input2 == "N") {
                    RandomAI Player1 = new RandomAI();
                    Human Player2 = new Human();
                }
                else {
                    System.out.println("Wrong input."); // redo input recursively
                }
                break;
            }
            default: {
                System.out.println("Wrong input. Starting default Human VS Human game."); // redo input recursively
                break;
            }
        }
        // create game
        System.out.println("Please, enter size of the game you want to play. Enter 3 for 3x3 game field.");
        // read
        int size = 4;//Integer.parseInteger(input);
        GameOfXO myGame = new GameOfXO(size);
/*         }
        else {
            "Your input was wrong, beginning default game 3x3."
            GameOfXO myGame = new GameOfXO();
        } */
        
        // main cycle
        int[] currentCoord = new int[2];

        do {
            myGame.printBoard();
            System.out.println("Please, enter [revert] or [end] (both r case-sensitive) to cancel last move or to exit game.");
            //    - revert and goto prompt
             //   - close game
            // 
            String input = "none";
            if (input == "revert") {
                myGame.revertLastTurn();
                // SOUT("Input number of turns u want to revert (count both your turns and partner's).");
                // int turnsNumber = reqadinput.to int ;
                // myGame.revertLastTurn(turnsNumber);
                System.out.println("Last turn was reverted. Please, redo your move.");
            }
            else if (input == "end") {
                break;
            }
            else {
                if (myGame.currentTurn%2==0) { // even turn, Xs, Player 1
                    makeMove(Player1.isAI, 'X', myGame, Player1);
                }
                else { // odd turn, Os, Player 2
                    makeMove(Player2.isAI, 'O', myGame, Player2);
                }
                myGame.currentTurn++;
            }
        }
        while (!myGame.check4win(myGame.whoseTurn(myGame.currentTurn-1)) && (myGame.currentTurn < myGame.size* myGame.size));
        
        if (myGame.check4win(myGame.whoseTurn(myGame.currentTurn-1)))  {
            myGame.endGame(false, myGame.whoseTurn(myGame.currentTurn-1));  
        }
                
        else if (myGame.currentTurn >= myGame.size* myGame.size) {
            myGame.endGame(true, ' '); 
        }

        else {
            
        }
    }
        

    
}


