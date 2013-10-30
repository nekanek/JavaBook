/*
7. Write a method that takes double values ymin and ymax (with ymin strictly less than ymax) and a double array a[] as arguments and uses the StdStats library to linearly scale the values in a[] so that they are all between ymin and ymax. 
*/


public class ex_2_2_7_scale

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
