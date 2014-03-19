package JavaBook.XO;
//import JavaBook.stanfStd.*;


public class Human extends Player {
    public boolean isAI;
    
    public Human() {
        this.isAI = false;
    }
    
    @Override
    public int[] returnCoordinates(char[][] board) {
        System.out.println("Please, make yr move; enter coordinates [x y].");
        String input1 = "1 1"; // GameOfXO.readInput;

        int[] input = new int[2];
        input[0] = 1;// Integer.parseinteger(inputString.substring(0)); // make it after space to take into account size > 9
        input[1] = 1;//Integer.parseinteger(inputString.substring(2)); // make it after space to take into account size > 9
        
        // check for null - make it diff method
        
        return input;
        
    }
}

