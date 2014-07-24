// 26. Majority. An element is a majority if it appears more than N/2 times. Write a static method that takes an array of N strings as argument and identifies a majority (if it exists) in linear time. 
// will print out last string if both of them r 50%

package JavaBook.Algo_4.Sorting_4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ex_4_2_26_Majority {

    public static void main(String[] args) throws FileNotFoundException {
        
        String[] input = scanStringArray();
        int majorityCounter = 0;
        String majorityString = null;
        
        for (String i : input) {
            System.out.println("i " + i);
            if (majorityCounter == 0) { 
                majorityString = i;
                majorityCounter++;
            }
            else if (i.equals(majorityString)) {
                majorityCounter++;
            }
            else  {
                majorityCounter--;
            }
            System.out.println("majorityCounter " + majorityCounter);
            System.out.println("majorityString " + majorityString);
        }

        if (majorityString != null) {
            System.out.println("Majority of input is string " + majorityString);
        }
        else {
            System.out.println("no majority string found in the input.");
        }    
    }    

    private static String[] scanStringArray() throws FileNotFoundException {
        Scanner in = new Scanner(new File("JavaBook/Algo_4/Sorting_4_2/majority.txt"));
        int n = in.nextInt(); //length of array
        in.nextLine();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextLine(); 
        }
        return input;
    } 
}


