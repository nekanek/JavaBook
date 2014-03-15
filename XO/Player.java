public abstract class Player {

    public static int[] returnCoordinates() {}
    

    private class Human extends Player {
        public static int[] returnCoordinates() {
            System.out.println("please, input coordinates in the following format: [x y], where x and y are coordinates you want to put your character at. U can enter \"revert\" (case-sensitive) to cancel your last move.");
            String input1 = GameOfXO.readInput;
            if input.equals("revert")  {
                SOUT("Input number of turns u want to revert (count both your turns and partner's).");
                int turnsNumber = reqadinput.to int ;
                myGame.revertLastTurn(turnsNumber);
                System.out.println("Last turn was reverted. Please, redo your move.");
            }
            else {
                int[] input = new int[2];
                input[0] = Integer.parseinteger(inputString.substring(0)); // make it after space to take into account size > 9
                input[1] = Integer.parseinteger(inputString.substring(2)); // make it after space to take into account size > 9
                return input;
            }
        }
    }

    private class RandomAI extends Player {
        public static int[] returnCoordinates(char[][] board) {
            sys out print "AI makes decision...";
            return []
        }
        private static int[] makeDecision (char[][] board)
            int[] result = new int[2];
            result[0] = Math.Random()*board.length();
            result[1] = Math.Random()*board.length();
            return result;
    }

    // private class CleverAI extends Player {
    //     public static int[] returnCoordinates(char[][] board) {}
    //     making decision based on (reading field ) {}
    // }    

}

