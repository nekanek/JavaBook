// Object - field (immutable, each turn different field)
// - pairs of coord + turn
// singleton, enum
// public class Turn
// turns are referred as 0, 1... can redo so they would start at 1..
package JavaBook.XO;
//import JavaBook.stanfStd.*;
import java.util.Scanner;

public class XO {
    
    private static void makeMove (boolean isAI, char symbol, GameOfXO myGame, Player playerName) {
        int[] currentCoords = playerName.returnCoordinates(myGame.boardOnTurn(myGame.currentTurn));
        myGame.putChar(myGame.whoseTurn(myGame.currentTurn),currentCoords);
        myGame.turnsHistory[myGame.currentTurn][0] = currentCoords[0];
        myGame.turnsHistory[myGame.currentTurn][1] = currentCoords[1];
    }
    
    public static int scanInt() {
        Scanner sc = new Scanner(System.in); 
        // int[] i = new i[2];
        int input;
        if(sc.hasNextInt()) {
          input = sc.nextInt(); 
        } 
        else {
          System.out.println("Input was wrong. Please input one integer and hit enter.");
          // input = 0;
          return scanInt();
        }
        return input;
    }

    public static int[] scanIntArray() {
        Scanner sc = new Scanner(System.in); 
        int[] input = new int[2];
        
        if(sc.hasNextInt()) {
          input[0] = sc.nextInt(); 
        } 
        else {
          System.out.println("Input was wrong. Please repeat input.");
          return scanIntArray();
          // return input;
        }
        
        if(sc.hasNextInt()) {
          input[1] = sc.nextInt(); 
        } 
        else {
          System.out.println("Input was wrong. Please repeat input.");
          return scanIntArray();
        }
        
        return input;
    }

    public static String scanString() {
        Scanner sc = new Scanner(System.in); 
        // int[] i = new i[2];
        String input = "";
        if(sc.hasNext()) {
          input = sc.nextLine();; 
        } 
        else {
          System.out.println("Input was wrong. Please input again."); 
          return scanString();
        }
        return input;
    }    
    
    private static Player[] createPlayers (int input1)    {
        Player[] myPlayers = new Player[2];
        switch (input1) {
        
            case 1: {
                //Human Player1 = new Human();
                myPlayers[0] = new Human();
                myPlayers[1] = new RandomAI();
                //Human Player2 = new Human();
                break;
            }    
            case 2: {
                System.out.println("Do you want to play first? (Y/N)");
                // read input
                String input2 = scanString(); // "Y";//Integer.parseInteger(input);
                
                if (input2.equals("Y")) {
                    //Human Player1 = new Human();
                    //RandomAI Player2 = new RandomAI();
                    myPlayers[0] = new Human ();
                    myPlayers[1] = new RandomAI();
                }
                else if (input2.equals("N")) {
                    //RandomAI Player1 = new RandomAI();
                    //Human Player2 = new Human();
                    myPlayers[1] = new Human ();
                    myPlayers[0] = new RandomAI();                    
                }
                else {
                    System.out.println("Wrong input."); // redo input recursively
                    return createPlayers (input1);
                }
                break;
            }
            default: {
                System.out.println("Wrong input. Starting default Human VS Human game."); // redo input recursively
                break;
            }            
        }
        return myPlayers;
    }
    
    public static void main(String[] args) {
        // create players
        System.out.println("Welcome to the game of XO. \nPlease, choose game mode:\n1) Human vs Human\n2) Human vs AI\n(type number of the option and hit enter to continue..)");
        // read Scanner input = new Scanner( System.in );
        int input1 = scanInt();//Integer.parseInteger(input);        
                // Human Player1 = new Human();
                // Human Player2 = new Human(); 
                Player[] myPlayers = createPlayers(input1); 
                //System.out.println("Player 2 is AI: " + myPlayers[1].getIsAI());
                Player Player1 =  myPlayers[0];
                Player Player2 =  myPlayers[1];
                //System.out.println("Player 2 is AI: " + myPlayers[1].isAI);
                //boolean x = Player1 instanceof Human;
                //System.out.println("Player 1 is human: " + x);
                //boolean y = Player2 instanceof RandomAI;
                //System.out.println("Player 2 is AI: " + y);
                //boolean z = Player2 instanceof Human;
                //System.out.println("Player 2 is Human: " + z);                
                //Player Player2 =  createPlayers(input1)[1];
                //System.out.println("Player 1 is AI: " + Player1.isAI);
                //System.out.println("Player 2 is AI: " + Player2.isAI);
                // Human Player2 = new Human(); 
        // create game
        System.out.println("Please, enter size of the game you want to play. Enter 3 for 3x3 game field.");
        // read
        int size = scanInt();//Integer.parseInteger(input);
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
            String input = scanString();
            if (input.equals("revert")) {
                myGame.revertLastTurn();
                // SOUT("Input number of turns u want to revert (count both your turns and partner's).");
                // int turnsNumber = reqadinput.to int ;
                // myGame.revertLastTurn(turnsNumber);
                
            }
            else if (input.equals("end")) {
                break;
            }
            else {
                if (myGame.currentTurn%2==0) { // even turn, Xs, Player 1
                    makeMove(Player1.getIsAI(), 'X', myGame, Player1);
                }
                else { // odd turn, Os, Player 2
                    makeMove(Player2.getIsAI(), 'O', myGame, Player2);
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
            myGame.printBoard();
        }

        else {
            
        }
    }
        

    
}


