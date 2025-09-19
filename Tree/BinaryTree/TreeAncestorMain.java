
//

import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;

class TreeAncestor {
    private int n;
    private int parent[];
    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        // this approach will work for only for small queries up to 10^4
        // while(k>0 && node!=-1){
        //     node = parent[node];
        //     k--;
        // }
        // if(k!=0 && node==0) return -1;
        // return node;
    }
}

public class TreeAncestorMain{
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = sc.nextInt();
        }
        TreeAncestor ancestor = new TreeAncestor(n,parent);
        //TreeAncestor(n,parent);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(ancestor.getKthAncestor(a, b));
        }
    }
}
