package Queues;

import java.util.Queue; // Interface
import java.util.LinkedList;

public class Algorithms {

    // Generate Binary Numbers
    public static void printBinary(int n) {
        // First check input is valid
        if (n <= 0) {
            System.out.println();
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // the first binary number
        for (int i = 0; i < n; i++) { // iteration, start displaying binary numbers
            // print an item, and then print the item with the zero and then a one
            int current = queue.remove(); // take item off top of queue
            System.out.println(current);

            // save the two items that should follow later with a queue
            queue.add(current * 10); // appends a 0 to a number
            queue.add(current * 10 + 1); // appends a 1 to a number
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Queue is not concrete, need to instantiate an implementation of the interface in order to use it ]
        // In java, can choose between a linked list and priority queue

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(19);
        queue.add(20);

        int removedItem = queue.remove();
        System.out.println(removedItem);
        System.out.println(queue.remove());
        System.out.println(queue.peek()); // at the top of the queue, does not remove.

        while(!queue.isEmpty()) {
            // Iterate through the queue
            System.out.println(queue.remove());
        }

        System.out.println("Binary function");

        printBinary(3);
        printBinary(-5);
        printBinary(0);
        printBinary(2);
        printBinary(9);

        // Whenever there is a FIFO pattern, use a queue
    }
}
