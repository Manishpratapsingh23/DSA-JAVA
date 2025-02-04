
import java.util.PriorityQueue;

public class priorityQueueInbuilt {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int arr[]={9,4,2,0,5,1};
        for(int i:arr){
            pq.add(i);
        }
        System.out.println(pq.peek());
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }
}
