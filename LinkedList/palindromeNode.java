
package LinkedList;

import java.util.Scanner;

public class palindromeNode {
    public static Node<Integer> reverseNode(Node<Integer> head) {
        if (head == null)
            return head;
        Node<Integer> current = head, prev = null, Next = null;
        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;

        }
        return prev;
    }

    public static boolean plaindrome(Node<Integer> head) {
        if (head == null || head.next == null)
            return true;
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        Node<Integer> temp2 = reverseNode(slow), temp1 = head;
        while (temp2 != null) {
            if (temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();
        System.out.println("PALINDROME OR NOT");
        System.out.println(plaindrome(head));

    }
}
