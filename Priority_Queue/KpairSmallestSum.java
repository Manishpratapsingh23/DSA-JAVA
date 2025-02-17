import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class pair {
    public int priority;  
    public int i; 
    public int j;        

    public pair(int priority, int i, int j) {
        this.priority = priority;
        this.i = i;
        this.j = j;
    }
}
public class KpairSmallestSum {
    public static ArrayList<ArrayList<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }
        PriorityQueue<pair> pq=new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
        int priority=nums1[0]+nums2[0];
        pair pairAns=new pair(priority,0,0);
        pq.add(pairAns);
        int index=1;
        while(index<nums1.length){
            pair top=pq.peek();
            int i=top.i;
            int j=top.j;
            int priority1=nums1[i+1]+nums2[j];
            pair pairAns1=new pair(priority1,i+1,j);
            int priority2=nums1[i]+nums2[j+1];
            pair pairAns2=new pair(priority2,i,j+1);
            pq.add(pairAns1);
            pq.add(pairAns2);
            index++;
        }
        while(!pq.isEmpty() && ans.size()<k){
            ArrayList<Integer> lst=new ArrayList<>();
            pair output=pq.remove();
            lst.add(nums1[output.i]);
            lst.add(nums2[output.j]);
            ans.add(lst);
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int nums1[]={1,7,11};
        int nums2[]={2,4,6};
        int k=3;
        ArrayList<ArrayList<Integer>> ans=kSmallestPairs(nums1,nums2,k);
        for(ArrayList<Integer> lst:ans){
            for(int i:lst){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}