import java.util.*;

public class aggressiveCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cows position");
        int n = sc.nextInt();
        int dist[] = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = sc.nextInt();
        System.out.println("Enter number cows position");
        int cows = sc.nextInt();
        Arrays.sort(dist);

    }

    public static int checkDistance(int dist[], int cows) {

    }
}
