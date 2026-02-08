package LinkedList.LinkedList_Deletion;

import java.util.List;

public class Main {
    public static ListNode arrToLinkedList(int[] arr) {
        int size = arr.length;
        if (size == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < size; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static int lengthOfLinkedList(ListNode head) {
        ListNode current = head;
        int length = 0;

        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static boolean searchElement(ListNode head, int target) {
        ListNode current = head;

        while(current != null) {
            if(current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    public static ListNode deleteHead(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        head = head.next;
        
        temp = null;

        return head;
    }

    public static ListNode deleteLastNode(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static ListNode deleteKthNode(ListNode head, int K) {
        if (head == null) return null;

        if (K == 1) {
            ListNode temp = head;
            head = head.next;
            return head;
        }

        ListNode temp = head;
        for (int i = 0; temp != null && i < K-2; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return head;

        ListNode next = temp.next.next;
        temp.next = next;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 5;

        ListNode head = arrToLinkedList(arr);

        // before deletion
        System.out.println("Linked list before deletion");
        printLinkedList(head);

        head = deleteKthNode(head, 2);
        System.out.println("Linked list after deletion");
        printLinkedList(head);

        System.out.println("Length of the linked list: " + lengthOfLinkedList(head));
        System.out.println("Search element found ? : " + searchElement(head, target));
    }
}

// Node class to create node and store data, and the reference to the
// succeeding node.
class ListNode {
    int data;
    ListNode next;

    ListNode() {
        this.data = 0;
        this.next = null;
    }
    
    ListNode(int val) {
        this.data = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }
}