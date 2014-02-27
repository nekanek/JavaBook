/*
3.3.14. 

*/
package JavaBook.genome;
import JavaBook.stanfStd.*; 		

public class ClientGenome {

    public static void main(String[] args) {
        Genome inputG = new CharGenome(dna);

        StdOut.println("Inputed array: "+ inputG.toString() + " or another method: " + CharGenome.toString(inputG));
        inputG.addNucl('A') ;
        StdOut.println("After adding A to input: "+ inputG.toString());
        char[] codon = {'T', 'G', 'T'};
        inputG.addCodon(codon);
        StdOut.println("After adding codon TGT to input: "+ inputG.toString());
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );
    }

}
