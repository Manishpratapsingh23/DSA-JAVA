
public class QuickSortUsingRecursion {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int arr[] = { 4, 9, 7, 1, 6, 8, 5, 2, 3, 0 };
        int start = 0;
        int end = arr.length;
        display(arr);
        System.out.println();
        demo.quickSort(arr, start, end - 1);
        display(arr);
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }
}

class demo {
    public static void quickSort(int arr[], int startindex, int endindex) {
        if (startindex >= endindex)
            return;
        int pivot_point = partition(arr, startindex, endindex);
        quickSort(arr, startindex, pivot_point - 1);
        quickSort(arr, pivot_point + 1, endindex);

    }

    public static int partition(int arr[], int startindex, int endindex) {
        int count = 0;
        for (int i = startindex + 1; i <= endindex; i++) {
            if (arr[i] < arr[startindex])
                count++;
        }
        int pivot_point = startindex + count;
        int t = arr[startindex];
        arr[startindex] = arr[pivot_point];
        arr[pivot_point] = t;
        int i = startindex, j = endindex;
        while (i < pivot_point && j > pivot_point) {
            if (arr[i] < arr[pivot_point])
                i++;
            else if (arr[j] < arr[pivot_point]) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            } else
                j--;
        }
        return pivot_point;

    }

}
