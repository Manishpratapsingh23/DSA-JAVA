public class deleteNodeFromLast {
    public static Node<Integer> deleteNode(Node<Integer> head) {
        if (head.next == null && head.next.next == null)
            return head;
        Node<Integer> temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next=null;
        return head;
    }

    public static void main(String agrs[]) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();
        Node<Integer> temp = deleteNode(head);
        System.out.println("deleted elementr from  last Node");
        Print.print(temp);
    }
}
