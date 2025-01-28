package LinkedList;
import java.util.Scanner;

public class reverseInKgroups {
    public static Node<Integer> reversek(Node<Integer> head, int k) {
        if (head == null || k <= 0) {
            System.out.println("Invalid input or empty list");
            return head; // Invalid input
        }

        Node<Integer> ans = head;
        int count = 1;

        // Traverse to the k-th node
        while (ans!= null && count < k) {
            ans = ans.next;
            count++;
        }
        count=0;
        Node<Integer> curr=head,next=null,prev=null,prevnext=null;
        while(curr!=null)
        {
            if(count<k)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            else
            {
                if(prevnext!=null)
                
            }
        }

        return ans; // Return the data at the k-th node
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node<Integer> current = head, next = null, prev = null;

        // Reverse the entire linked list
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput input = new NodeInput();
        NodePrint print = new NodePrint();

        // Input the linked list
        Node<Integer> head = input.input();
        System.out.println("\nOriginal List:");
        print.print(head);

        // Reverse the linked list
        Node<Integer> reversedHead = reverse(head);
        System.out.println("\nReversed List:");
        print.print(reversedHead);

        // Query reversek on the original list
        System.out.print("\nEnter the position of the node (k): ");
        int k = sc.nextInt();
        Node<Integer> newHead = reversek(head, k);
        print.print(newHead);
        

        
    }
}
