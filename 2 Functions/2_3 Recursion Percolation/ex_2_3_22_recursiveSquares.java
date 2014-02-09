
/*
2.3.22. Recursive squares. Write a program to produce each of the following recursive patterns. The ratio of the sizes of the squares is 2.2:1. To draw a shaded square, draw a filled gray square, then an unfilled black square. 

N: with parametrs n(depth of recursion) and p (pattern). P equals 1, 2, 3 or 4, corresponding to site's subtasks a, b, c, d.

*/

public class ex_2_3_22_recursiveSquares {

    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]); // depth n
        int p = Integer.parseInt(args[1]); // pattern p={1;2;3;4}
	
	
	switch(p) {
	    case 1:
		draw1(n, 0.5, 0.5, 0.5);
		break;
	    case 2:
		draw2(n, 0.5, 0.5, 0.5);
		break;
	    case 3:
		draw3(n, 0.5, 0.5, 0.5);
		break;
	    case 4:
		draw4(n, 0.5, 0.5, 0.5);
		break;
	}


    }


    public static void draw1(int n, double sz, double x, double y) {
        
	if (n==0) return;
	
	// drawing 1 square at current position
	drawSquare(sz, x, y);
	
	// calculating coordinates
	double x0 = x - sz/2, x1 = x + sz/2;
	double y0 = y - sz/2, y1 = y + sz/2;
	
	// calling function at each of 4 corners
        draw1(n-1, sz/2.2, x0, y0);
        draw1(n-1, sz/2.2, x0, y1);
	draw1(n-1, sz/2.2, x1, y0);
	draw1(n-1, sz/2.2, x1, y1);
    }
    
        public static void draw2(int n, double sz, double x, double y) {
        
	if (n==0) return;
	
	// calculating coordinates
	double x0 = x - sz/2, x1 = x + sz/2;
	double y0 = y - sz/2, y1 = y + sz/2;
	
	// calling function at each of 4 corners
        draw2(n-1, sz/2.2, x0, y1);
	drawSquare(sz, x, y);
        draw2(n-1, sz/2.2, x1, y1);
	drawSquare(sz, x, y);
	draw2(n-1, sz/2.2, x0, y0);
	draw2(n-1, sz/2.2, x1, y0);

    }
	
    public static void draw3(int n, double sz, double x, double y) {
        
	if (n==0) return;
	
	// calculating coordinates
	double x0 = x - sz/2, x1 = x + sz/2;
	double y0 = y - sz/2, y1 = y + sz/2;
	
	// calling function at each of 4 corners
        draw3(n-1, sz/2.2, x0, y0);
        draw3(n-1, sz/2.2, x0, y1);
	draw3(n-1, sz/2.2, x1, y0);
	drawSquare(sz, x, y);
	draw3(n-1, sz/2.2, x1, y1);

    }
    
    public static void draw4(int n, double sz, double x, double y) {
        
	if (n==0) return;

	// calculating coordinates
	double x0 = x - sz/2, x1 = x + sz/2;
	double y0 = y - sz/2, y1 = y + sz/2;
	
	// calling function at each of 4 corners
        draw4(n-1, sz/2.2, x0, y0);
	drawSquare(sz, x, y);
        draw4(n-1, sz/2.2, x0, y1);
	drawSquare(sz, x, y);
	draw4(n-1, sz/2.2, x1, y0);
	drawSquare(sz, x, y);
	draw4(n-1, sz/2.2, x1, y1);
	drawSquare(sz, x, y);
    }
    
    public static void drawSquare(double sz, double x, double y) {
        

	
	// drawing 1 square at current position
	StdDraw.setPenColor(StdDraw.GRAY);
	StdDraw.filledSquare(x, y, sz/2); //centered at x,y, size of 2r
	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.square(x, y, sz/2);
	return;
	
    }

}
