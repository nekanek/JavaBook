/*
7. Write a method that takes double values ymin and ymax (with ymin strictly less than ymax) and a double array a[] as arguments and uses the StdStats library to linearly scale the values in a[] so that they are all between ymin and ymax. 
*/

public class ex_2_2_7_scale

{
      public static void main(String[]args)        
        {
			//test client
			double min = StdIn.readDouble();
			double max = StdIn.readDouble();
			
			if (min < max) {
			
				int N = StdIn.readInt();
				double [] a = new double[N];
				
				for (int i=0; i<N; i++) 
					a[i]= StdIn.readDouble();
					
				double ScaledArray = ScaleArray(a);
				
				PrintArray("Given Array: ", a);
				PrintArray("Scaled Array: ", ScaledArray);		
			}
			else
				System.out.println("Min value is bigger or equals Max value.");
        }
        
    public static double ScaleArray(double[] a)
        {
			double Horner = a[a.length-1];
			for (int i=(a.length-2); i<=0; i--) {
				Horner = Horner*x+a[i]; }
			;
			return Horner;
        }
		
	public static void PrintArray2D(String ArrayName, int Rows, int Columns, double[][] Array)
		{
			System.out.println(ArrayName);
			for (int i=0; i<Rows; i++) {
				for (int j=0; j<Columns; j++)	{
					System.out.print(Array[i][j] + " "); 
				}
				System.out.println();
			}
			System.out.println();
		}
		
	public static void PrintArray(String ArrayName, double[] Array)
		{
			System.out.println(ArrayName);
			for (int i=0; i<(Array.length-1); i++) 
				System.out.print(Array[i] + " "); 
			System.out.println();
		}		
}
