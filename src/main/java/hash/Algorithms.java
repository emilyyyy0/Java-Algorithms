package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Algorithms {
    public static void main(String[] args) {

        Employee employee = new Employee("Robby", 3827,
                "Technology");
        Employee employee2 = new Employee("Bobby", 9612,
                "Marketing");
        Employee employee3 = new Employee("Sally", 2519,
                "Sales");

        HashMap<Integer, Employee> employeesById = new HashMap<>();
        employeesById.put(employee.id, employee);
        employeesById.put(employee2.id, employee2);
        employeesById.put(employee3.id, employee3);

        Employee retrievedEmployee = employeesById.get(9612); // get value by key, if not found, will return null

        if(retrievedEmployee != null) {
            System.out.println(retrievedEmployee.name + " : " + retrievedEmployee.department);
        }

        // working with data set where each item is unique
        HashSet<String> productCodes = new HashSet<>();
        productCodes.add("2T26B");
        productCodes.add("9K42P");
        productCodes.add("H5J781");

        // can check whether a given code is valid using the contains method
        System.out.println(productCodes.contains("H5J781"));
        System.out.println(productCodes.contains("Hwef"));

        // FIND MISSING ELEMENTS FUNCTION
        System.out.println();
        System.out.println("MISSING ELEMENTS FUNCTION ");
        findMissingElements(new int[]{1,2,3,4}, new int[] {1,3}).forEach(System.out::println);

        System.out.println();

        findMissingElements(new int[] {8, 0, 1, 7, 3},
                new int[]{5, 7, 8, 0, 2}).forEach(System.out::println);

        // DISPLAY FREQUENCY OF EACH ELEMENT FUNCTION
        System.out.println();
        System.out.println("DISPLAY FREQUENCY OF EACH ELEMENT FUNCTION ");
        displayFreqOfEachElement(new int[] {4, 1, 3, 4, 5, 8, 3, 4,
                4, 4, 4, 6, 5});


        // CHECK IF LINKED LIST HAS A CYCLE
        System.out.println();
        System.out.println("CHECK IF LINKED LIST HAS A CYCLE");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;

        System.out.println(hasCycle(head)); 


    }

    public static List<Integer> findMissingElements(int[] first, int[] second ) {
        List<Integer> missingElements = new ArrayList<>();
        // In order to find out whether an element is missing from the second array, we need to know what
        // items are in the second array, then we can cross check them with the first array.
        HashSet<Integer> hashSet = new HashSet<>();

        // put all items in the second array in the hash map
        for (int x : second) {
            hashSet.add(x);
        }

        // iterate through the first array
        for (int x : first) {
            if (!hashSet.contains(x)) {
                missingElements.add(x);
            }
        }
        return missingElements;

    }

    public static void displayFreqOfEachElement(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) {
            if (!freqMap.containsKey(x)) {
                freqMap.put(x, 1);
            } else {
                freqMap.put(x, freqMap.get(x) + 1); // overwrite with incremented value
            }
        }

        // now display info to user
        freqMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }


    // Return true or false depending on if there's a
    // cycle in the Linked List
    static boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        // iterate through linked list, everytime we see a new node
        // check if its in the hash set

        ListNode current = head;

        while(current != null) {
            if (hashSet.contains(current)) {
                return true;
            }
            hashSet.add(current); // to keep track of it
            current = current.next;

        }

        return false;
    }
    // With hashSet we were able to check in constant time
    // ALgorithm runs in linear time: O(n)
    // Space complexity: O(n)
    // check every node

}
