public class totalPalindromicString{
    public static void main(String[] args) {
        String st="nitin";
        int ans=countPalindromicSubString(st);
        System.out.println(ans);
        String st1="cbb";
        String st2="accd";
        String st3="bc";
        String st4="abc";
        String ans1=countPalindromicSubStringLargest(st);
        String ans2=countPalindromicSubStringLargest(st1);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(countPalindromicSubStringLargest(st2));
        System.out.println(countPalindromicSubStringLargest(st3));
        System.out.println(countPalindromicSubStringLargest(st4));
    }
    private static int countPalindromicSubString(String st){
        int odd=0;
        for(int axis=0;axis<st.length();axis++){
            for(int orbit=0;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt(axis-orbit)!=st.charAt(axis+orbit)){
                    break;
                }
                System.out.println(st.substring(axis-orbit,axis+orbit+1));
                odd++;
            }
        }
        int even=0;
        for(double axis=0.5;axis<st.length();axis++){
            for(double orbit=0.5;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt((int)(axis-orbit))!=st.charAt((int)(axis+orbit))){
                    break;
                }
                System.out.println(st.substring((int)(axis-orbit),(int)(axis+orbit+1)));
                even++;
            }
        }
        return even+odd;
    }
    private static String countPalindromicSubStringLargest(String st){
        String ans="";
        for(int axis=st.length()-1;axis>0;axis--){
            for(int orbit=0;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt(axis-orbit)!=st.charAt(axis+orbit)){
                    break;
                }
                else{
                    if(ans.length()<=2*orbit){
                        ans=st.substring(axis-orbit,axis+orbit+1);
                    }
                }
            }
        }
        for(double axis=st.length()-0.5;axis>0;axis--){
            for(double orbit=0.5;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt((int)(axis-orbit))!=st.charAt((int)(axis+orbit))){
                    break;
                }
                else{
                    if(ans.length()<=2*orbit){
                        ans=st.substring((int)(axis-orbit),(int)(axis+orbit+1));
                    }
                }
                
            }
        }
        return ans;
    }
}