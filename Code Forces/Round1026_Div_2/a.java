import java.util.*;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)     arr[i] = sc.nextInt();
            Arrays.sort(arr);
            if((arr[0]+arr[n-1])%2==0) System.out.println(0);
            else{
                int s=0,e=0;
                if(arr[0]%2==1){
                    for(int i=0;i<n;i++){
                        if(arr[i]%2==0) break;
                        s++;
                    }
                } else{
                    for(int i=0;i<n;i++){
                        if(arr[i]%2==1) break;
                        s++;
                    }
                }
                if(arr[n-1]%2==1){
                    for(int i=n-1;i>=0;i--){
                        if(arr[i]%2==0) break;
                        e++;
                    }
                } else{
                    for(int i=n-1;i>=0;i--){
                        if(arr[i]%2==1) break;
                        e++;
                    }
                }
                System.out.println(Math.min(s,e));
            }
        }

        sc.close();
    }
}
