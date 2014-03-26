/*
true compact genome, which uses bitwise operations on int to take 2 bits per nucleotide (instead of 8 for boolean in compact genome).
Напомню - int занимает 32 бита. Каждые 2 бита в нём - это один из нуклеодидов. 
Получается как будто массив двухбитовых переменных, который вмещает их 16 штук. 
Потому у тебя будет двухступенчатая адресация - снаяала найти нужный инт в массиве интов, потом найти нужную пару битов у этого инта */

//01010101 & ~(1<<2) // turn bit off
//10000001 | 1 << 5 = 1010000 // turn bit on
//x & 1<<n Returns 1<<n if the n-th bit is set in x

package JavaBook.genome;
import JavaBook.stanfStd.*;

public class TrueCompactGenome extends Genome {

    // constructors:
    public TrueCompactGenome() {
        this(DEFAULT_VALUES);
    }

    public TrueCompactGenome(String _values) {
        int arrayLength = (int)(_values.length()/16) + 1;
        int[] out = new int[arrayLength];
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < 31 ; j+= 2) {
                out[i] = out[i] | (charToInt(_values.charAt(i*16 + j/2)) << j);
            }
        }
        int lastIndex = 2*((_values.length()-1)%16);
        for (int j = 0; j <= lastIndex; j+= 2) {
            out[arrayLength - 1] = out[arrayLength - 1] | (charToInt(_values.charAt((arrayLength - 1)*16 + j/2)) << j);
        }
        this.values = out;
        int[] ends = {arrayLength - 1, lastIndex};
        this.endIndex = ends;
//        this.endIndex[0] = _values.length() - 1;
//        this.endIndex[1] = lastIndex;
    }

    @Override
    public void addNucl(char nucleotide) {
        if (isNucleotide(nucleotide)) {
            if (this.values.length-1 == this.endIndex[0] && this.endIndex[1] == 30) {
                this.increaseLength();
            }
            
            if (this.endIndex[1] == 30) {
                this.endIndex[0]++;
                this.endIndex[1] = 0;
            }
            else {
                this.endIndex[1] += 2;
            }
            
            this.values[endIndex[0]] = this.values[endIndex[0]] | (charToInt(nucleotide) << endIndex[1]);
        }
        else {
            StdOut.println("Adding nucleotide failed cause it's not nucleotide char."); // exception?
        }
    }

    @Override
    public char nucleotideAt(int i) {
        int quotient = (int)(i/16);
        int remainder = 2*(i%16);
        
        return intToChar(values[quotient], remainder);            
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.endIndex[0]; i++) {
            for (int j = 0; j < 31; j+=2) {
                out += intToChar(this.values[i], j);
            }
        }        
        for (int j = 0; j <= this.endIndex[1]; j+=2) {
                out += intToChar(this.values[this.endIndex[0]], j); // _values.length() - 1.
        }                
        return out;
    }

    protected void increaseLength() {
        int[] increasedArray = new int[this.values.length + 1];
        copyIntArray(this.values, increasedArray);
        this.values = increasedArray;
    }

    // private char intToChar (int Nucleotides) {
    //     intToChar(Nucleotides, 1);
    // }


    private char intToChar(int Nucleotide, int position) {
        if (position % 2 != 0 || position < 0 || position > 31) {
            System.out.println("Position was wron_values.length() - 1g, you should start at 0, pass even position.");
            return ' ';
        }
        else {
            if ((Nucleotide & (1 << position)) == (1 << position))  {
                if ( (Nucleotide & (1 << position+1)) == (1 << position+1)) 
                        return 'T';
                else return 'C';
            }
            else {
                if ( (Nucleotide & (1 << position+1)) == (1 << position+1)) 
                        return 'G';
                else return 'A';
            }
        }        
//        else {
//            if ((Nucleotide & (1 << ++position)) == (1 << ++position))  {
//                if ( (Nucleotide & (1 << position)) == (1 << position)) 
//                        return 'T';
//                else return 'G';
//            }
//            else {
//                if ( (Nucleotide & (1 << position)) == (1 << position)) 
//                        return 'C';
//                else return 'A';
//            }
//        }
    }
    
    private int charToInt(char Nucleotide) {
        switch (Nucleotide) {
            case 'A' : {
                int a = 0b00;
                return a;
            }
            case 'C' : {
                int c = 0b01;
                return c;
            }            
            case 'G' : {
                int g = 0b10;
                return g;
            }            
            case 'T' : {
                int t = 0b11;
                return t;
            }
            default: {
                int d = 0b00;
                StdOut.println("failed in CharToInt");
                return d;               
            }
        }
    }  
    
    private static void copyIntArray(int[] src, int[] dst) {
        if (src.length > dst.length) {
            throw new RuntimeException("Not enough space in dst");
        }
        for (int i = 0; i < src.length; i++) {
                dst[i] = src[i];
        }        
    }
    
//    private static char[] NUCLEOTID_VALUES = {'A', 'T', 'G', 'C'};
//    
//    private static boolean[][] NUCLEOTID_VALUES_BOOL = new boolean[][]{

    
    private static String DEFAULT_VALUES = "";
    
    private int[] values;
    private int[] endIndex;  // [0] stores array index of last int value, [1] stores position of last nucleotide in last integer  
    
    public static void main(String[] args) {

        String input = "TGGGTCACAGAACTTACGTGACTGATCGAAATCCCCTGGGAATGCGGAG";
        TrueCompactGenome inputG = new TrueCompactGenome(input);

        StdOut.println("Inputed array: "+ inputG.toString());
        
        inputG.addNucl('A');
        StdOut.println("After adding A to input: "+ inputG.toString());
        char[] codon = {'T', 'G', 'T'};
        inputG.addCodon(codon);
        StdOut.println("After adding codon TGT to input: "+ inputG.toString());
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );        
        
        
    }
}
