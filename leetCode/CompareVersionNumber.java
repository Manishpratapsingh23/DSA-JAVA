import java.util.Scanner;

public class CompareVersionNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(compareVersion(s1,s2));
    }

    private static int compareVersion(String v1, String v2){
        int l1=v1.length();
        int l2=v2.length();
        int i=0,j=0;
        while(i<l1 && j<l2){
            int pi=i, pj = j;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while(i<l1 && v1.charAt(i)!='.') i++;
            while(j<l2 && v2.charAt(j)!='.') j++;
            int n1 = Integer.valueOf(v1.substring(pi, i));
            int n2 = Integer.valueOf(v2.substring(pj, j));
            if(n1<n2) return -1;
            if(n1>n2) return 1;
            i++;
            j++;
        }
        while(i<l1){
            int pi = i;
            int n2 = 0;
            StringBuilder sb1 = new StringBuilder();
            while(i<l1 && v1.charAt(i)!='.') i++;
            int n1 = Integer.valueOf(v1.substring(pi, i));
            if(n1>n2) return 1;
        }

        while(j<l2){
            int pj = j;
            int n1 = 0;
            StringBuilder sb2 = new StringBuilder();
            while(j<l2 && v2.charAt(j)!='.') j++;
            int n2 = Integer.valueOf(v2.substring(pj, j));
            if(n2>n1) return -1;
        }
        return 0;
    }
}