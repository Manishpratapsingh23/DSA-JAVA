
import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicates {

public static ArrayList<Integer> remove(int arr[])
{
    ArrayList<Integer> ans=new ArrayList<>();
    HashMap<Integer,Boolean> seen =new HashMap<>();
    for(int i:arr){
            if (seen.containsKey(i)) {
                continue;
            }
            ans.add(i);
            seen.put(i, true);
    }
    return ans;
}
    public static void main(String[] args) {
        //System.out.println("");
        int arr[]={1,2,3,45,3,2,1,6,7,9,6,9,10000,5,4,5};
        ArrayList<Integer> ans=remove(arr);
        for(int i=0;i<ans.size();i++)
        System.out.println(ans.get(i));
        
    }
}
