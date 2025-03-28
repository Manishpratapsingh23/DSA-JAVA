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
        if(index>=nums.length || target<0) return;
        if(target==0){
            if(!result.contains(lst)){
                result.add(new ArrayList<>(lst));
            }
            return;
        }
        lst.add(nums[index]);
        helper(nums, index+1, target - nums[index], lst, result);
        lst.remove(lst.size() - 1); 
        helper(nums, index + 1, target, lst, result);
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
