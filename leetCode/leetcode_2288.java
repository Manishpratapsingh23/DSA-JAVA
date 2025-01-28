package leetCode;

import java.util.Scanner;

public class leetcode_2288 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.discountPrices(s, n));
    }

}

class Solution {
    String str = "";

    public String discountPrices(String st, int discount) {
        st = ' ' + st;
        int d = discount / 100;
        int l = st.length();

        int t = 0;
        String s = "";
        for (int i = 0; i < l; i++) {
            char ch = st.charAt(i);
            if (ch == '$') {
                s = "";
                t = i + 1;
                char c = st.charAt(t);
                while (c != ' ' && Character.isDigit(c)) {
                    s += c;
                    c = st.charAt(++t);
                }
                double n = Double.parseDouble(s);
                n = n - (n * d);
                s = Double.toString(n);
                str = '$' + s;

            } else
                str += ch;
        }
        return str;
    }
}