// 26. Majority. An element is a majority if it appears more than N/2 times. Write a static method that takes an array of N strings as argument and identifies a majority (if it exists) in linear time. 
package JavaBook.Algo_4;

import java.util.Scanner;


public class ex_4_26_Majority {

    public static void main(String[] args) {
        
        String[] input = scanStringArray();
        Merge.sort(input);
         
        int MajorityCounter = 1;
        int Majority = (int)input.length/2;
        boolean Found = false;
        String MajorityString = "";
        
        for(int i = 1; i < input.length; i++) {
            
            if (input[i].equals(input[i-1])) {
                MajorityCounter++;
                if (MajorityCounter >= Majority) {
                    MajorityString = input[i];
                    Found = true;
                    break;
                }
                    
            }
            
            else {
                MajorityCounter = 1;
            }
        }

        if (Found) {
            System.out.println("Majority of input is string " + MajorityString);
        }
        else {
            System.out.println("no majority string found in the input.");
        }    
        
    }    

    public static String[] scanStringArray() {
        Scanner sc = new Scanner(System.in); 
        String[] input = new String[2];
//        String input = "";
//        if(sc.hasNext()) {
//          input = sc.nextLine(); 
//        } 
//        else {
//          System.out.println("Input was wrong. Please input again."); 
//          return scanString();
//        }
        return input;
    } 
}


