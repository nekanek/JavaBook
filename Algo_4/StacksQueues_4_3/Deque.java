/* 4.3.1. Deque A double-ended queue or deque (pronounced deck) is a combination of a stack and and a queue. It stores a parameterized collection of items and supports the following API: ... Write a data type Deque.java that implements the deque API using a singly linked list.


*/ 
package JavaBook.Algo_4.StacksQueues_4_3;

public class Deque<Item> {

    private int N;         // number of elements on deque
    private Node first;    
    private Node last;
    
    Deque() {
        first = null;
        last = null;
        N = 0;
    }
    
    private class Node {
        private Item item;
        private Node next;
        Node() {
            this(null);
        }
        Node (Item item) {
            this.item = item;
            this.next = null;
        }
    }

    boolean isEmpty() {
        return N == 0;
    }

    // add to the end
    void enqueue(Item item) {
        Node input = new Node(item);
        if (this.N == 0) {
            this.first = input;
            this.last = input;
        }
        else {
            this.last.next = input;
            this.last = input;
        }
        this.N++;        
    }
    
    void push(Item item) {
        Node input = new Node(item);
        if (this.N == 0) {
            this.first = input;
            this.last = input;
        }
        else {
            input.next = this.first;
            this.first = input;
        }
        this.N++;          
    }
    
    public Item pop() {

        Node output = first;
        first = first.next;
        this.N--;
        return output.item;
    }
    
    // remove from the end
    public Item dequeue() {
        Node output = last;
        if (N == 0) {
            System.out.print("Trying to dequeue from empty deque. Returning null.");
            return null;
        }
        else if (N == 1) {
            this.last = null;
            this.first = null;
        }
        else {
            Node lastNode = first;
            while (lastNode.next != last) {
                lastNode = lastNode.next;
            }
            this.last = lastNode;
        }
        this.N--;
        return output.item;
    }
    
}
