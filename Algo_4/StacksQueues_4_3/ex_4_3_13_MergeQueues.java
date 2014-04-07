/*
4.3.8. Merging two sorted queues. Given two queues with strings in ascending order, move all of the strings to a third queue so that the third queues ends up with the strings in ascending order. 
*/

package JavaBook.Algo_4.StacksQueues_4_3;

public class ex_4_3_13_MergeQueues { 
    
    private class Node<Item> {
        private Item item;
        private Node next;
    }
    
    private static Queue<Item> mergeQueues (Queue<Item> queue1, Queue<Item> queue2) {
        Queue<Item> output = new Queue<Item>;
        output.first = queue1.first;
                
        while ( (!queue1.isEmpty()) && (!queue2.isEmpty()) ) {
            if (queue1.peek() == queue2.peek()) {
                output
            }
            output
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> intsQueue1 = new Queue<Integer>();
        Queue<Integer> intsQueue2 = new Queue<Integer>();
        Queue<Integer> resultsQueue = new Queue<Integer>();
        int[] TESTS_VALUES1 = {1, 2, 4, 5, 5, 5, 10, 89};
        int[] TESTS_VALUES2 = {5, 5, 6, 7, 7, 8, 67, 100};

        
        for (int i = 0; i < TESTS_NUMBER; i++) {
            System.out.println("..enqueing " + i);
            intsDeque.enqueue(Integer.valueOf(i));
            System.out.println("..pushing " + PUSHED_VALUE);
            intsDeque.push(Integer.valueOf(PUSHED_VALUE));
            result = PUSHED_VALUE + " " + result + " " + i;
        }
        // int N = intsDeque.N;
        System.out.println("Resulting deque: " + result);
        System.out.println("Popping:");
        for (int i = 0; i < TESTS_NUMBER+1; i++) {
            System.out.println(intsDeque.pop());
        }
        System.out.println("..dequeing:");
        while (!intsDeque.isEmpty()) {
            System.out.println(intsDeque.dequeue());
        }        
               
        
    } 
    
}