
public class MakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        int open=0,required=0;
        for(char ch  : s.toCharArray()){
            if(ch=='(') open++;
            else if(open>0) open--;
            else required++;
        }
        return open+required;
    }
    public static void main(String[] args) {
        String s = "())";
        String s1 = "(((";
        System.out.println(minAddToMakeValid(s));
        System.out.println(minAddToMakeValid(s1));
    }
}
