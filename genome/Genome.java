/*
3.3.14. 

*/
package JavaBook.genome;
import JavaBook.stanfStd.*; 		

public interface Genome {

    // static Genome addCodon (char[] codon) {
    //     if (codon.length != 3) {
    //         throw new RuntimeException("Wrong codon length of " + codon.length);
    //     }
    //     for (int i = 0; i < codon.length; i++) {
    //         addNucl(codon[i]);
    //     }
    //     return this;
    // }

    public Genome addNucl (char nucleotide) ;

    public char nucleotideAt (int i) ;

    public String toString () ;

    public Genome increaseLength () ;

}
