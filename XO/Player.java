package JavaBook.XO;
//import JavaBook.stanfStd.*;

public abstract class Player {

    private final boolean isAI = false; // = false;
    
    public boolean getIsAI() {
        return isAI;
    }    
    public abstract int[] returnCoordinates(char[][] board);
    
    
    // private static final boolean isAI = false;


    // private class CleverAI extends Player {
    //     public static int[] returnCoordinates(char[][] board) {}
    //     making decision based on (reading field ) {}
    // }    

}

