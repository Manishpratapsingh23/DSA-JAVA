package LinkedList;

public class printNodeRecursively {
    public static void printRecursive(Node<Integer> head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        printRecursive(head.next);
    }

    public static void printRecursiveReverse(Node<Integer> head) {
        if (head == null)
            return;
        printRecursiveReverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        System.out.println("RECUSIVELY PRINTED NODE");
        printRecursive(head);
        System.out.println();
        System.out.println("RECUSIVELY REVERSE PRINTED NODE");
        printRecursiveReverse(head);

    }
}
