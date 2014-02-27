/*
3.3.14. 

*/
package JavaBook.genome;
import JavaBook.stanfStd.*;

public abstract class Genome {

    public void addCodon (char[] codon) {
        if (codon.length != 3) {
            throw new RuntimeException("Wrong codon length of " + codon.length);
        }
        for (int i = 0; i < codon.length; i++) {
            addNucl(codon[i]);
        }
    }

    public abstract void addNucl (char nucleotide);
    public abstract char nucleotideAt (int i);
    public abstract String toString ();
    public static String toString (Genome input) {
        return input.toString();
    }

    protected abstract void increaseLength ();

    protected static boolean isNucleotide (char inputChar) {
        return (inputChar == 'A' || inputChar == 'T' || inputChar == 'C' || inputChar == 'G');
    }
}
