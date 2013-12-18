/*
3.3.20. Write a program to read in three real numbers a, b, and c and print out all roots of ax2 + bx + c, including complex ones.
*/
 
public class ex_3_3_20_ComplexRoots {

    public static void main(String[] args) {
		System.out.print("Please input a, b and c.\n");   
		Double a = StdIn.readDouble(); // a
		Double b = StdIn.readDouble(); 
		Double c = StdIn.readDouble(); 
		
		Double Disc = Math.pow(b,2)-4*a*c; // calculating discr
		
		if (Disc < 0) {
			Complex root1 = new Complex(b/(2*a),Math.pow((-1.0*Disc),0.5)/(2*a));
			System.out.print("Roots of the equation are "+ root1.re()+" +/- " + root1.im() + "i.\n");
		}
		
		else {
			Double root3 = (b - Math.pow(Disc,0.5))/(2*a);
			if (Disc==0.0) {
				System.out.print("Root of the equation is "+root3 + "\n"); 		
			}
			else {
				Double root4 = (b + Math.pow(Disc,0.5))/(2*a);
				System.out.print("Roots of the equation are "+ root3+" and "+ root4+ "\n");
			}			
		}
	}    
						
}
