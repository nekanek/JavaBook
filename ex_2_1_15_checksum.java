/* 15. The following checksum formula is widely used by banks and credit card companies to validate legal account numbers:
d0 + f(d1) + d2 + f(d3) + d4 + f(d5) + d6 + ... = 0 (mod 10)
The di are the decimal digits of the account number and f(d) is the sum of the decimal digits of 2d (for example, f(7) = 5 because 2 * 7 = 14 and 1 + 4 = 5). For example, 17327 is valid because 1 + 5 + 3 + 4 + 7 = 20, which is a multiple of 10. Implement the function f and write a program to take a 10-digit integer as a command-line argument and print a valid 11-digit number with the given integer as its first 10 digits and the checksum as the last digit.
*/

public class ex_2_1_15_checksum

{
	static boolean IsOk;	
	
	public static void main(String[]args) //void return type 	
		{

			String Input = String.valueOf(args[0]);
			String[] InputArray = new String[11];
			
			for (int i=0; i<10; i++) {
				InputArray[i]=Input.substring(i, i+1);
			}
			
			InputArray = Compute(InputArray);
			
			if (IsOk==true) {
				StdOut.print("CheckSum is correct. Checksum value:\n");
				for (int i=0; i<11; i++) {
					StdOut.print(InputArray[i]);
				}
			}	
			else {
				StdOut.print("CheckSum is incorrect.");		
			}
			StdOut.print("\n");	
			
		}
		
	public static String[] Compute(String[] InputArray) 
		{
			// You should not limit yourself explicitly to 10 elements
			// your function can work with the array of any size!
			// Instead, use InputArray's size to determine the number of elements
			for (int i=1; i<10; i+=2) {
				InputArray[i]=Sum(Integer.parseInt(InputArray[i]));	
			}
			int CheckSum = 0;
			for (int i=0; i<10; i++) {
				CheckSum += Integer.parseInt(InputArray[i]);
			}
			
			if (CheckSum%10==0) {
			
				// This place is unclear to me. Why do we need to add digits' values of the checksum recursively?
				// Shouldn't we just append the value of CheckSum%10 to the initial number?
				while (CheckSum>9) {
					int CheckSum1 = Integer.parseInt((String.valueOf(CheckSum)).substring(0, 1));
					int CheckSum2 = Integer.parseInt((String.valueOf(CheckSum)).substring(1, 2));
					CheckSum=CheckSum1+CheckSum2;				
				}		
							
				InputArray[10]=String.valueOf(CheckSum);
				IsOk = true;				
			}
			else {
				IsOk = false;
			}
			return InputArray;
		}
		
	public static String Sum(int d) 
		{
			// Be simpler, use integer division and modulo by 10
			// get the first digin as the quotient and the second as the remainder
			// string operations are by several orders slower than integer arithmetics
			int d2=2*d;
			if (d2<10) {
				return String.valueOf(d2);
			}
			else {
				int d21 = Integer.parseInt((String.valueOf(d2)).substring(0, 1));
				int d22 = Integer.parseInt((String.valueOf(d2)).substring(1, 2));
				d2=d21+d22;
				return String.valueOf(d2);
			}
		}
		
}
