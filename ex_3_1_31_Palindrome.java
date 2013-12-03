/*
3.1.31. Complemented palindrome detector. In DNA sequence analysis, a complemented palindrome is a string equal to its reverse complement. Adenine (A) and Thymine (T) are complements, as are Cytosine (C) and Guanine (G). For example, ACGGT is a complement palindrome. Such sequences act as transcription-binding sites and are associated with gene amplification and genetic instability. Given a text input of N characters, find the longest complemented palindrome that is a substring of the text. For example, if the text is GACACGGTTTTA then the longest complemented palindrome is ACGGT. Hint: consider each letter as the center of a possible palindrome of odd length, then consider each pair of letters as the center of a possible palindrome of even length.
*/

public class ex_3_1_31_Palindrome {

    public static void main(String[] args) {
    String dilimiter = ".";    
    String inputA = args[0]; // 1st string
	String inputB = (args[1]); // 2nd string
	String[] partsOfA = inputA.split(delimiter); // partsOfA[0] - integer part, partsOfA[1] - fraction of inputA
	String[] partsOfB = inputB.split(delimiter);
	
	// append 0 to the shortest integer part
	if (partsOfA[0].length()<partsOfB[0].length()) {
		for (int i = 0; i<partsOfB[0].length()-partsOfA[0].length(); i++) {
			partsOfA[0]+="0"; 
		}
	}	
	else if (partsOfA[0].length()>partsOfB[0].length()) {
		for (int i = 0; i<partsOfA[0].length()-partsOfB[0].length(); i++) {
			partsOfB[0]+="0"; 
		}
	}	
	
	// calculate  sum of integer parts
	SumStrings (IntegerPartA, IntegerPartB)
	
	// calculate sum of fractions
	SumStrings (fractionPartA, fractionPartB)
	
	// adding 1 from fraction to decimal if necessary
	if (fraction[0]==1) {
		// generate string of 1 plus 1 symbol if sum exceeds longest component's length
		String fractionToDecimal = "1";
		for 	{
			fractionToDecimal = Integer.toString(0)+fractionToDecimal;
		}
		SumStrings (IntegerPart, fractionToDecimal)
	}
	
	Print
	}

	public static String SumStrings (String inA, String inB) {
		
		//initialize sumString
		String sumString = "";
		int[] sumInteger = new int[inA.length()+1] // plus additional symbol if sum exceeds longest component's length
		for (int i = 0; i < inA.length()+1;i++) {
			sumString+= "0";
			sumInteger[i]=0;
		}
		
	for (i=n; i>=0; i--	) {
		int Sum= Integer.parseInt(inA.charAt(i))+Integer.parseInt(inB.charAt(i));
		if (Sum>9) {
			SumInteger[i]+=(Sum-10);
			SumInteger[i-1]+=(int)(Sum/10);
		}
		else if (Sum==9&&SumInteger[i]==1) {
			SumInteger[i]=0;
			SumInteger[i-1]+=1;			
		}
		else {
			SumInteger[i]+=Sum;	// btw, i can't see how i can move this case up after first "if" without additional condition (for the case Sum==9&&SumInteger!=1) so i decided this way will b better
		}
	}

	// convert array to string
	
	return SumString;
    }   

}
