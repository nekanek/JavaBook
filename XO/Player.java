public abstract class Players {

    public static int[] returnCoordinates(char[][] board) {}
    

    private class Human extends Players {
        public static int[] returnCoordinates(char[][] board) {
            read input from user;
            convert to [];
            return input;
        }
    }

    private class RandomAI extends Players {
        public static int[] returnCoordinates(char[][] board) {
            sys out print "AI makes decision...";
            return []
        }
        private static int[] makeDecision (char[][] board)
    }

    // private class CleverAI extends Players {
    //     public static int[] returnCoordinates(char[][] board) {}
    //     making decision based on (reading field ) {}
    // }    

}

