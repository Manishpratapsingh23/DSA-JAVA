import java.Arrays;
public class leetcode_875 {
    public static void main(String args[]) {
        int arr[] = { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589,
                290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184 };
        int h = 823855818;
        demo ob = new demo();
        int ans = ob.minEatingSpeed(arr, h);
        System.out.print(ans);
    }
}

class demo {
    public int minEatingSpeed(int piles[], int h) {
        if (piles.length == 1)
            return piles[0] / h + 1;
        Arrays.sort(piles);
        int start = piles[0];
        int end = piles[piles.length - 1];
        int ans = 0;
        for (int i = 2; i <= end; i++) {
            int count = 0;
            for (int j = 0; j < piles.length; j++) {
                if (piles[j] <= i)
                    count++;
                else
                    count = count + (piles[j] / i) + 1;
            }
            if (count <= h) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
