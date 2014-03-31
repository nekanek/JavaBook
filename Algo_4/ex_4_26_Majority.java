// 26. Majority. An element is a majority if it appears more than N/2 times. Write a static method that takes an array of N strings as argument and identifies a majority (if it exists) in linear time. 
// will print out last string if both of them r 50%

package JavaBook.Algo_4;

import java.util.Scanner;


public class ex_4_26_Majority {

    public static void main(String[] args) {
        
        String[] input = scanStringArray();
        // Merge.sort(input);
         
        int majorityCounter = 0;
        // String MajorityValue = "";
        // int Majority = (int)input.length/2;
        // boolean Found = false;
        String majorityString = null;
        
        for(int i = 0; i < input.length; i++) {
            
            if (input[i].equals(majorityString)) 
                majorityCounter++;
            else if (majorityCounter > 0) {
                majorityCounter--;
                //if (majorityCounter == 0)
                //    majorityString = null;
            }
            else if (majorityCounter == 0) {
                majorityString = input[i];
                majorityCounter++;
            }
        }
        

        if (majorityString != null) {
            System.out.println("Majority of input is string " + majorityString);
        }
        else {
            System.out.println("no majority string found in the input.");
        }    
        
    }    

    public static String[] scanStringArray() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Please, enter length of array as first element (int).");
        if(sc.hasNextInt()) {
          n = sc.nextInt();
          sc.nextLine();
        } 
        else {
          return scanStringArray();
        }
        
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            if(sc.hasNext()) {
              input[i] = sc.nextLine(); 
            } 
            else {
              System.out.println("Input was wrong. Please input again."); 
              return scanStringArray();
            }
        }
        return input;
    } 
}


