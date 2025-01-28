class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int c=0;
        boolean b=false;
        for(int i=0;i<words.length;i++)
        {
            
            if(check(words[i],s))
            c++;
        }
        
        return c;
    }
    private boolean check(String st ,String str)
    {
        int t=0;
        boolean b=false;
            for(int j=0;j<st.length();j++)
            {
                 b=false;
                for(int k=t;k<str.length();k++)
                {
                    if(str.charAt(k)==st.charAt(j))
                    {
                        t=k+1;
                        b=true;
                        break;
                    }
                }
                if(b==false)
                break;     
            }
            return b;

    }
}