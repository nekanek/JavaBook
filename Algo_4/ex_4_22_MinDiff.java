// 22. Closest pair. Given an array of N real numbers, write a static method to find in linearithmic time the pair of integers that are closest in value. 
package JavaBook.Algo_4;

import java.util.Scanner;


public class ex_4_22_MinDiff {

    public static void main(String[] args) {
        
        double[] input = scanDoubleArray();
        if (input.length < 2) {
            System.out.println("Less than 2 values inputed, filed to find pair.");
        }
        else {
            Merge.sort(input);
            double MinDiff = Double.MAX_VALUE;
            double CurrentDiff;
            double[] result = new double[2];
            
            for(int i = 1; i < input.length; i++) {
                CurrentDiff = Math.abs(input[i] - input[i-1]);
                if (CurrentDiff == 0.0) {
                    result[0] = input[i];
                    MinDiff = 0.0;
                    break;
                }
                else if (CurrentDiff < MinDiff) {
                    result[0] = input[i-1];
                    result[1] = input[i];
                    MinDiff = CurrentDiff;
                }
            }
            
            if (MinDiff == 0.0) {
                System.out.println("There are same values " + result[0] + " (minimum difference is 0.0).");
            }
            else {
                System.out.println("Minimum difference of " + MinDiff + "is between values " + result[0] + " and " + result[1]);
            }    
        }
    }    
    
    public static double[] scanDoubleArray() {
        Scanner sc = new Scanner(System.in); 
        int n;
        if(sc.hasNextInt()) {
          n = sc.nextInt(); 
        } 
        else {
          System.out.println("Please, enter length of array as first element (int).");
          return scanDoubleArray();
        }
        
        double[] input = new double[n];
        
        for (int i = 0; i < n; i++) {
            if(sc.hasNextDouble()) {
              input[i] = sc.nextDouble(); 
            } 
            else {
              System.out.println("Input was wrong. Please enter real numbers.");
              return scanDoubleArray();
            }
        }    
        return input;
    }
}


