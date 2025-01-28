public class Solution 
{    
    public static int getFourthLargest(int[] arr) 
    {
        // Your code goes here
        int t=0;
       if (arr == null || arr.length < 4) {
            return Integer.MIN_VALUE;
        }
            for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<=arr.length;j++)
            {
                if(arr[i]<=arr[j])
                {
                    t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        return(arr[3]);
       
    }
}