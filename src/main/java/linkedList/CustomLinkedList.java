package linkedList;

public class CustomLinkedList {
    Node head;

    // Iterate
    public void displayContents() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + "->" );
            current = current.next;
        }
        System.out.println();
    }

    public void deleteBackHalf() {

        // list has no elements or only one element
        if (head == null || head.next == null) {
            head = null; // keeps list empty or remove single element
        }

        // Iterate through the linked list, if we reach middle node, set its next reference equal to null
        Node slow = head;
        Node fast = head;
        // two trackers, fast pointer moves twice as fast as slow
        // when fast pointer reaches end of list, the slow pointer will be at the middle element
        Node prev = null; // runs just behind slow node

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next; // don't need to check if null because it is behind the fast node
        }

        // to delete the back half, we want to access the node just before the slow node.
        // We can set its next pointer to null. This deletes the middle node as well as everything after it
        prev.next = null;

    }

    public int sum(Node head) {
        int sum = 0;
        Node current = head;

        while(current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

}
