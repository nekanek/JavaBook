/*
4.3.8. Merging two sorted queues. Given two queues with strings in ascending order, move all of the strings to a third queue so that the third queues ends up with the strings in ascending order. 
*/

package JavaBook.Algo_4.StacksQueues_4_3;

import java.util.Arrays;

public class ex_4_3_13_MergeQueues { 

    // private static Queue<Item> mergeQueues (Queue<Item> queue1, Queue<Item> queue2) {
    private static Queue<String> mergeQueues (Queue<String> q1, Queue<String> q2) {
        Queue<String> result = new Queue<String>();
        //String a = "";
        //a.compareToIgnoreCase(a)
        int compare;
        while ( (!q1.isEmpty()) && (!q2.isEmpty()) ) {
            compare = q1.peek().compareToIgnoreCase(q2.peek());
            if (compare == 0) {
                result.enqueue(q1.dequeue());
                result.enqueue(q2.dequeue());
            }
            else if (compare < 0) {
                result.enqueue(q1.dequeue());
            }
            else if (compare > 0) {
                result.enqueue(q2.dequeue());
            }
        }
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                result.enqueue(q1.dequeue());
            }
        }
        else if (!q2.isEmpty()) {
            while (!q2.isEmpty()) {
                result.enqueue(q2.dequeue());
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Queue<String> intsQueue1 = new Queue<String>();
        Queue<String> intsQueue2 = new Queue<String>();
        Queue<String> resultsQueue = new Queue<String>();
        
        String[] TESTS_VALUES1 = {"a", "b", "d", "e", "e", "e", "j", "o"};
        System.out.println("Merging queue #1: ");
        System.out.println(Arrays.toString(TESTS_VALUES1));
        for (int i = 0; i < TESTS_VALUES1.length; i++) {
            intsQueue1.enqueue(TESTS_VALUES1[i]);
        }       
        
        String[] TESTS_VALUES2 = {"e", "e", "f", "g", "g", "i", "n", "q"};
        System.out.println("..with queue #2: ");
        System.out.println(Arrays.toString(TESTS_VALUES2));
        for (String a : TESTS_VALUES2) {
            intsQueue2.enqueue(a);
        } 
        
        resultsQueue = mergeQueues(intsQueue1, intsQueue2);
        System.out.println("Resulting queue:");
        while (!resultsQueue.isEmpty()) {
            System.out.print(resultsQueue.dequeue() + " ");
        }        
               
        
    } 
    
}