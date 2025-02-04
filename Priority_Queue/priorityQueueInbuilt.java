
import java.util.PriorityQueue;

public class priorityQueueInbuilt {
    public static void main(String[] args) {
        MaxPQComparator maxComp=new MaxPQComparator(); //this made mannually made Comparator;
        MinPQComparator minComp=new MinPQComparator(); //this made mannually made Comparator;
        //PriorityQueue<Integer> pq1=new PriorityQueue<>(); //simple PQ
        //PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder()); //this is inbuild Max PQ
        PriorityQueue<Integer> pq3=new PriorityQueue<>(minComp); //
        PriorityQueue<Integer> pq4=new PriorityQueue<>(maxComp); //
        int arr[]={9,4,2,0,5,1};
        for(int i:arr){
            pq3.add(i);
        }
        //System.out.println(pq3.peek());
        while(!pq3.isEmpty()){
            System.out.print(pq3.remove()+" ");
        }
        for(int i:arr){
            pq4.add(i);
        }
        System.out.println();
        //System.out.println(pq4.peek());
        while(!pq4.isEmpty()){
            System.out.print(pq4.remove()+" ");
        }
    }
}
