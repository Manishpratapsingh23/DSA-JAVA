package LinkedList;

public class removeDuplicates {
    public static Node<Integer> remove(Node<Integer> head) {
        if (head == null)
            return head;
        Node<Integer> prev = head, curr = head.next;
        while (prev != null) {
            // if()
        }
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> newNode = remove(head);
        System.out.println("Node After Removing Duplicates");
        Print.print(newNode);

    }
}
