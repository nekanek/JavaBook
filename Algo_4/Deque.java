// 4.3.1. Deque A double-ended queue or deque (pronounced deck) is a combination of a stack and and a queue. It stores a parameterized collection of items and supports the following API: ... Write a data type Deque.java that implements the deque API using a singly linked list. 

public class Deque<Item> {

    private int N;         // number of elements on deque
    private Node first;    
    private Node last;
    private Node secondLast;     
    
    Deque() {
        first = null;
        last = null;
        // secondLast = null;
        N = 0;
    }
    
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
        
        Node() {
            this(null);
        }
        Node (Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    boolean isEmpty() {
        return N == 0;
    }
    
    // add to the end
    void equeue(Item item) {
        Node input = new Node(item);
        if (this.N == 0) {
            this.first = input;
            this.last = input;
            // this.secondLast = null;
        }
        else {
            this.last.next = input;
            this.last.previous = last
            //this.secondLast = last;
            this.last = input;
        }
        this.N++;        
    }
    
    void push(Item item) {
        Node input = new Node(item);
        if (this.N == 0) {
            this.first = input;
            this.last = input;
            this.secondLast = null;
        }
        else {
            input.next = first;
            this.first = input;
            if (N == 1) {
                this.secondLast = first;
            }
        }
        this.N++;          
    }
    
    Item pop() {
        Node output = first;
        first = first.next;
        if (N == 2){
            this.secondLast = null;
        }
        this.N--;
        return output.item;
    }
    
    // remove from the end
    Item dequeue() {
        Node output = last;
        if (N == 0) {
            System.out.print("Trying to dequeue from empty deque. Returning null.");
        }
        else if (N == 1) {
            this.last = null;
            this.first = null;
        }
        else if (N == 2){
            this.last = secondLast;
            this.secondLast = null;
        }
        else {
            
        }
        first = first.next;
        this.N--;
        if N > 1
        return output.item;
    }
    
    
    
    
}
