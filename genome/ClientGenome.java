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
        Genome inputG = new CharGenome(input);

        StdOut.println("Inputed array: "+ inputG.toString() + " or another method: " + CharGenome.toString(inputG));
        inputG.addNucl('A') ;
        StdOut.println("After adding A to input: "+ inputG.toString());
        char[] codon = {'T', 'G', 'T'};
        inputG.addCodon(codon);
        StdOut.println("After adding codon TGT to input: "+ inputG.toString());
        StdOut.println("In input gene nucleotide at position 3 is: "+ inputG.nucleotideAt(3) );
    }

}
