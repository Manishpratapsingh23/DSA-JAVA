import java.util.Scanner;

public class printIthNode {
    public static int printnode(Node<Integer> head, int n) {
        while (head != null && n > 0) {
            head = head.next;
            n--;

        }
        return head.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        Print.print(head);
        System.out.println();
        System.out.println("Enter node index to be print");
        int n = sc.nextInt();
        System.out.println(printnode(head, n));

    }

}
