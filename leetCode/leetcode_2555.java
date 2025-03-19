
public class leetcode_2555 {
    
    public static int maximizeWin(int[] pos, int k) {
        int n=pos.length;
        if(k==0) return Math.min(n,2);
        int left[]=new int[n+1];
        int right[]=new int[n+1];
        left[0]=1;
        for(int i=1,j=0;i<n;i++){
            while(pos[i]-pos[j]>k) j++;
            left[i]=Math.max(left[i-1],i-j+1);
        }
        right[n-1]=1;
        for(int i=n-2,j=n-1;i>=0;i--){
            while(pos[j]-pos[i]>k) j--;
            right[i]=Math.max(right[i+1],j-i+1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (i > 0 ? left[i - 1] : 0) + (i < n ? right[i] : 0));
        }
        
        return res;
        }
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        int arr[]={1,1,2,2,3,3,5};
        int k=2;
        int arr1[]={2,2,2};
        int k1=0;
        System.out.println(maximizeWin(arr,k));
        System.out.println(maximizeWin(arr1,k1));
    }
}
