package LinkedList;
import java.util.*;

public class splitLinkedListInParts {
    public static void main(String args[]){
        NodeInput Input = new NodeInput();
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = Input.input();
        int k = sc.nextInt();
        Node ans[] = solve(head,k);
        for(Node node : ans) System.out.print(node.data + " ");
    }

    private static Node[] solve(Node head, int k){
        Node temp = head;
        int l = size(temp);
        System.out.println(l);
        Node[] ans = new Node[k];
        return ans;
    }

    private static int size(Node head){
        int l = 0;
        while(head!=null){
            head = head.next;
            l++;
        }
        return l;
    }
}
