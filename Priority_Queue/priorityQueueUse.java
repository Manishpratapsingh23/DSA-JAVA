package Priority_Queue;
public class priorityQueueUse {
    public static void main(String args[]){
        //int arr[]={7,3,2,6,1,0,-1};
        int arr[] = {30,25,40,50,32,48,10,22};
        priorityQueue pq=new priorityQueue();
        for(int i:arr){
            pq.insert(i);
        }

        
        while (!pq.isEmpty()) { 
            pq.print();
            System.out.print(pq.removeMin()+" ");

        }
        // System.out.println(pq.removeMin());
        // pq.print();
        // System.out.println(pq.removeMin());
        // pq.print();
        //System.out.println("Minimum: "+pq.getMin());
    }
}
