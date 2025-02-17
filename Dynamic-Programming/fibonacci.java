public class fibonacci {
    public static int fibo(int n){
        if(n==0 || n==1) return n;
        return fibo(n-1)+fibo(n-2);
    }
    public static int fibM(int n){
        int Store[]=new int[n+1];
        for(int i=0;i<=n;i++){
            Store[i]=-1;
        }
        return fibM(n,Store);
    }
    private static int fibM(int n, int Store[]){
        if(n==0 || n==1){
            Store[n]=n;
            return Store[n];
        }
        if(Store[n]!=-1){
            return Store[n];
        }
        Store[n]=fibM(n-1,Store)+fibM(n-2,Store);
        return Store[n];
    }
    public static int fiboDP(int n){
        int Store[]=new int[n+1];
        Store[0]=0;
        Store[1]=1;
        for(int i=2;i<=n;i++){
            Store[i]=Store[i-1]+Store[i-2];
        }
        return Store[n];
    }
    public static void main(String[] args) {
        int n=44;
        System.out.println(fiboDP(n));
        System.out.println(fibM(n));
        System.out.println(fibo(n));
    }
}
