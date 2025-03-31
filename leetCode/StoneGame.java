public class StoneGame {
    public static  boolean stoneGame(int[] piles) {
        return stoneGame(piles,0,piles.length-1,0,0,true);
    }

    public static  boolean stoneGame(int[] piles,int start,int end,int s1,int s2, boolean chance) {
        if(start==end) return s1>s2;
        boolean ans1=true,ans2=true;
        if(chance){
            ans1=stoneGame(piles, start+1, end, s1+piles[start], s2, !chance);
            ans2=stoneGame(piles, start, end-1, s1+piles[end], s2, !chance);
        }
        else{
            ans1=stoneGame(piles, start+1, end, s1, s2+piles[start], !chance);
            ans2=stoneGame(piles, start, end-1, s1, s2+piles[end], !chance);
        }
        return ans1 || ans2;

    }
    public static void main(String[] args) {
        int arr[]={5,3,4,5};
        System.out.println(stoneGame(arr));
    }
}
