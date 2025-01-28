import java.util.Scanner;

public class MergeSortNode {
    public static Node<Integer> midPoint(Node<Integer> head) {
        if (head == null && head.next == null)
            return head;
        Node<Integer> fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node<Integer> head = null, tail = null, h1 = head1, h2 = head2;
        if (h1.data <= h2.data) {
            head = h1;
            tail = h1;
            h1 = h1.next;
        } else {
            head = h2;
            tail = h2;
            h2 = h2.next;
        }
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                tail.next = h1;
                tail = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                tail = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null)
            tail.next = h1;
        else
            tail.next = h2;
        return head;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> midNode = midPoint(head), Part1head = head, Part2head = null;
        Part2head = midNode.next;
        midNode.next = null;
        Node<Integer> head1 = mergeSort(Part1head);
        Node<Integer> head2 = mergeSort(Part2head);
        Node<Integer> newHead = merge(head1, head2);
        return newHead;

    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node 1");
        Print.print(head);
        System.out.println();
        System.out.println("Merged Sorted Node");
        Print.print(mergeSort(head));

    }
}
