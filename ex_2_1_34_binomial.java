/*
//34.Binomial distribution. Write a function public static double binomial(int k, int N, double p) to compute the probability of obtaining exactly k heads in N biased coin flips (heads with probability p) using the formula
                     N! 
    f(k, N, p) = --------- (p^k) ((1-p)^(N-k)) 
                 k! (N-k)! 
Hint: To stave off overflow, compute x = ln f(N, k, p) and then return e^x. In main(), take N and p from the command line and check that the sum over all values of k between 0 and N is (approximately) 1. Also, compare every value computed with the normal approximation f(N, k, p) = ?(Np, Np(1-p))
(see Exercise 2.2.1).

*/

public class ex_2_1_34_binomial

{
        public static void main(String[]args)        
        {
				//test client
                int k = StdIn.readInt();
				int N = StdIn.readInt();
				double p = StdIn.readDouble();
				double binomial = binomial(k, N, p);
				
                System.out.println("Probability of obtaining exactly "+ k +" heads in "+N+" biased coin flips equals "+binomial+" .");
        }
        
        public static double binomial(int k, int N, double p)
        {
			double binomial = Math.log(factorial(N)*Math.pow(p,k)*Math.pow(1-p,N-k))/Math.log(factorial(k)*factorial(N-k));
			//binomial = Math.log(binomial);
			return Math.pow(Math.E,binomial);
        }
        
        //compute dot product
        public static int factorial(int N)
        {
			int factorial = 1;
			for (int i=N; i>1; i--) {
				factorial *= i;}
            return factorial;
        }        

}
