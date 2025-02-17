public class stairCase {
    private static long stair(int n){
        if(n==1 || n==0) return 1;
        if(n<0) return 0;
        return stair(n-1)+stair(n-2)+stair(n-3);
    } 
    public static long stairM(int n){
        long[] store=new long[n+1];
        store[0]=1;
        for(int i=1;i<=n;i++) {
            store[i]=-1; 
        }
        return stairM(n,store);
    }
    private static long stairM(int n, long[] store){
        if(n==0 || n==1){
            store[n]=1;
            return store[n];
        }
        if(n<1) return 0;
        if(store[n]!=-1) return store[n];
        long op1=stairM(n-1, store);
        long op2=stairM(n-2, store);
        long op3=stairM(n-3, store);
        store[n]=op1+op2+op3;
        return store[n];
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(stair(n));
        System.out.println(stairM(n));
    }
}
