
/*
2.3.27. Sierpinski triangles. Write a recursive program to draw the Sierpinski gasket. As with Htree, use a command-line argument to control the depth of recursion. 

*/

public class ex_2_3_27_SierpinskiTriangles {

    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]); // depth n
	if (n>0) {
	    double[] x = {0.0,0.5,1.0}; // coordinates of main triangle
	    double[] y = {0.0,(Math.sqrt(3.0)/2.0),0.0}; 
	    StdDraw.polygon (x,y);
	    draw(n, x[0], y[0], x[1], y[1]);
	}    
	else
	    StdOut.print("Depth of recursion should exceed 0.");

    }


    public static void draw(int n, double x0, double y0, double x1, double y1) {
        
	if (n==0) return;
	
	// calculating coordinates
	double x[] = {x0+(x1-x0)/2.0,x1,(x1+(x1-x0)/2.0)};
	double y[] = {y0+(y1-y0)/2.0,y0,y0+(y1-y0)/2.0};
	
	// drawing 1 triangle at current position
	StdDraw.polygon (x,y);
	
	// calling function at each of 3 corners
	draw (n-1,x0,y0,x[0],y[0]);
	draw (n-1,x[0],y[0],x1,y1);
	draw (n-1,x[1],y[1],x[2],y[2]);
	    
    }
    

}
