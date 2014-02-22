/*
3.3.14. 

*/
package JavaBook.genome;
import JavaBook.stanfStd.*; 		

public class ClientGenome {

    public static void main(String[] args) {
        // read dna sequence
        String dna = args[0];
        char[] input = new char[dna.length()];
        for (int i = 0; i < dna.length(); i++) {
            input[i]=dna.charAt(i);
        }
        CharGenome inputG = new CharGenome(input);

        StdOut.println("Inputed array: "+ inputG.toString() + " or another method: " + CharGenome.toString(inputG));
        StdOut.println("After adding A to input: "+ inputG.addNucl('A') );
        char[] codon = {'T', 'G', 'T'};
        StdOut.println("After adding codon TGT to input: "+ inputG.addCodon(codon));
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );
    }

}
