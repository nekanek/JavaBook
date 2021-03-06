/* 21. Write a method multiply() that takes two square matrices of the same dimension as arguments and produces their product (another square matrix of that same dimension). Extra credit: Make your program work whenever the number of rows in the first matrix is equal to the number of columns in the second matrix.
*/

public class ex_2_1_21_multiply

{
        public static void main(String[]args) //void return type         
        {
                //read dimensions
                int N = StdIn.readInt();
                int M = StdIn.readInt();
                int L = StdIn.readInt();
                int K = StdIn.readInt();
        
                if (M == L)         {
						
						//double[][] Matrix0 = new double[N][M];
						
                        double[][] Matrix0 = ReadMatrix(N, M);
                        double[][] Matrix1 = ReadMatrix(L, K);
                        double[][] Matrix2 = ComputeDotProduct (N, M, K, Matrix0, Matrix1);
                        PrintArray("Multiplying matrix A =", N, M, Matrix0);
                        PrintArray("by matrix B =", L, K, Matrix1);
                        PrintArray("The dot product is C =", N, K, Matrix2);
                }        
                
                else {
                        System.out.println("Error: matrices have incompatible dimensions.");
                }

        }
        
        //read matrix
        public static double[][] ReadMatrix(int A, int B)
        {
                double[][] Input = new double[A][B];
                for (int a=0; a<A; a++) {
                for (int b=0; b<B; b++) {        
                        Input[a][b] = StdIn.readDouble(); }}
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
