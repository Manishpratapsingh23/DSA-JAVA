import java.util.ArrayList;
import java.util.PriorityQueue;
public class kLargestElement {
    public static ArrayList<Integer> kElement(int input[], int k){
        ArrayList<Integer> lst=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int index=0;
        while(index<input.length){
            pq.add(input[index++]);
            while(pq.size()>k){
                pq.remove();
            }
        }
        while(!pq.isEmpty()){
            lst.add(pq.remove());
        }
        return lst;
    }
    public static void main(String[] args) {
        int input[]={2,12,9,16,10,5,3,20,25,11,1,8,6};
        int k=4;
        ArrayList<Integer> lst=kElement(input,k);
        for(int i : lst){
            System.out.print(i+" ");
        }
    }
}
