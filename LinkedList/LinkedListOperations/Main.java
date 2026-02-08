package LinkedList.LinkedListOperations;

public class Main {
    public static Node arrayToLinkedList(int[] arr) {
        int size = arr.length;
        if (size == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < size; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static int lengthOfLinkedList(Node head) {
        int length = 0;
        Node current = head;

        while(current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public static boolean searchElement(Node head, int target) {
        Node current = head;

        while(current != null) {
            if (current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int searchElement = 3;

        Node head = arrayToLinkedList(arr);
        printLinkedList(head);

        System.out.println("Length of linked list: " + lengthOfLinkedList(head));
        System.out.println("Search element found? : " + searchElement(head, searchElement));
    }
}

// List creation, arr to linkedlist, length, search
class Node {
    int data;
    Node next;

    public Node(int val) {
        this.data = val;
        this.next = null;
    }
}