/*
3.1.31. Complemented palindrome detector. In DNA sequence analysis, a complemented palindrome is a string equal to its reverse complement. Adenine (A) and Thymine (T) are complements, as are Cytosine (C) and Guanine (G). For example, ACGGT is a complement palindrome. Such sequences act as transcription-binding sites and are associated with gene amplification and genetic instability. Given a text input of N characters, find the longest complemented palindrome that is a substring of the text. For example, if the text is GACACGGTTTTA then the longest complemented palindrome is ACGGT. Hint: consider each letter as the center of a possible palindrome of odd length, then consider each pair of letters as the center of a possible palindrome of even length.

N: another sequences to check: GACACGGTTTT(AGACACGGTGTCT)TA
GACA(AGACACGTGTCT)CGGTTTT(AGACACGTGTCTAGACACGTGTCT)TATTTTT(AGACACGTGTCTGAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTT(AGACACGTGTCTAGACACGTGTCT)TATTTTT(AGACACGTGTCTGAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTTAGACACGTGTCTAGGTGTCTTATTTTT(AGACACGTGTCTAGACACGTGTCT)
GACAAGACACGTGTCTCGGTTTTTTTAGACACGTGTCTAGACACGTGTCTTTTTATTTTTAGACACGTGTCTGAGACACGTGTCT
GACAAGACACGTGTCTCGGTTTTAGACACGTGTCTAGACACGTGTCTTATTTTTAGACACGTGTCTGAGACACGTGTCT

Genome. Implement a data type to store the genome of an organism. Biologists often abstract away the genome to a sequence of nucleotides (A, C, G, or T). The data type should support the 
method addNucleotide, nucleotideAt(int i), and addCodon. 
check that only legal nucleotides are added, can change to more time or memory efficient implementation without affecting client.

    StringGenome.java has one instance variable of type String. It implements addNucleotide with string concatenation. Each method call takes time proportional to the size of the current genome. Not practical spacewise either for large genomes since nucleotide is stored as a 16-bit char.
    
Genome.java implements a genome as an array of characters. The size of the array is doubled when the array fills up. The method addNucleotide is now constant time. Space consumption is still 16 bits per nucleotide.
    
    CompactGenome.java implements a genome as boolean array. We need to use two bits per nucleotide since there are 4 different nucleotides. As in the previous implementation, we use a dynamic array with repeated doubling. Now, each nucleotide consumes 2 bits of storage (instead of 16). 
битовые операции используются для того чтобы хранить 4 двухбитовых значения. для модификации отдельных значений нужно применять битовые операции над типом int. типа прочитать первые два бита, изменить биты 4 и 5..
    
    
Забавно, что в creative 14 вариант решения compact genome - неверный. Точнее он работает, но неверно то, что о нём пишет автор. Там далеко не 2 бита на букву, а те же самые 16. Я не помню, ты ведь проходила битовые операции над целыми числами? А то я бы предлжил правильно перепилить этот пример, чтобы он задействовал лишь честные 2 бита на букву. Могу объяснить подробнее, как это сделать.

все символы, без проверки на кодонность
addNucl - добавляет одну букву
addCodon - добавить кодон
*/
package JavaBook;
import JavaBook.stanfStd.*;

public class Genome {

    private final char[] Values;
    private final int Length;
    
     private static final char[] DEFAULT_VALUES = {'A', 'T', 'G', 'C'};
     // private static final int DEFAULT_LENGTH = 10;
    
    // constructors:
    public Genome() {
        this(DEFAULT_VALUES);
    }   
    
    public Genome(char[] values) {
        this.length = 2*values.length;
        this.values = values;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
