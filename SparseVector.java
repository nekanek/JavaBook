//13. Sparse vector. Create a data type for sparse vectors. Represent a sparse vector by an array of indices (of nonzeros) and a parallel array of the corresponding nonzero values. Assume the indices are in ascending order. Implement the dot product operation.

//interface SparseVector ?
//    class SpVint implements SparseVector?
//
//input: 5     1 2 3 4 5  0 56 67 87 567 

package JavaBook;
import JavaBook.stanfStd.*;

public class SparseVector {

    private final int length;         // ? length of the vector
    private int[] values;           // array of vector's components
    private int[] indexes;       // array of indexes of corresponding components
    
    private static final int DEFAULT_LENGTH = 20;
    private static final int[] DEFAULT_VALUES = {100, 66, 567, 1};
    private static final int[] DEFAULT_INDEXES = {1, 6, 15, 20};
    
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
        this.length = data.length;
        // sparse vectors with zeros in the end
        int[] BufferValues = new int[data.length];
        int[] BufferIndexes = new int[data.length];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                BufferValues[index] = data[i];
                BufferIndexes[index] = i+1;
                index++;
            }
        }
        
        // getting rid of zeros in the end
        // determine where array ends
        int SparseVectorLength = data.length;
        for (int j=data.length-1; BufferValues[j] == 0; j--) {
            SparseVectorLength = j;        
        }
        
        // create arrays with new length, no zeros
        int[] BufferValuesShort = new int[SparseVectorLength];
        int[] BufferIndexesShort = new int[SparseVectorLength];
        for (int j=0; j < SparseVectorLength; j++) {
            BufferValuesShort[j] = BufferValues[j];
            BufferIndexesShort[j] = BufferIndexes[j];        
        }       
        this.values = BufferValuesShort;
        this.indexes = BufferIndexesShort;
    }

    
    // recreate a vector from sparse vector
    public int[] RecreateVector() {
        int[] vector = new int[length];
        int index = 0;
        
        for (int i=1; (i<=length) && (index < values.length); i++) {
            if (indexes[index] == i) {
                vector[i-1] = values[index];
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
        for (int i=1; i<=this.length; i++) {
            if (this.indexes[indexA] == i) {
                if (b.indexes[indexB] == i) {
                    dotSum +=  this.values[indexA]*b.values[indexB];
                }
                indexA++;
            }
            if (b.indexes[indexB] == i) {
                indexB++;
            }
        }
        return dotSum;
    }

    public SparseVector Plus(SparseVector b) {
        int N = this.length;
        if (N != b.length) throw new RuntimeException("Dimensions don't agree");
        
        int BufferLength = this.values.length+b.values.length; // max posiible length of sparse vector summing array
        int[] SumValues = new int[BufferLength];
        int[] SumIndexes = new int[BufferLength];
                
        int indexA = 0;
        int indexB = 0;
        int indexSum = 0;
        boolean newSumValue = false;
        
        // creating array with summed values - zeros in the end
        for (int i = 1; i <= N; i++) {
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
            // determines whether we added anything to the current position of the sum vector
            if (newSumValue) {
                indexSum++;
                newSumValue = false;
            }
        }
        
        // determine where summed array ends
        int SumSparseVectorLength = BufferLength;
        for (int j=BufferLength-1; SumValues[j] == 0; j--) {
                SumSparseVectorLength = j;
        }
        
        // create arrays with new length, no zeros
        int[] Values = new int[SumSparseVectorLength];
        int[] Indexes = new int[SumSparseVectorLength];
        for (int j=0; j < SumSparseVectorLength; j++) {
            Values[j] = SumValues[j];
            Indexes[j] = SumIndexes[j];        
        }
                
        // finally create and return corresponding sparse vector        
        SparseVector Sum = new SparseVector(SumSparseVectorLength, Values, Indexes);
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
        int[] a = {1,5,0,0,0,6,7,8,0,0,0,0,0,0,6,6,0,0,0,3};
        SparseVector y = new SparseVector(a);

        System.out.println("x is ");
        StdArrayIO.print(x.RecreateVector());
        System.out.println("Values of sparse vector x are: ");
        StdArrayIO.print(x.values);
        System.out.println("Indexes of sparse vector x are: ");
        StdArrayIO.print(x.indexes);
        
        System.out.println("y is ");
        StdArrayIO.print(y.RecreateVector());
        System.out.println("Values of sparse vector y are: ");
        StdArrayIO.print(y.values);
        System.out.println("Indexes of sparse vector y are: ");
        StdArrayIO.print(y.indexes);
        
        
        System.out.println("x + y    =  ");
        StdArrayIO.print(x.Plus(y).values);
        System.out.println(" on places: ");
        StdArrayIO.print(x.Plus(y).indexes);
        System.out.println("Length of x is =  " + x.length());
        System.out.println("Dot product of x and y equals " + x.dotProduct(y));
    }
}
