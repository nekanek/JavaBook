/*
/32.Horner's method. Write a class Horner.java with a method double eval(double x, double[] p) that evaluates the polynomial p(x) whose coefficients are the entries in p[]:
p0 + p1x1 + p2x2 + ... + pN-2xN-2 + pN-1xN-1 
Use Horner's method, an efficient way to perform the computations that is suggested by the following parenthesization:
p0 + x (p1 + x( p2 + ... + x(pN-2 + xpN-1))...)
Write a test client with a static method exp() that uses Horner.eval() to compute an approximation to e^x, using the first N terms of the Taylor series expansion e^x = 1 + x + x ^2/2! + x ^3/3! + .... Include code to check your answer against that computed by Math.exp(). 
*/

public class ex_2_1_32_horner

{
        public static void main(String[]args)        
        {
			//test client
			int N = StdIn.readInt();
			double x = StdIn.readDouble();
			double [] p= new double[N];
			for (int i=0; i<N; i++) {
				p[i]= StdIn.readDouble();}
			double Horner=eval(x, p);
			System.out.println("According to Horner's method the polinomial value is " + Horner + ".");
        }
        
        public static double eval(double x, double[] p)
        {
			double Horner = p[p.length-1];
			for (int i=(p.length-2); i<=0; i--) {
				Horner = Horner*x+p[i]; }
			;
			return Horner;
        }

}
