import java.util.*;

public class SportsBetting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of students
            int[] days = new int[n];
            
            for (int i = 0; i < n; i++) {
                days[i] = sc.nextInt();
            }
            
            // Using a HashSet to check for duplicate betting days
            HashSet<Integer> daySet = new HashSet<>();
            boolean canWin = false;

            for (int day : days) {
                if (daySet.contains(day)) {
                    canWin = true;
                    break; // Exit early if duplicate day is found
                }
                daySet.add(day);
            }

            System.out.println(canWin ? "Yes" : "No");
        }
        sc.close();
    }
}
