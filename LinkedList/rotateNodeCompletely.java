package LinkedList;

public class rotateNodeCompletely {
    public static Node<Integer> rotate(Node<Integer> head) {
        if (head == null)
            return head;
        Node<Integer> result = head;
        Node<Integer> temp = result, newhead = head;
        int count = 0, n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;
        while (count < n) {
            temp.next = newhead;
            temp = temp.next;
            newhead = newhead.next;
            count++;
        }

        temp.next = null;
        return null;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> newNode = rotate(head);
        System.out.println("rotated Node");
        Print.print(newNode);

    }
}
