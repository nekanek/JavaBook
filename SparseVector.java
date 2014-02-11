//13. Sparse vector. Create a data type for sparse vectors. Represent a sparse vector by an array of indices (of nonzeros) and a parallel array of the corresponding nonzero values. Assume the indices are in ascending order. Implement the dot product operation.

//interface SparseVector ?
//    class SpVint implements SparseVector?
//
//input: 5     1 2 3 4 5  0 56 67 87 567 

public class SparseVector {

    private final int length;         // ? length of the vector
    private int[] values;       // array of vector's components
    private int[] indexes;       // array of indexes of those components
    
    private static final int DEFAULT_LENGTH = 100;
    private static final int[] DEFAULT_VALUES = {100, 66, 567, 1};
    private static final int[] DEFAULT_INDEXES = {1, 6, 20, 99};
    
    // constructors:
    public SparseVector() {
        this(DEFAULT_LENGTH, DEFAULT_VALUES, DEFAULT_INDEXES);

    }   
    0
    public SparseVector(int length, int[] values, int[] indexes) {
        this.length = length;
        this.values = values;
        this.indexes = indexes;
    }

    
    
    
    
    
    
    
    
    
    
    // create a vector from an array
   public SparseVector(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++)
            this.data[i] = data[i];
    }

    public int dotProduct(SparseVector b) {
        
        // check if (this.length != b.length) throw new exception..
        
        int dot = 0;
        int indexA = 0;
        int indexB = 0;
        for (int i=0; i<this.length; i++) {
            if (this.indexes[indexA] == i) {
                indexA++;
                if (b.indexes[indexB] == i) {
                    indexB++;
                    dot += this.values[indexA-1]*b.values[indexB-1];
                }
            }
        }
    }
   
    // + check whether right angle? (if dotP=0)
   
    // return the length of the vector
    public int length() {
        return N;
    }

    // return the inner product of this Vector a and b
    public double dot(Vector that) {
        if (this.N != that.N) throw new RuntimeException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }
   
   
    // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    }
}
