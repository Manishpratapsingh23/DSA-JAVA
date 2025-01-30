import java.util.HashMap;
public class maximumFrequency {
    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i:arr){
			if(map.containsKey(i))
			{
				int c=map.get(i)+1;
				map.put(i,c);
			}
			else
			map.put(i,1);
		}
		int max_freq=Integer.MIN_VALUE;
		int ans=-1;
		for(int key : map.keySet()){
			if(map.get(key)>max_freq)
			{
				max_freq=map.get(key);
				ans=key;
			}
		}
		return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,1,1,2,3,4,6,7};
        int ans=maxFrequencyNumber(arr);
        System.out.println(ans);
    }
}
