/*
CompactGenome.java implements a genome as boolean array. We need to use two bits per nucleotide since there are 4 different nucleotides. As in the previous implementation, we use a dynamic array with repeated doubling. Now, each nucleotide consumes 2 bits of storage (instead of 16). 
*/

package JavaBook.genome;
import JavaBook.stanfStd.*;

public class CompactGenome extends Genome {

    // constructors:
    public CompactGenome() {
        this(DEFAULT_VALUES);
    }

    public CompactGenome(String _values) {
        boolean [][] out = new boolean[_values.length()][2];
        for (int i = 0; i < _values.length(); i++) {
            out[i] = charToBool(_values.charAt(i));
        }
        this.values = out;
        this.endIndex = _values.length() - 1;
    }

    @Override
    public void addNucl (char nucleotide) {
        if (isNucleotide(nucleotide)) {
            if (this.values.length-1 == this.endIndex) { 
                this.increaseLength();
            }
            this.values[++this.endIndex] = charToBool(nucleotide);
        }
        else {
            StdOut.println("Adding nucleotide failed cause it's not nucleotide char."); // exception?
        }
    }

    @Override
    public char nucleotideAt (int i) {
        return boolToChar(values[i]);
    }

    @Override
    public String toString () {
        String out = "";
        for (int i = 0; i <= this.endIndex; i++) {
            out += boolToChar(this.values[i]);
        }
        return out;
    }

    protected void increaseLength () {
        boolean[][] increasedArray = new boolean[this.values.length*2][2];
        copyBoolArray(this.values, increasedArray);
        this.values = increasedArray;
    }

    private char boolToChar (boolean[] Nucleotide) {
        if (Nucleotide[0]) {
            if (Nucleotide[1]) return 'G';
            else return 'C';
        }
        else {
            if (Nucleotide[1]) return 'T';
            else return 'A';
        }
        // StdOut.println("failed in oolToChar");
    }
    
    private boolean[] charToBool (char Nucleotide) {
        switch (Nucleotide) {
            case 'A' : {
                boolean[] a = {false,false};
                return a;
            }
            case 'T' : {
                boolean[] t = {false, true};
                return t;
            }            
            case 'G' : {
                boolean[] g = {true, true};
                return g;
            }            
            case 'C' : {
                boolean[] c = {true, false};
                return c;
            }
            default: {
                boolean[] d = {false,false};
                StdOut.println("failed in CharToBool");
                return d;               
            }
        }
    }  
    
    private static void copyBoolArray (boolean[][] src, boolean[][] dst) {
        if (src.length > dst.length) {
            throw new RuntimeException("Not enough space in dst");
        }
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < 2; j++) {
                dst[i][j] = src[i][j];
            }
        }        
    }
    
//    private static char[] NUCLEOTID_VALUES = {'A', 'T', 'G', 'C'};
//    
//    private static boolean[][] NUCLEOTID_VALUES_BOOL = new boolean[][]{
//    {false, false}, // A
//    {false, true}, // T
//    {true, true}, // G
//    {true, false} }; // C
    
    private static String DEFAULT_VALUES = "";
    
    private boolean[][] values;
    private int endIndex;    
    
    public static void main(String[] args) {

        String input = "TGGACAGAACTT";
        CompactGenome inputG = new CompactGenome(input);

        StdOut.println("Inputed array: "+ inputG.toString());
        
        inputG.addNucl('A');
        StdOut.println("After adding A to input: "+ inputG.toString());
        char[] codon = {'T', 'G', 'T'};
        inputG.addCodon(codon);
        StdOut.println("After adding codon TGT to input: "+ inputG.toString());
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );        
        
        
    }
}
