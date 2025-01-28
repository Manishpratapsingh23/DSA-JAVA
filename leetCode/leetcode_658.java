import java.util.*;

public class leetcode_658 {
    public static void main(String args[]) {
        int arr[] = { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 };
        demo ob = new demo();
        System.out.print(ob.findClosestElements(arr, 3, 5));

    }
}

class demo {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> lst = new ArrayList<>();
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (Math.abs(nums[start] - x) <= Math.abs(nums[end] - x))
                lst.add(nums[start++]);
            else
                lst.add(nums[end--]);
            k--;
        }
        Collections.sort(lst);
        return lst;

    }
}
