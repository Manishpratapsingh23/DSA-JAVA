public class MinStepsToOne {
    public static int MinSteps(int n){
        if(n==1){
            return 0;
        }
        int res = MinSteps(n - 1);
        if (n % 2 == 0) {
            res = Math.min(res, MinSteps(n / 2));
        }
        if (n % 3 == 0) {
            res = Math.min(res, MinSteps(n / 3));
        }

        return 1 + res;
    }
    public static int MinStepsM(int n){
        int[] store=new int[n+1];
        return MinStepsM(n,store);
    }
    private static int MinStepsM(int n,int[]store){
        if(n==1){
            store[n]=0;
            return store[n];
        }
        if(store[n]!=0){
            return store[n];
        }
        int res = MinStepsM(n - 1,store);
        if (n % 2 == 0) {
            res = Math.min(res, MinStepsM(n / 2,store));
        }
        if (n % 3 == 0) {
            res = Math.min(res, MinStepsM(n / 3,store));
        }
        store[n]=res+1;
        return store[n];

    }
    public static int MinStepsDP(int n){
        int store[]=new int[n+1];
        store[1]=0;
        for(int i=2;i<=n;i++){
            int min=store[i-1];
            if(i%3==0){
                if(min>store[i/3]){
                    min=store[i/3];
                }
            }
            if(i%2==0){
                if(min>store[i/2]){
                    min=store[i/2];
                }
            }
            store[i]=1+min;
        }
        return store[n];
    }
    public static void main(String[] args) {
        //int n=1000;
        int n=9;
        System.out.println(MinStepsDP(n));
        System.out.println(MinStepsM(n));
        System.out.println(MinSteps(n));
    }
}
