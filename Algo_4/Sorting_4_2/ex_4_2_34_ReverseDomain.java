// 34 Reverse domain. Write a program to read in a list of domain names from standard input, and print the reverse domain names in sorted order. For example, the reverse domain of cs.princeton.edu is edu.princeton.cs. This computation is useful for web log analysis. To do so, create a data type Domain.java that implements the Comparable interface, using reverse domain name order. 
package JavaBook.Algo_4.Sorting_4_2;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ex_4_2_34_ReverseDomain {
    
    

    public static void main(String[] args) {
        String[] input = scanStringArrayFromFile();
        Domain[] domains = new Domain[input.length];
        for (int i = 0; i < domains.length; i++) {
            domains[i] = new Domain(input[i]);
        }
        Merge.sort(domains);
        for (int i = 0; i < domains.length; i++) {
            System.out.print(i + ". ");
            domains[i].printReversed();
        }
        

    }    

    public static String[] scanStringArrayFromFile() {
        String filename = "./JavaBook/Algo_4/Sorting_4_2/domains.txt";
        // System.out.println(System.getProperty("user.dir"));
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            sc.nextLine();
            String[] input = new String[n];

            for (int i = 0; i < n; i++) {
                input[i] = sc.nextLine(); 
            }
            return input;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return new String[0];
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
        sc.nextLine();
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





