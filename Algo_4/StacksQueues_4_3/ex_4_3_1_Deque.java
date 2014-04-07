/*
4.3.8. Merging two sorted queues. Given two queues with strings in ascending order, move all of the strings to a third queue so that the third queues ends up with the strings in ascending order. 
*/

package JavaBook.Algo_4.StacksQueues_4_3;

public class ex_4_3_1_Deque { 

    public static void main(String[] args) {
        Deque<Integer> intsDeque = new Deque<Integer>();
        int TESTS_NUMBER = 5;
        int PUSHED_VALUE = 100;
        String result = "";
        
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