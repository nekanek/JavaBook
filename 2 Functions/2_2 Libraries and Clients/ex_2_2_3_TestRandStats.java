/*
3. Write a test client for both StdStats and StdRandom that checks that all of the methods in both libraries operate as expected. Take a command-line parameter N, generate N random numbers using each of the methods in StdRandom, and print out their statistics. Extra credit : Defend the results that you get by comparing them to those that are to be expected from mathematical analysis.
*/


public class ex_2_2_3_TestRandStats

{
   public static void main(String[]args)        
     {
		//test client
		int N = Integer.parseInt(args[0]);
		double [] Uniform = new double[N];
		boolean [] Bernoulli = new boolean[N];
		double [] Gaussian = new double[N];
		int [] Geometric = new int[N];
		int [] Poisson = new int[N];
		double [] Pareto = new double[N];
		double [] Cauchy = new double[N];
		
		for (int i=0; i<N; i++) {
			Uniform[i] = StdRandom.uniform();
			Bernoulli[i] = StdRandom.bernoulli(0.5);
			Gaussian[i] = StdRandom.gaussian();
			Geometric[i] = StdRandom.geometric(0.5);
			Poisson[i] = StdRandom.poisson(0.5);
			Pareto[i] = StdRandom.pareto(0.5); 
			Cauchy[i] = StdRandom.cauchy();
		}
		
	 	double UniformMean = StdStats.mean (Uniform);
	 	double GaussianMean = StdStats.mean(Gaussian);		
	 	double GaussianStdDev = StdStats.stddev(Gaussian);
	 	double CauchyStdDev = StdStats.stddev(Cauchy);
	 	double PoissonVar = StdStats.var(Poisson);
	 	double ParetoVar = StdStats.var (Pareto);
		
		StdStats.plotBars(Pareto);
		

		System.out.println("UniformMean is: "+ UniformMean +", GaussianMean is: "+GaussianMean+"."); 
		System.out.println("Poisson variance is: "+ PoissonVar +", Pareto variance is: "+ParetoVar+".");  
		System.out.println("Gaussian standart deviation is: "+ GaussianStdDev +", Cauchy standart deviation is: "+CauchyStdDev+"."); 

        }
        
}
