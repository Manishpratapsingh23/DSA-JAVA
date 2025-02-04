import java.util.PriorityQueue;
public class priorityQueueUseString {
    public static void main(String[] args) {
        MaxPQStringComparator maxComp=new MaxPQStringComparator(); //this made mannually made Comparator;
        MinPQStringComparator minComp=new MinPQStringComparator(); //this made mannually made Comparator;
        //PriorityQueue<Integer> pq1=new PriorityQueue<>(); //simple PQ
        //PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder()); //this is inbuild Max PQ
        PriorityQueue<String> pq3=new PriorityQueue<>(minComp); 
        PriorityQueue<String> pq4=new PriorityQueue<>(maxComp); 
        //int arr[]={9,4,2,0,5,1};



        /*
         the String will be sorted by length;
         */
        String arr2[]={"this","at","a","their","Zebra","elephant","dog","cat"};
        //String arr[]={"Union","Public","Service","Commision"};
        for(String st:arr2){
            pq3.add(st);
        }
        //System.out.println(pq3.peek());
        while(!pq3.isEmpty()){
            System.out.print(pq3.remove()+", ");
        }
        for(String st:arr2){
            pq4.add(st);
        }
        System.out.println();
        //System.out.println(pq4.peek());
        while(!pq4.isEmpty()){
            System.out.print(pq4.remove()+", ");
        }
    }
}
