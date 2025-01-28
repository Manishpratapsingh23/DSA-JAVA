public class substringRecursion {
    public static void main(String[] args) {
        String input="abc";
        String output="";
        findSubString(input,output);
    }
    private static  void findSubString(String input,String output)
    {
        if(input.length()==0)
        {
            System.out.println(output);
            return;
        }
        char ch=input.charAt(0);
        findSubString(input.substring(1), output+ch);
        findSubString(input.substring(1), output);
    }
}
