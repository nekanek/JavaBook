
Object - field (immutable, each turn different field)
- pairs of coord + turn
public class GameOfXO
public class Turn {
    
    private final int size;
    private final int[][] coordinates;
    private final int turn;
    
    
    private final int DEFAULT_SIZE = 3;
    
    
    public Field () {
    
    
    
    }

}
	size = N
	char[][] N x N
	turn = 1
	whoseTurn (set PutChar = x/o)

methods
	PrintHistory


	revertLastTurn
	check forwin(X/O)
		win = false
		for each line 
			for each symbol if ((currentSymb = X)&win); win = true; else break;
		return win 

	read user input
coordinates[turn][0] = input1
,.

   put char into field(char, coords,)
   print field (turn x) ()- current
   

Inputs:
	revert
	
algo
	initialize field
{
ask for size
size = input;
}
	while !win
do {
		prompt
		read user input
			or revert and goto prompt
			or put symbol into field
       turn ++;
}
			while(	check for win)
			

AI
    reading field making coordinates
    field-his char
    all possible variants or?
