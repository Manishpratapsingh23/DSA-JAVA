
import java.util.PriorityQueue;

public class KsortedArray {
    private static void sortedKArray(int arr[], int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(;i<k && i<arr.length;i++){
            pq.add(arr[i]);
        }
        for(;i<arr.length;i++){
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
        }
        for(int j=arr.length-k;j<arr.length;j++){
            arr[j]=pq.remove();
        }

    }
    public static void main(String[] args) {
        int arr[]={2,4,1,9,6,8};
        int k=3;
        sortedKArray(arr, k);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
