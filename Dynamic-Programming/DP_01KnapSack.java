/*
 * Problem statement
A thief robbing a store can carry a maximal weight of W into his knapsack. 
There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' 
What would be the maximum value V, that the thief can steal?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51
 */
 // #### Companies** paytm, Algo8
public class DP_01KnapSack {
    public static int knapsack(int n, int[] weights, int[] values, int maxWeight) {
		//Your code goes here
        return knapsack(n, 0, weights, values, maxWeight);
	}
    public static int knapsack(int n,int index, int[] weights, int[] values, int maxWeight) {
        if(n==index || maxWeight==0) return 0;

        if(weights[index]>maxWeight){
            return knapsack(n, index+1, weights, values, maxWeight);
        }
        int op1=knapsack(n, index+1, weights, values, maxWeight);
        int op2=values[index]+knapsack(n, index+1, weights, values, maxWeight-weights[index]);
        return Math.max(op1,op2);
    }
    public static void main(String[] args) {
        int n=4;
        int wl=5;
        int weight[]={1,2,4,5};
        int value[]={5,4,8,6};
        System.out.println(knapsack(n, weight, value, wl));
    }
}
