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

    public static void deleteHead(ListNode head) {
        head = head.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 5;

        ListNode head = arrToLinkedList(arr);

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