
public class MergeSortUsingRecursion {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int arr[] = { 4, 1, 6, 5, 2, 3, 0 };
        int start = 0;
        int end = arr.length;
        display(arr);
        System.out.println();
        demo.mergeSort(arr, start, end - 1);
        display(arr);
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }
}

class demo {
    public static void mergeSort(int arr[], int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + start];
        for (int i = 0; i < n2; i++)
            right[i] = arr[i + 1 + mid];
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
    }

}
