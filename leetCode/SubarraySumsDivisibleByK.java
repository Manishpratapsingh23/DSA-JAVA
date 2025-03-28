public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        long freq[]=new long[arr.length];
        long sum=0;
        freq[0]=1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=(int)(sum%n);
            if(rem<0) rem+=n;
            freq[rem]++;
        }
        long ans=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>=2){
                long x=freq[i];
                ans+=(x*(x-1))/2;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int arr[]={4,5,0,-2,-3,1 };
        int k=5;
        System.out.println(subarraysDivByK(arr, k));
    }
}
