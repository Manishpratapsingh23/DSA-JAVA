
import java.util.Scanner;

public class insertNodeAtithPosition {
    public static Node<Integer> insertnode(Node<Integer> head, int data, int n) {
        Node<Integer> newNode = new Node<Integer>(data);
        if (n == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        int index = 0;
        Node<Integer> temp = head;
        while (temp != null && index < n - 1) {
            temp = temp.next;
            index++;
        }
        if (temp != null) {
            newNode.next = head.next;
            head.next = newNode;
        }
        return head;

    }

    // 1 2 3 4 5
    // 1 2 3 0 4 5
    public static Node<Integer> deletenode(Node<Integer> head, int n) {
        if (head == null)
            return head;
        if (n == 0)
            return head.next;

        Node<Integer> temp = head;
        int pos = 0;
        while (temp != null && temp.next != null && pos < n - 1) {
            temp = temp.next;
            pos++;
        }
        if (temp != null && temp.next != null)
            temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        Print.print(head);
        System.out.println();
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter index at which to insert:");
                    int insertIndex = sc.nextInt();
                    System.out.println("Enter data to insert:");
                    int data = sc.nextInt();
                    head = insertnode(head, data, insertIndex);
                    Print.print(head);
                    break;

                case 2:
                    System.out.println("Enter index at which to delete:");
                    int deleteIndex = sc.nextInt();
                    head = deletenode(head, deleteIndex);
                    Print.print(head);
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
