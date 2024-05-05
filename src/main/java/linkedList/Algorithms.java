package linkedList;

import java.util.LinkedList;

public class Algorithms {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Sally");
        list.add("Becky");
        list.add("Nick");
        list.add("Jack");
        list.add("Rachel");

        System.out.println(list.contains("Becky"));
        System.out.println(list.size());
        list.removeFirst();
//        for(String item: list) {
//            System.out.println(item + "->");
//        }

        list.forEach(x -> System.out.print(x + "->"));
        System.out.println();

        // Custom linked list
        CustomLinkedList linkedList = new CustomLinkedList();

        Node firstNode = new Node(3);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(5);
        Node fourthNode = new Node(6);

        linkedList.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        linkedList.displayContents();
        linkedList.deleteBackHalf();
        linkedList.displayContents();
    }
}
