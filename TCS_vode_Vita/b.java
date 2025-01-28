import java.util.*;

public class b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<Set<Integer>> friendships = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friendships.add(new HashSet<>());
        }
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            friendships.get(a).add(b);
            friendships.get(b).add(a);
        }
        int K = scanner.nextInt();
        boolean[] currentDay = new boolean[N];
        Arrays.fill(currentDay, true);
        int cumulativeRosteringValue = N;
        int days = 1;
        while (cumulativeRosteringValue < K) {
            boolean[] nextDay = new boolean[N];
            int dailyAttendance = 0;
            for (int i = 0; i < N; i++) {
                int friendsInOffice = 0;
                for (int friend : friendships.get(i)) {
                    if (currentDay[friend]) {
                        friendsInOffice++;
                    }
                }
                if (currentDay[i] && friendsInOffice == 3) {
                    nextDay[i] = true;
                } else if (!currentDay[i] && friendsInOffice < 3) {
                    nextDay[i] = true;
                }
                if (nextDay[i]) {
                    dailyAttendance++;
                }
            }
            cumulativeRosteringValue += dailyAttendance;
            currentDay = nextDay;
            days++;
        }
        System.out.println(days);
    }
}
