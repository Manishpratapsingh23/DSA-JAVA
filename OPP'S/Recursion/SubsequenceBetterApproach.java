
public class SubsequenceBetterApproach {
    public static void printSubsequence(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        printSubsequence(input.substring(1), output);
        printSubsequence(input.substring(1), output + input.charAt(0));
    }

    public static void Subsequence(String input) {
        printSubsequence(input, "");
    }

    public static void main(String args[]) {
        Subsequence("XYZ");
    }
}
