import java.util.Scanner;

public class findLastIndex {
    public static int firstIndex(int input[], int x) {
        if (input.length == 0)
            return -1;

        int newarray[] = new int[input.length - 1];
        for (int i = 0; i < input.length - 1; i++)
            newarray[i] = input[i + 1];
        int ans = firstIndex(newarray, x);
        if (ans != -1)
            return ans + 1;
        if (input[0] == x)
            return 0;
        return -1;
    }

    public static void main(String[] args) {
        int[] input = { 34, 57, 61, 65, 35, 61 };
        int x = 61;
        System.out.println(firstIndex(input, x));
    }

}
