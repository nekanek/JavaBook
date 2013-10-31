/*
15. Sicherman dice. Suppose that you have two six-sided dice, one with faces labeled 1, 3, 4, 5, 6, and 8 and the other with faces labeled 1, 2, 2, 3, 3, and 4. Compare the probabilities of occurrence of each of the values of the sum of the dice with those for a standard pair of dice. Use StdRandom and StdStats.
Solution: dice with these properties are called Sicherman dice: they produce sums with the same frequency as regular dice (2 with probability 1/36, 3 with probability 2/36, and so on). 
*/


public class ex_2_2_15_Sicherman

{
   public static void main(String[]args)        
     {
		//test client
		int N = 1000;
		int SumSicher;
		int SumStandart;
		double [] SicherDice1 = {1,3,4,5,6,8};
		double [] SicherDice2 = {1,2,2,3,3,4};
		double [] ProbSicher = new double[13];
		double [] ProbStandart = new double[13];
    
		for (int i=0; i<N; i++) {
			SumSicher = SicherDice1[StdRandom.uniform(6)]+SicherDice2[StdRandom.uniform(6)];
			SumStandart = StdRandom.uniform(1,7)+StdRandom.uniform(1,7);
			
			ProbSicher[SumSicher] += 1/n;
			ProbStandart [SumStandart] += 1/n;
			
		}
	 	double SicherMean = StdStats.mean (ProbSicher);
	 	double StandartMean = StdStats.mean (ProbStandart);
		
		
		PrintArray("Sicher probabilities: ", ProbSicher);
		PrintArray("Standart probabilities: ", ProbStandart); 
        }
        
  
 public static void PrintArray(String ArrayName, double[] Array)
  {
	   System.out.println(ArrayName);
	   for (int i=2; i<Array.length; i++) 
		System.out.print(Array[i] + " "); 
	   System.out.println();
  }  
}
