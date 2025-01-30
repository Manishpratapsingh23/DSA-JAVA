
import java.util.HashMap;

public class pairSum {
    public static int pair(int arr[],int size){
        int count=0;
        if(size==0){  
        return count;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:arr)
        {	
            if(map.containsKey(key))
        	{
            	map.put(key,map.get(key)+1);
        	}
            else
            {
                map.put(key,1);
            }   
        }
        int countPairs=0;
        for (Integer i: map.keySet())
        {
            if (map.containsKey(-i) && i!=0)
            {
            	countPairs=countPairs+(map.get(i)*map.get(-i));
            }
        }
        countPairs=countPairs/2;
        if (map.containsKey(0))
        {
            int val=map.get(0);
            countPairs=countPairs+(val*(val-1))/2;
        }
        return countPairs;
	}
    public static void main(String[] args) {
        int arr[]={2,1,-2,2,3};
        int ans=pair(arr, 5);
        System.out.println(ans);
    }
}
