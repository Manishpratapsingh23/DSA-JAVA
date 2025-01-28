import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class leetcode_90 {
    public static List<List<Integer>> subsets(int arr[], List<Integer> lst, List<List<Integer>> result) {
        if (arr.length == 0) {
            if (!result.contains(lst))
                result.add(new ArrayList<>(lst));
            return result;
        }
        int arr2[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++)
            arr2[i - 1] = arr[i];
        subsets(arr2, lst, result);
        lst.add(arr[0]);
        subsets(arr2, lst, result);
        lst.remove(lst.size() - 1);
        return result;
    }

    public static void display(List<List<Integer>> lst) {
        for (List<Integer> subset : lst) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int arr[] = { 4, 4, 4, 1, 4 };
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        display(subsets(arr, new ArrayList<Integer>(), result));
    }
}
