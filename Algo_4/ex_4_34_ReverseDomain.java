// 34 Reverse domain. Write a program to read in a list of domain names from standard input, and print the reverse domain names in sorted order. For example, the reverse domain of cs.princeton.edu is edu.princeton.cs. This computation is useful for web log analysis. To do so, create a data type Domain.java that implements the Comparable interface, using reverse domain name order. 
package JavaBook.Algo_4;

import java.util.Scanner;


public class ex_4_34_ReverseDomain {

    public static void main(String[] args) {
        
 
    }    

    public static String[] scanStringArray() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Please, enter length of array as first element (int).");
        if(sc.hasNextInt()) {
          n = sc.nextInt(); 
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


