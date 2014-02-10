
/*
2.3.27. Sierpinski triangles. Write a recursive program to draw the Sierpinski gasket. As with Htree, use a command-line argument to control the depth of recursion. 

*/

public class ex_2_3_17_permutations {

    public static void main(String[] args) {
        
		
        int n = Integer.parseInt(args[0]); // length of words (window) n
		if (n>0) {
			int k = n; // dictionary, in this case equals n
			String[] alphabet = {"a", "b", "c", "d", "e", "f", "g"};
			//PrintArray("Alphabet: ",alphabet);
			String[] dictionary = new String[k];
			String[] window = new String[n];
			
			for (int m = 0; m<k; m++) {
				dictionary[m] = alphabet[m]; }//initializing dictionary
			
			for (int m = 0; m<n; m++) {
				window[m] = alphabet[0]; }//initializing window
									
			permutations(n, dictionary, window);
			
	/* 	    Dictionary: j = a;b;c;d;e window: i = 0;1;2;3;4

			Initial: aaaaa; 
			 */
	/* 	    for j:0..4 for i:0…4 0=b, print; 0=c…e.
				n==1:
				for (j=0,j<dictionary.length, j++) {
				window[0]=j;
				PrintArray(window);
				}
				n==2:
				
				
				} */	    
				
		}    
				
		
		else
			StdOut.print("Length of words should exceed 0.");

    }


    public static void permutations(int n, String[] dictionary, String[] window) {
    
	if (n==0) return;
						
	for (int j=0;j<dictionary.length;j++) {
		//PrintArray(" ", window);
		window[n-1]=dictionary[j];
		PrintArray(" ", window);	
		permutations(n-1,dictionary,window);
		//PrintArray(" ", window);
	}
	
	    
    }
    
	 public static void PrintArray(String ArrayName, String[] Array)
	  {
		   System.out.print(ArrayName);
		   for (int i=0; i<Array.length; i++) 
			System.out.print(Array[i] + " "); 
		   System.out.print("; ");
	  }  

}
