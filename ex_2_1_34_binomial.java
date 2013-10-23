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
                int x = StdIn.readInt();
				int N = StdIn.readInt();
				Double HornerExp = Exp(x, N);
				Double MathExp = Math.exp(x);
				
                System.out.println("e^"+x+"According to Math library equals "+ MathExp+", accroding to Horner's method it equals "+HornerExp+".");


        }
        
        //read matrix
        public static double binomial(int k, int N, double p)
        {
			binomial = Math.ln((factorial(N)*Math.pow(p,k)*Math.pow(1-p,N-k))/(factorial(k)*factorial(N-k)));
			return Math.pow(Math.Exp,binomial);
        }
        
        //compute dot product
        public static int factorial(int N)
        {
			int factorial = 1;
			for (int i=N; i>1; i--) {
				factorial *= i;
                return factorial;
        }        
                        
                        
        //print array
        public static void PrintArray(String ArrayName, int V, int W, double[][] A)
        {
                System.out.println(ArrayName);
                for (int i=0; i<V; i++) {
                        for (int j=0; j<W; j++)        {
                                System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }
}
