
import Priority_Queue.priorityQueue;


public class priorityQueueUse {
    public static void main(String args[]){
        int arr[]={7,3,2,6,1,0,-1};
        priorityQueue pq=new priorityQueue();
        for(int i:arr){
            pq.insert(i);
        }
        while (!pq.isEmpty()) { 
            System.out.print(pq.removeMin()+" ");
        }
        System.out.println();
    }
}
