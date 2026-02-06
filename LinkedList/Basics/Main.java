package LinkedList.Basics;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(8);
        arr.add(7);

        Node y1 = new Node(arr.get(0), null);
        Node y2 = new Node(arr.get(1), null);
        Node y3 = new Node(arr.get(2), null);
        Node y4 = new Node(arr.get(3), null);
        Node y5 = new Node(arr.get(4), null);

        y1.next = y2;
        y2.next = y3;
        y3.next = y4;
        y4.next = y5;

        System.out.println(y1.data + " " + y1.next);
        System.out.println(y2.data + " " + y2.next);
        System.out.println(y3.data + " " + y3.next);
        System.out.println(y4.data + " " + y4.next);
        System.out.println(y5.data + " " + y5.next);
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

