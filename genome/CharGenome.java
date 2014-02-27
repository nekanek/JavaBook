/*
3.3.14.     
Genome.java implements a genome as an array of characters. The size of the array is doubled when the array fills up. The method addNucleotide is now constant time. Space consumption is still 16 bits per nucleotide.
*/
package JavaBook.genome;
import JavaBook.stanfStd.*;

public class CharGenome extends Genome {

    // constructors:
    public CharGenome() {
        this(DEFAULT_VALUES);
    }

    public CharGenome(char[] values) {
        this(values, values.length-1);
    }

    public CharGenome(char[] values, int endIndex) {
        if (checkArray(values)) {
            this.values = values; // should do defensive copy i guess (and add Character.toUpperCase() )
            this.endIndex = endIndex;
        } else {
            StdOut.println("trying to create CharGenome. failed.");
            // change it to throw exception
            this.values = null;
            this.endIndex = 0;
        }
    }

    @Override
    public void addNucl (char nucleotide) {
        if (isNucleotide(nucleotide)) {
            if (this.values.length-1 == this.endIndex) { 
                // CharGenome newCharGenome = this.increaseLength();
                this.increaseLength();
                this.values[++this.endIndex] = nucleotide;
                // return this;
            }
            else {
                this.values[++this.endIndex] = nucleotide;
            }
        }
        else {
            StdOut.println("Adding nucleotide failed cause it's not nucleotide char."); // exception?
        }
    }

    @Override
    public char nucleotideAt (int i) {
        if (i <= this.endIndex) {
            return this.values[i];
        } else {
            StdOut.println("Some error msg."); // change to exception not to return char
            return ' ';
        }
    }

    @Override
    public String toString () {
        String out = "";
        for (int i = 0; i <= this.endIndex; i++) {
            out += this.values[i];
        }
        return out;
    }

    protected void increaseLength () {
        char[] increasedArray = new char[this.values.length * 2];
        copyChArray(this.values, increasedArray);
        this.values = increasedArray;
    }

    // could possibly use StdArraysIO instead
    private static void copyChArray (char[] src, char[] dst) {
        if (src.length > dst.length) {
            throw new RuntimeException("Not enough space in dst");
        }
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i];
        }
    }

    private static boolean checkArray (char[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (!isNucleotide(inputArray[i])) {
                StdOut.println("not nucleotide in checking array.");
                return false;
            }
        }
        return true;
    }

    private static char[] NUCLEOTID_VALUES = {'A', 'T', 'G', 'C'};
    private static char[] DEFAULT_VALUES = {};

    private char[] values;
    private int endIndex; // index of the last value in array (since array length can b grtr than the number of nucleotides in it) 

    public static void main(String[] args) {

        char[] input = {'T','G','G','A','C','A','G','A','A','C','T','T'};
        CharGenome inputG = new CharGenome(input);
        // char[] default = new char{'A', 'T', 'G', 'C','G', 'C','G', 'A'};
        // CharGenome defaultG = new CharGenome();

        StdOut.println("Inputed array: "+ inputG.toString() + " or another method: " + toString(inputG));
        // StdOut.println("Default array: "+ defaultG.toString() + " (or with another method: " + toString(defaultG) + ").");
        inputG.addNucl('A');
        StdOut.println("After adding A to input: "+ inputG.toString());
        char[] codon = {'T', 'G', 'T'};
        inputG.addCodon(codon);
        StdOut.println("After adding codon TGT to input: "+ inputG.toString());
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );
    }
}
