/*
15. Sicherman dice. Suppose that you have two six-sided dice, one with faces labeled 1, 3, 4, 5, 6, and 8 and the other with faces labeled 1, 2, 2, 3, 3, and 4. Compare the probabilities of occurrence of each of the values of the sum of the dice with those for a standard pair of dice. Use StdRandom and StdStats.
Solution: dice with these properties are called Sicherman dice: they produce sums with the same frequency as regular dice (2 with probability 1/36, 3 with probability 2/36, and so on). 
*/


public class ex_2_2_15_Sicherman

{
   public static void main(String[]args)        
     {
		//test client
		double ymin = StdIn.readDouble();
		double ymax = StdIn.readDouble();
		int N = StdIn.readInt();
		double [] a = new double[N];
    
		for (int i=0; i<N; i++) a[i]= StdIn.readDouble();
	 
		double[] ScaledArray = Scale(ymin, ymax, a);
		
		PrintArray("Given Array: ", a);
		PrintArray("Scaled Array: ", ScaledArray); 
        }
        

 public static double[] Scale(double ymin, double ymax, double[] a)
  {
	if (ymin < ymax) {
		double aMax = StdStats.max(a);
		double aMin = StdStats.min(a);
		double [] aScaled = new double[a.length];
		for (int i = 0; i<a.length; i++) aScaled[i] = ymin + (a[i] -  aMin)*(ymax - ymin)/(aMax- aMin);
		return aScaled;
    }
	else {
		System.out.println("Min value is bigger or equals Max value.");
		return a;
	}
}
  
 public static void PrintArray(String ArrayName, double[] Array)
  {
	   System.out.println(ArrayName);
	   for (int i=0; i<Array.length; i++) 
		System.out.print(Array[i] + " "); 
	   System.out.println();
  }  
}
