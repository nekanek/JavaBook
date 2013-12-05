/*
3.1.31. Complemented palindrome detector. In DNA sequence analysis, a complemented palindrome is a string equal to its reverse complement. Adenine (A) and Thymine (T) are complements, as are Cytosine (C) and Guanine (G). For example, ACGGT is a complement palindrome. Such sequences act as transcription-binding sites and are associated with gene amplification and genetic instability. Given a text input of N characters, find the longest complemented palindrome that is a substring of the text. For example, if the text is GACACGGTTTTA then the longest complemented palindrome is ACGGT. Hint: consider each letter as the center of a possible palindrome of odd length, then consider each pair of letters as the center of a possible palindrome of even length.

N: another sequences to check: GACACGGTTTT(AGACACGGTGTCT)TA
GACA(AGACACGTGTCT)CGGTTTT(AGACACGTGTCTAGACACGTGTCT)TATTTTT(AGACACGTGTCTGAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTT(AGACACGTGTCTAGACACGTGTCT)TATTTTT(AGACACGTGTCTGAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTTAGACACGTGTCTAGGTGTCTTATTTTT(AGACACGTGTCTAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTTTTTAGACACGTGTCTAGACACGTGTCTTTTTATTTTTAGACACGTGTCTGAGACACGTGTCT
GACAAGACACGTGTCTCGGTTTTAGACACGTGTCTAGACACGTGTCTTATTTTTAGACACGTGTCTGAGACACGTGTCT
*/

public class ex_3_1_31_Palindrome {

    public static void main(String[] args) {

	// read dna sequence
	String dna = args[0];
	
	int MaxLength = 0;
	int MaxLengthBuf = 0;
	int MaxIndex = 0;
	
	// palindrome of odd length
    // check from each symbol i to the left and right	
	for (int i=1; i<dna.length()-1; i++) {
		
		MaxLengthBuf=1;
		// j - offset to the left or right
		outerloop:
		for (int j=1; j<Math.min(i,dna.length()-i); j++) {
			switch (dna.charAt(i-j)) {
				case 'A': if (dna.charAt(i+j)=='T') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'T': if (dna.charAt(i+j)=='A') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'C': if (dna.charAt(i+j)=='G') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'G': if (dna.charAt(i+j)=='C') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				default: {StdOut.print("Symbol "+ dna.charAt(i-j) + " can't be in DNA sequence.\n"); System.exit(0); } 
			}
		}
		
		if (MaxLength<MaxLengthBuf) {
			MaxLength = MaxLengthBuf;
			MaxIndex = i;
		}
	}
	
	// palindrome of even length
	for (int i=0; i<dna.length()-1; i++) {
		MaxLengthBuf=0;
		
		// j - offset to the left or right
		outerloop:
		for (int j=1; j<Math.min(i+2,dna.length()-i); j++) {
			switch (dna.charAt(i+1-j)) {
				case 'A': if (dna.charAt(i+j)=='T') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'T': if (dna.charAt(i+j)=='A') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'C': if (dna.charAt(i+j)=='G') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				case 'G': if (dna.charAt(i+j)=='C') {MaxLengthBuf+=2;break;} 
							else {break outerloop;}
				default: {StdOut.print("Symbol "+ dna.charAt(i+1-j) + " can't be in DNA sequence.\n"); System.exit(0); } 
			}
		}
		if (MaxLength<MaxLengthBuf) {
			MaxLength = MaxLengthBuf;
			MaxIndex = i+1;
		}		
	}	
	
	// print result
	StdOut.print("Maximum palindrome of size "+ MaxLength + " starts at "+ (MaxIndex-(int)MaxLength/2+1) + "' symbol. Palindrome:\n");
	StdOut.println(dna.substring(MaxIndex-(int)MaxLength/2,MaxIndex-(int)MaxLength/2+MaxLength));
	
    }   

}
