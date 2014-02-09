/* 18. Write a method that takes an array of double values as argument and rescales the array so that each element is between 0 and 1 (by subtracting the minimum value from each element and then dividing each element by the difference between the minimum and maximum values). Use the max() method defined in the table in the text, and write and use a matching min() method.
*/

public class ex_2_1_18_rescale

{		
	public static void main(String[]args) //void return type 	
		{

			int N = StdIn.readInt(); // number of array values
			double[] InputArray = new double[N]; //extra 2 for min and max
			
			for (int i=0; i<N; i++) {
				InputArray[i]=StdIn.readDouble();
			}
			StdOut.print("Input array:\n");			
				for (int i=0; i<N; i++) {
					StdOut.print(InputArray[i]+" ");
				}
			
			double Min = Minimum(InputArray); // compute max and min and write their values as last	2 array values
			double Max = Maximum(InputArray);
						
			InputArray = Rescale(InputArray, Min, Max);
			
			StdOut.print("\nRescaled array:\n");
				
				for (int i=0; i<N; i++) {
					StdOut.printf("%.3f ",InputArray[i]);
				}
			StdOut.print("\n");				
		}
		
	// Actually, min and max are quite popular functions and they both have well-defined semantics.
	// These functions should get some container as input - the array in our case and return a single number.
	// It's like math - most math functions do not modify their arguments, instead they compute some new value and
	// return it. You should do the same. Also it eliminates the need for 2 additional places in the array.

	// There is a certain rule of thumb - Single Responsibility Rule. Each and every thing should do one thing and 
	// do it good. The input array of N numbers - is a single role. But an array of N numbers and 2 additional numbers
	// for min and max are 3 roles already. You better use 3 variables instead.
	public static double Minimum(double[] InputArray) 
		{
			double Min = InputArray[0];
			for (int i=1; i<(InputArray.length); i++) {
				if (Min > InputArray[i]) Min = InputArray[i];	
			}
			return Min;
		}

	public static double Maximum(double[] InputArray) 
		{
			double Max = InputArray[0];
			for (int i=1; i<(InputArray.length); i++) {
				if (Max < InputArray[i]) Max = InputArray[i];	
			}
			return Max;
		}	
		
	public static double[] Rescale(double[] InputArray, double Min, double Max) 
		{
			// N: dunno how to rescale those cases better.../ guess this now should work for all cases../
			if ((Max-Min)==0.0) {
				if (Max<0.0||Max>1.0) {
				    for (int i=0; i<(InputArray.length); i++) 
					InputArray[i]=1.0;
				}
			}

			else {
				for (int i=0; i<(InputArray.length); i++) {
				    // Here we get division by zero or by extremely small value if (max - min) == epsilon
				    // Try to input the array like {1, 1, 1, 1}
				    InputArray[i]=((InputArray[i]-Min)/(Max-Min));
				}
			}
			return InputArray;
		}
		
}
