Object - field (immutable, each turn different field)

public class Field {
    
    private final int size;
    private final char[][] ground;
    private final int field;
    
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
		win = true
		for each line 
			for each symbol if ((currentSymb = X)&win); win = true; else break;
		return win 
	read user input

Inputs:
	revert
	
algo
	initialize field
	while !win
		prompt
		read user input
			or revert and goto prompt
			or put symbol into field
				check for win
			goto prompt
