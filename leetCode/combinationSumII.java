import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(),result);
        return result;
    }
    private static void helper(int nums[], int index, int target, List<Integer> lst, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(lst));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            lst.add(nums[i]);
            helper(nums, i+1, target-nums[i], lst, result);
            lst.remove(lst.size()-1);
        }
    }
    public static void main(String[] args) {        
        int arr[]={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> lst=combinationSum2(arr, target);
        System.out.println(lst);

        int arr1[]={2,5,2,1,2};
        int target1=5;
        List<List<Integer>> lst1=combinationSum2(arr1, target1);
        System.out.println(lst1);
    }
}
