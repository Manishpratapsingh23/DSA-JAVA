public class SubsequenceOfArray {
    public static int[][] subsequence(int input[]) {
        return subsetsHelper(input, 0);

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
        int arr[] = { 5, 2, 3 };
        display(subsequence(arr));
    }

    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + "  ");
            System.out.println();
        }
    }
}
