import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(),result);
        return result;
    }
    private static void helper(int nums[], int index, int target, List<Integer> lst, List<List<Integer>> result){
        if(index>=nums.length || target<0) return;
        if(target==0){
            result.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[index]);
        helper(nums, index, target - nums[index], lst, result);
        lst.remove(lst.size() - 1); 
        helper(nums, index + 1, target, lst, result);
    }
    public static void main(String[] args) {        
        int arr[]={2,3,6,7};
        int target=7;
        List<List<Integer>> lst=combinationSum(arr, target);
        System.out.println(lst);

        int arr1[]={2,3,5};
        int target1=8;
        List<List<Integer>> lst1=combinationSum(arr1, target1);
        System.out.println(lst1);
    }
}
