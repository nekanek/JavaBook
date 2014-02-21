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
    
    private static final int DEFAULT_LENGTH = 0;
    private static final int[] DEFAULT_VALUES = {};
    private static final int[] DEFAULT_INDEXES = {};
    
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
                BufferIndexes[index] = i;
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
        
        for (int i=0; (i<length) && (index < values.length); i++) {
            if (indexes[index] == i) {
                vector[i] = values[index];
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
            if (this.indexes[indexA] == i ) {
                if (b.indexes[indexB] == i) {
                    dotSum +=  this.values[indexA]*b.values[indexB];
                }
                if (indexA != this.values.length-1) {
                    indexA++;    
                }
            }
            if (b.indexes[indexB] == i) {
                if (indexB != b.values.length-1) {
                    indexB++;    
                }
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
        for (int i = 0; i < N; i++) {
            // if (indexA < (N-1)) {
            if (this.indexes[indexA] == i) {
                SumValues[indexSum] +=  this.values[indexA];
                SumIndexes[indexSum] =  i;
                if (indexA != this.values.length-1) {
                    indexA++;    
                }
                newSumValue = true;
            }
            if (b.indexes[indexB] == i) {
                SumValues[indexSum] +=  b.values[indexB];
                SumIndexes[indexSum] =  i;
                if (indexB != b.values.length-1) {
                    indexB++;    
                }
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
                SumSparseVectorLength = j+1;
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

    // return value in position i
    public int getValue(int i) {
        if (i > length - 1 || i < 0) {
            throw new RuntimeException("Illegal index.");
        }
        else {
            for (int j = 0; j < indexes.length; j++) {
                if (indexes[j] == i) {
                    return values[j];
                }
            }
            return 0;
        }
    }

    // return max position
    public int getLastIndex() {
            return indexes[indexes.length-1];
    }

    // add value to the end
    public SparseVector addValue(int i, int value) {
        if (i <= getLastIndex() || i < 0) {
            throw new RuntimeException("Illegal index.");
        }
        else {

            // create array with new length
            if (i < this.length) {
                int Length = values.length + 1;
                int[] Values = new int[Length];
                int[] Indexes = new int[Length];

                for (int j=0; j < values.length; j++) {
                    Values[j] = values[j];
                    Indexes[j] = indexes[j];        
                }
                
                Values[Length - 1] = value;
                Indexes[Length - 1] = i;
                        
                // finally create and return corresponding sparse vector        
                SparseVector addValue = new SparseVector(this.length + 1, Values, Indexes);
                return addValue;                
            }

            else {
                int Length = i + 1;
                int[] Values = new int[Length];

                int[] Recreated = new int[this.length];
                Recreated = this.RecreateVector();

                for (int j=0; j < this.length; j++) {
                    Values[j] = Recreated[j];       
                }
                
                Values[i] = value;
                        
                // finally create and return corresponding sparse vector        
                SparseVector addValue = new SparseVector(Values);
                return addValue;                
            }

        }
    }
    // test client
    public static void main(String[] args) {
        
        
        int[] a = {12,2,3,4,0,0,5,55,0,6,72,8,7,5,0,0,6,0,0,0};
        SparseVector x = new SparseVector(a);
        int[] b = {1,5,0,0,0,6,7,8,0,0,0,0,0,0,6,6,0,0,0,3};
        SparseVector y = new SparseVector(b);

        System.out.println("x is ");
        StdArrayIO.print(x.RecreateVector());
        System.out.println("Values of sparse vector x are: ");
        StdArrayIO.print(x.values);
        System.out.println("Indexes of sparse vector x are: ");
        StdArrayIO.print(x.indexes);
        System.out.println("Length of sparse vector x is: " + x.length());      
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

        System.out.println("Last index of x is " + x.getLastIndex());
        System.out.println("Value of x on position 0 is " + x.getValue(0));

        SparseVector z = x.addValue(19, 5);
        System.out.println("After adding 5 to position 19, x is ");
        StdArrayIO.print(z.RecreateVector());

        SparseVector w = x.addValue(22, 77);
        System.out.println("After adding 77 to position 22, x is ");
        StdArrayIO.print(w.RecreateVector());
    }
}
