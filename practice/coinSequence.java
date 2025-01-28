

public class coinSequence {
    public static void main(String[] args) {
        int n=3;
        findSequence("",n);
    }
    private static void findSequence(String input,int n)
    {
        if(input.length()==n)
        {
            System.out.println(input);
            return;
        }
        if(input.length()==0 || input.charAt(input.length()-1)!='H')
        findSequence(input+'H', n);
        findSequence(input+'T', n);
    }
}
