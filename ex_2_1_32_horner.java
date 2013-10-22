/*
/32.Horner's method. Write a class Horner.java with a method double eval(double x, double[] p) that evaluates the polynomial p(x) whose coefficients are the entries in p[]:
p0 + p1x1 + p2x2 + ... + pN-2xN-2 + pN-1xN-1 
Use Horner's method, an efficient way to perform the computations that is suggested by the following parenthesization:
p0 + x (p1 + x( p2 + ... + x(pN-2 + xpN-1))...)
Write a test client with a static method exp() that uses Horner.eval() to compute an approximation to e^x, using the first N terms of the Taylor series expansion e^x = 1 + x + x ^2/2! + x ^3/3! + .... Include code to check your answer against that computed by Math.exp(). 
*/

public class ex_2_1_32_horner

{
        public static void main(String[]args)        
        {
				//test client
                int N = StdIn.readInt();
						
                        double[][] Matrix0 = ReadMatrix(N, M);

                        double[][] Matrix2 = ComputeDotProduct (N, M, K, Matrix0, Matrix1);
                        PrintArray("The dot product is C =", N, K, Matrix2);

                        System.out.println("Error: matrices have incompatible dimensions.");


        }
        
        //read matrix
        public static double eval(double x, double[] p)
        {
                
                for (int a=0; a<A; a++) {
                       
                        Input[a][b] = StdIn.readDouble(); }
                return Input;
        }
        
        //compute dot product
        public static double[][] ComputeDotProduct(int N, int M, int K, double[][] A, double[][] B)
        {
                double[][] Product = new double[N][K];
                for (int i=0; i<N; i++) {
                for (int j=0; j<K; j++)        {
                for (int p=0; p<M; p++)        {
                        Product[i][j] += (A[i][p] * B[p][j]); }}}
                return Product;
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
