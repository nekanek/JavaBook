/*
4.3.7. Ring buffer. A ring buffer or circular queue is a FIFO data structure of a fixed size N. It is useful for transferring data between asynchronous processes or storing log files. When the buffer is empty, the consumer waits until data is deposited; when the buffer is full, the producer waits to deposit data. A ring buffer has the following methods: 
isEmpty(), isFull(), enqueue(), and dequeue(). 
Write an generic data type RingBuffer using an array (with circular wrap-around for efficiency). 
*/

package JavaBook.Algo_4.StacksQueues_4_3;

public class RingBuffer {

    private int[] values;
    private int last;
    
    public RingBuffer(int size) {
        this.values = new int[size];
        this.last = -1;
    }
    public RingBuffer(int[] _values) {
        this(_values, _values.length);
    }    
    
    public RingBuffer(int[] _values, int size) {
        this.values = new int[size];
        for (int i = 0; i < _values.length; i++) {
            this.values[i] = _values[i]; 
        }
        this.last = _values.length -1;
    }
    
    
    public boolean isEmpty() {
        return (last == -1);
    }
    public boolean isFull() {
        return last == (values.length - 1);
    }
    
    public void enqueue(int item){
        if (this.isFull()) {
            System.out.println("Failed to add item, buffer is full.");
        }
        else {
            values[++last] = item;
        }
    }
    
    public int dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
            //return null;
        }
        else {
            return values[last--];
        }
    }
}