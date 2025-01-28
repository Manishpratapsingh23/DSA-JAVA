package LinkedList;

public class reverseNode {
    public static Node<Integer> reverse(Node<Integer> head) {
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

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> newNode = reverse(head);
        System.out.println("reversed Node");
        Print.print(newNode);

    }
}
