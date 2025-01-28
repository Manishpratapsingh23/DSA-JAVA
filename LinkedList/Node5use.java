import java.util.Scanner;

public class Node5use {
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node<Integer> input() {
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null, tail = null;
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;

            }
            data = sc.nextInt();
        }
        return head;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> current) {
        Node<Integer> head = current;
        if (head == null)
            return null;
        while (head != null && head.next != null) {
            if (head.data == head.next.data)
                head.next = head.next.next;
            else
                head = head.next;
        }
        // return head;
        // Node<Integer> current = head;
        // while (current != null && current.next != null) {
        // if (current.data.equals(current.next.data)) {
        // current.next = current.next.next; // Skip the duplicate node
        // } else {
        // current = current.next; // Move to the next node
        // }
        // }
        return current;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        print(head);
        System.out.println();
        head = removeDuplicates(head);
        print(head);
    }

}
