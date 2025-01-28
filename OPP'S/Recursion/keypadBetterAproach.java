public class keypadBetterAproach {
    public static void keypad(int n)
    {
        keypad(n,"");
    }
    public static void keypad(int n, String st)
    {
        if(n==0)
        {
            System.out.println(st);
            return;
        }
        int num=n%10;
        String input;
        input = switch (num) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            default -> "wxyz";
        };
        for(int i=0;i<input.length();i++)
        keypad(n/10,input.charAt(i)+st);
    }

    public static void main(String args[])
    {
        keypad(23);
    }
}
