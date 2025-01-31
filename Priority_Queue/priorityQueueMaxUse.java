package Priority_Queue;
public class priorityQueueMaxUse {
    public static void main(String args[]){
        int arr[]={7,3,2,6,1,0,-1};
        priorityQueueMax pq=new priorityQueueMax();
        for(int i:arr){
            pq.insert(i);
        }
        System.out.println("Maximum: "+pq.getMax());
        System.out.println("Size: "+pq.getSize());
        while (!pq.isEmpty()) { 
            System.out.print(pq.removeMax()+" ");
        }
        System.out.println();
        //System.out.println("Maximum: "+pq.getMax());
        System.out.println("Size: "+pq.getSize());
        System.out.println("Maximum: "+pq.getMax());

    }
}
