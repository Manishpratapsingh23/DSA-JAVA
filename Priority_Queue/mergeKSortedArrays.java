import java.util.ArrayList;
import java.util.PriorityQueue;
public class mergeKSortedArrays {
    public static ArrayList<Integer> mergeArrays(int[][] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int input[] : arr){
            for(int i: input){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        return ans;
	}

    public static void main(String[] args) {
        int input[][]={ {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        ArrayList<Integer> ans=mergeArrays(input);
        for(int i : ans){
            System.out.print(i+", ");
        }
    }
}
