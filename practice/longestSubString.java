import java.util.Scanner;
import java.lang.*;
class Solution {
    public String lengthOfLongestSubstring(String s) {
        int l = s.length();
        String st = "";
        String str = "";

        for(int i=0;i<l-1;i++)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            st += s.charAt(i);
            else
            if(st.length()>str.length())
            {
                str = st;
                st = "";
            }

        }
        return str;

    }
}
class xyz
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
	System.out.println("Enter word");
	String s = sc.nextLine();
	Solution ob = new Solution();
	System.out.println(ob.lengthOfLongestSubstring(s));
	}
	}