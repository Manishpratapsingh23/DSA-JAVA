public class BalancedBSTs {
    static long mod=(int)Math.pow(10, 9)+7;
    public static long countBalancedBST(long h){
        if(h==0 || h==1){
            return 1;
        }
        long x=countBalancedBST(h-1);
        long y=countBalancedBST(h-2);
        return (x*x + 2*x*y)%mod;
    }
    public static long countBalancedBSTM(int h){
        if(h==0) return 1;
        long store[]=new long[h+1];
        store[0]=store[1]=1;
        for(int i=2;i<=h;i++) store[i]=-1;
        int mod=(int)Math.pow(10, 9)+7;
        return countBalancedBSTM(h,store,mod);
    }
    private static long countBalancedBSTM(int h, long store[],int mod){
        if(h==0 || h==1) return store[h];
        if(store[h]!=-1) return store[h];
        long x=countBalancedBSTM(h-1, store, mod);
        long y=countBalancedBSTM(h-2, store, mod);
        store[h]=(x*x+2*x*y)%mod;
        return store[h];
    }
    public static long countBalancedBST_DP(int h){
        if(h==0) return 1;
        int mod=(int)Math.pow(10, 9)+7;
        long store[]=new long[h+1];
        store[0]=store[1]=1;
        for(int i=2;i<=h;i++){
            long x = (store[i-1]*store[i-1])%mod;
            long y = (2*store[i-1]*store[i-2])%mod;
            store[i]=(x+y)%mod;
        }
        return store[h];
    }

    public static void main(String[] args) {
        long n=10;
        int n1=7;
        System.out.println("Using recursion: "+countBalancedBST(n1));
        System.out.println("Using memoization: "+countBalancedBSTM(n1));
        System.out.println("Using DP: "+countBalancedBST_DP(n1));
    }
}
