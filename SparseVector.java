//13. Sparse vector. Create a data type for sparse vectors. Represent a sparse vector by an array of indices (of nonzeros) and a parallel array of the corresponding nonzero values. Assume the indices are in ascending order. Implement the dot product operation.

//interface SparseVector ?
//    class SpVint implements SparseVector?
//
//input: 5     1 2 3 4 5  0 56 67 87 567 

public class SparseVector {

    private final int length;         // ? length of the vector
    private int[] values;           // array of vector's components
    private int[] indexes;       // array of indexes of corresponding components
    
    private static final int DEFAULT_LENGTH = 100;
    private static final int[] DEFAULT_VALUES = {100, 66, 567, 1};
    private static final int[] DEFAULT_INDEXES = {1, 6, 20, 99};
    
    // constructors:
    public SparseVector() {
        this(DEFAULT_LENGTH, DEFAULT_VALUES, DEFAULT_INDEXES);
    }   
    
    public SparseVector(int length, int[] values, int[] indexes) {
        this.length = length;
        this.values = values;
        this.indexes = indexes;
    
    }

    // create sparse vector from an array
    public SparseVector(int[] data) {
        N = data.length;
        // defensive copy so that client can't alter our copy of data[]
        this.values = new int[N];
        this.indexes = new int[N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] != 0) {
                this.values[index] = data[i];
                this.index[index] = i+1;
                index++;
            }
        }
    }

    
    // recreate a vector from sparse vector
    public int[] RecreateVector() {
        int[] vector = new int[length];
        int index = 0;
        
        for (int i=0; i<length; i++) {
            if (indexes[index] == i) {
                vector[i] = values[i];
                index++;
            }
        }
        return vector;
    }

    
    public int dotProduct(SparseVector b) {
        
        if (this.length != b.length) throw new RuntimeException("Dimensions don't agree");

        int dotSum = 0;
        int indexA = 0;
        int indexB = 0;
        for (int i=0; i<this.length; i++) {
            if (this.indexes[indexA] == i) {
                indexA++;
                if (b.indexes[indexB] == i) {
                    indexB++;
                    dot +=  this.values[indexA-1]*b.values[indexB-1];
                }
            }
        }
    }

    public int Plus(SparseVector b) {
        int N = this.length;
        if (N != b.length) throw new RuntimeException("Dimensions don't agree");
        
        int BufferLength = this.values.length+b.values.length;
        int[] SumValues = new int[BufferLength];
        int[] SumIndexes = new int[BufferLength];
        SumIndexes[indexSum] =  i;

        
        int indexA = 0;
        int indexB = 0;
        int indexSum = 0;
        boolean newSumValue = false;
        
        
        for (int i = 0; i < N; i++) {
            if (this.indexes[indexA] == i) {
                SumValues[indexSum] +=  this.values[indexA];
                SumIndexes[indexSum] =  i;
                indexA++;
                newSumValue = true;
            }
            if (b.indexes[indexB] == i) {
                SumValues[indexSum] +=  b.values[indexB];
                SumIndexes[indexSum] =  i;
                indexB++;
                newSumValue = true;
            }
            if (newSumValue) {
                indexSum++;
                newSumValue = false;
            }
        }
        
        for (j=BufferLength-1; j>-1; j--) {
            if (SumValues[j] != 0) {
                int SumSparseVectorLength = j+1;
            }
        }
        
        
        SparseVector Sum = Sparsevector(SumSparseVectorLength, new int[N], new int[N]);
        return Sum;
    }
    
    // + check whether right angle? (if dotP=0)
   
    // return the length of the vector
    public int length() {
        return length;
    }


   
   
    // test client
    public static void main(String[] args) {
        
        SparseVector x = new SparseVector();
        SparseVector y = new SparseVector(0,5,0,0,0,6,7,8,0,0,0,0,0,0,6);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    }
}
