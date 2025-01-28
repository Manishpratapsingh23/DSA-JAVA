import java.util.*;

public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Substring> substrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String sub = line[0];
            int cost = Integer.parseInt(line[1]);
            substrings.add(new Substring(sub, cost));
        }

        String mainString = scanner.nextLine();

        int result = minCostToFormString(substrings, mainString);
        System.out.println(result == Integer.MAX_VALUE ? "Impossible" : result);

        scanner.close();
    }

    public static int minCostToFormString(List<Substring> substrings, String mainString) {
        int mainLen = mainString.length();
        int[] dp = new int[mainLen + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= mainLen; i++) {
            for (Substring sub : substrings) {
                String substring = sub.text;
                int cost = sub.cost;
                int subLen = substring.length();

                if (i >= subLen && mainString.substring(i - subLen, i).equals(substring)) {
                    dp[i] = Math.min(dp[i], dp[i - subLen] + cost);
                }
            }
        }

        return dp[mainLen];
    }
}

class Substring {
    String text;
    int cost;

    Substring(String text, int cost) {
        this.text = text;
        this.cost = cost;
    }
}
