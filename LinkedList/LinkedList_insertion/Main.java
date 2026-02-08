package LinkedList.LinkedList_insertion;

public class Main {
    public static ListNode arrToListNode(int[] arr) {
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

        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static int lengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static boolean searchElement(ListNode head, int target) {
        ListNode current = head;

        while(current != null) {
            if (current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    public static ListNode insertHead(ListNode head, int source) {
        ListNode temp = head;

        head = new ListNode(source);
        head.next = temp;

        temp = null;

        return head;
    }

    public static ListNode insertionLast(ListNode head, int X) {
        ListNode newNode = new ListNode(X);

        ListNode current = head;

        while (current != null) {
            if(current.next == null) {
                current.next = newNode;
                newNode.next = null;
            }     
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        ListNode head = arrToListNode(arr);

        System.out.println("Before insertion: ");
        printLinkedList(head);

        ListNode newhead = insertionLast(head, 9);
        System.out.println("After insertion: ");
        printLinkedList(newhead);
    }
}


class ListNode {
    int data;
    ListNode next;

    public ListNode() {
        this.data = 0;
        this.next = null;
    }

    public ListNode(int val) {
        this.data = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }
}
