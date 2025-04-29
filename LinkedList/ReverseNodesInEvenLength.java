package LinkedList;

public class ReverseNodesInEvenLength {
    public static  Node reverseEvenLengthGroups(Node head) {
        if(head==null) return null;
        Node prev=null, curr=head;
        int groupSize=1;
        while(curr!=null){
            Node groupPrev=prev,groupStart=curr;
            int count=0;
            while(count<groupSize && curr!=null){
                prev=curr;
                curr=curr.next;
                count++;
            }
            if(count%2==0){
                prev.next=null;
                Node reversed = reverse(groupStart);
                if(groupPrev!=null){
                    groupPrev.next=reversed;
                    prev=groupStart;
                }
                else head=reversed;
                groupStart.next=curr;
            }
            groupSize++;
        }
        return head;
    }

    public static Node reverse(Node head){
        if(head==null) return null;
        Node curr=head, prev=null, Next=null;
        while(curr!=null){
            Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        return prev;
    }
    public static void main(String[] args) {
        NodeInput Input=new NodeInput();
        Node<Integer> head=Input.input();

        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> newNode = reverseEvenLengthGroups(head);
        System.out.println("reversed Node");
        Print.print(newNode);
    }
}
