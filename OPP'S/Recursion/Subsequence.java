public class Subsequence {
    public static String[] findSubSequence(String st) {
        if (st.length() == 0) {
            String ans[] = { "" };
            return ans;
        }
        String Smallans[] = findSubSequence(st.substring(1));
        String ans[] = new String[Smallans.length * 2];
        for (int i = 0; i < Smallans.length; i++) {

            ans[i] = Smallans[i];
            ans[i + Smallans.length] = st.charAt(0) + Smallans[i];
        }
        return ans;

    }

    public static void main(String agr[]) {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter String");
        // String st = sc.nextLine();
        String ans[] = findSubSequence("xyz");
        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++)
            System.out.println(ans[i]);
    }

}
