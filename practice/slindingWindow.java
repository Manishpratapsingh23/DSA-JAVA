public class slindingWindow {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k = 3;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];
        System.out.println(sum);
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            System.out.println(sum);
        }
    }
}
