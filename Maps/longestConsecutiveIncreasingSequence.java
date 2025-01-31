import java.util.ArrayList;
import java.util.HashMap;

public class longestConsecutiveIncreasingSequence {
    private static ArrayList<Integer> sequence(int arr[]){
        ArrayList<Integer> lst=new ArrayList<>();
        if(arr.length==0){
            return lst;
        }
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i:arr){
            map.put(i,true);
        }
        for (int i : arr) {
            map.put(i, true);
        }
        
        int start = 0, maxLength = 0;
        
        for (int key : arr) { // Maintain input order
            if (map.get(key)) { // Process only if key hasn't been visited
                int currentStart = key;
                int length = 1;
                
                // Backward search
                int left = key - 1;
                while (map.containsKey(left)) {
                    map.put(left, false); // Mark as visited
                    currentStart = left;
                    length++;
                    left--;
                }
                
                // Forward search
                int right = key + 1;
                while (map.containsKey(right)) {
                    map.put(right, false); // Mark as visited
                    length++;
                    right++;
                }
                
                // Update result if we find a longer sequence or same-length earlier sequence
                if (length >= maxLength) {
                    maxLength = length;
                    start = currentStart;
                }
            }
        }
        lst.add(start);
        if (maxLength > 1) {
            lst.add(start + maxLength - 1);
        }
        return lst;
    }
    public static void main(String[] args) {
        //int arr[]={9,1,8,6,3,4,2,7,10,15};
        int arr[]={3,7,2,1,9,8,41};
        ArrayList<Integer> ans=sequence(arr);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
