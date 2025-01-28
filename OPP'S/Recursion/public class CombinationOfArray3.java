public class CombinationOfArray3 {
    public static List<List<Integer>> subsequence(int input, int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int arr[][] = subsetsHelper(input, 0);
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length && k == arr[i].length; j++)
                sum += arr[i][j];
            if (sum == n)
                result.add(new ArrayList<>(arr[i]));
        }
        return result;

    }

    private static int[][] subsetsHelper(int input[], int index) {
        if (index == input.length) {
            return new int[1][0];
        }
        int small_ans[][] = subsetsHelper(input, index + 1);
        int small_ans_length = small_ans.length;
        int small_output[][] = new int[small_ans_length * 2][];
        for (int i = 0; i < small_ans_length; i++) {
            small_output[i] = new int[small_ans[i].length];
            small_output[i + small_ans_length] = new int[small_ans[i].length + 1];
            small_output[i + small_ans_length][0] = input[index];
            for (int j = 1; j <= small_ans[i].length; j++) {
                small_output[i][j - 1] = small_ans[i][j - 1];
                small_output[i + small_ans_length][j] = small_ans[i][j - 1];
            }
        }
        return small_output;
    }

    public static void main(String args[]) {
        int input[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        display(subsequence(arr, 4, 15));
    }

    public static void display(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++)
                System.out.print(arr.get(i).get(j) + "  ");
            System.out.println();
        }

    }
}
