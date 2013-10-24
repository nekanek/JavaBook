/*
7. Write a method that takes double values ymin and ymax (with ymin strictly less than ymax) and a double array a[] as arguments and uses the StdStats library to linearly scale the values in a[] so that they are all between ymin and ymax. 
*/

public class ex_2_2_7_scale

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
