/*
3.1.40. Arbitrary precision integer arithmetic. Write a program that takes two decimal strings as inputs, and prints out their sum. Use a string to represent the integer.
*/

public class ex_3_1_40_StringsSum {

    public static void main(String[] args) {
    String delimiter = "\\.";    
    String inputA = args[0]; // 1st string
    String inputB = args[1]; // 2nd string


    String[] partsOfA = inputA.split(delimiter); // partsOfA[0] - integer part, partsOfA[1] - fraction of inputA
    String[] partsOfB = inputB.split(delimiter);
    


	// append 0 to the shortest integer part
	String[] zeroedIntegers = AppendZeros (partsOfA[0], partsOfB[0], true);
	partsOfA[0] = zeroedIntegers[0];
	partsOfB[0] = zeroedIntegers[1];

	// append 0 to the shortest fraction part
	String[] zeroedFractions = AppendZeros (partsOfA[1], partsOfB[1],false);
	partsOfA[1] = zeroedFractions[0];
	partsOfB[1] = zeroedFractions[1];	
	
	// calculate  sum of integer parts
	String SumIntegers = SumStrings (partsOfA[0], partsOfB[0]);
	
	// calculate sum of fractions
	String SumFractions = SumStrings (partsOfA[1], partsOfB[1]);
	
	// adding 1 from fraction to decimal if necessary (if the number of symbols in sum exceeds max number of symbols in fraction part of A or B
	if ( SumFractions.length() > Math.max(partsOfA[1].length(),partsOfB[1].length())) { // || ((SumFractions.length() > partsOfB[1].length())) ) {
		// generate string of 0s (plus additional symbol in case sum exceeds longest component's length)
		String fractionToDecimal = "1";
		
		String[] zeroedFractionToDecimal = AppendZeros (fractionToDecimal, SumIntegers, true);
		//StdOut.print(zeroedFractionToDecimal[0]+"   "+zeroedFractionToDecimal[1]+"    ");
		fractionToDecimal = zeroedFractionToDecimal[0];
		
/* 		for (0) {
			fractionToDecimal = Integer.toString(0)+fractionToDecimal;
		} */
		SumIntegers = SumStrings (SumIntegers, fractionToDecimal);
		
		// delete first overflow character from fraction part
		SumFractions = SumFractions.substring(1,SumFractions.length());
	}
	
	StdOut.print(inputA+" + "+ inputB + " = "+ SumIntegers + "."+SumFractions+".\n");
	}

	public static String SumStrings (String inA, String inB) {
		
	    //initialize sumString
	    String sumString = "";
	    int[] sumInteger = new int[inA.length()]; 
	    int firstDigit = 0; // for the case if sum exceeds longest component's length
	    int Sum;
//		for (int i = 0; i < inA.length()+1;i++) {
//			//sumString+= "0";
//			sumInteger[i]=0;
//		}
		
	    for (int i=inA.length()-1; i>=0; i--) { // don't do it for the most significant 
		Sum = Integer.parseInt(String.valueOf(inA.charAt(i)))+Integer.parseInt(String.valueOf(inB.charAt(i)));
		if (Sum>9) {
			sumInteger[i]+=(Sum-10);
			if (i!=0) { // exceptional case if sum exceeds longest component's length
			    sumInteger[i-1]+=1;
			}
			else firstDigit += 1;
		}
		else if (Sum==9 && sumInteger[i]==1) {
			sumInteger[i]=0;
			if (i!=0) {
			    sumInteger[i-1]+=1;
			}
			else firstDigit += 1;			
		}
		else {
			sumInteger[i]+=Sum;	
		}
	    }
	    // convert array to string
	    for (int i = 0; i < sumInteger.length;i++) {
		    sumString+= sumInteger[i];
	    }
	    if (firstDigit!=0) {
		sumString = firstDigit+sumString;
	    }
	    return sumString;
	}

	
    // append zeros to the shortest of two input strings
    public static String[] AppendZeros (String A, String B, boolean inBeginning) {	
	    
	    if (A.length()<B.length()) {
		    int n = B.length()-A.length();
		    for (int i = 0; i<n; i++) {
			if (inBeginning==true) A="0"+A; 
			else A=A+"0";
		    }
	    }	
	    else if (A.length()>B.length()) {
		    int n = A.length()-B.length();
		    for (int i = 0; i<n; i++) {
			if (inBeginning==true) B="0"+B; 
			else B=B+"0";
		    }
	    }
	    return new String[]{A,B};
    }
	
}
