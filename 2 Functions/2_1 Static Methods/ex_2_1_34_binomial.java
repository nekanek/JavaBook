/*

//34.Binomial distribution. Write a function public static double binomial(int k, int N, double p) to compute the probability of obtaining exactly k heads in N biased coin flips (heads with probability p) using the formula

                     N! 

    f(k, N, p) = --------- (p^k) ((1-p)^(N-k)) 

                 k! (N-k)! 

Hint: To stave off overflow, compute x = ln f(N, k, p) and then return e^x. In main(), take N and p from the command line and check that the sum over all values of k between 0 and N is (approximately) 1. Also, compare every value computed with the normal approximation f(N, k, p) = ?(Np, Np(1-p))

(see Exercise 2.2.1).

*/

// My text formatting for this task was blows away. I hope, this was some technical issue and not your intention;)

// test push

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

      	  double a = Math.log(factorial(N));
	  System.out.println("a "+a +" .");
	  double b =Math.log(Math.pow(p,k));
	  System.out.println("b "+b +" .");
	  double c =Math.log(Math.pow(1-p,N-k));
	  System.out.println("c "+c +" .");
	  double d =Math.log(factorial(k));
	  System.out.println("d "+d +" .");
	  double e =Math.log(factorial(N-k));
	  System.out.println("e "+e +" .");
	  double binomial = Math.pow(Math.E,(a+ b +c - d - e));
	  
	  //Math.pow(Math.E,(Math.log(factorial(N)) + Math.log(Math.pow(p,k)) + Math.log(Math.pow(1-p,N-k)) - Math.log(factorial(k)) - Math.log(factorial(N-k))));

      //binomial = Math.log(binomial);

      //return Math.pow(Math.E,binomial);
	  return binomial;
}

         

        //compute dot product

        public static int factorial(int N)

        {

      		int factorial = 1;

      		for (int i=N; i>1; i--) {

        		factorial *= i;
		}

            	return factorial;

        }        



 }
