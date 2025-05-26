import java.util.*;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTestCases = sc.nextInt();
        sc.nextLine(); 

        while (totalTestCases-- > 0) {
            String parenthesesString = sc.nextLine();
            int balanceCounter = 0;
            boolean hasEarlyBalance = false;

            for (int position = 0; position < parenthesesString.length(); position++) {
                if (parenthesesString.charAt(position) == '(') {
                    balanceCounter++;
                } else {
                    balanceCounter--;
                }
                if (position != parenthesesString.length() - 1 && balanceCounter == 0) {
                    hasEarlyBalance = true;
                    break;
                }
            }

            System.out.println(hasEarlyBalance ? "YES" : "NO");
        }

        sc.close();
    }
}
