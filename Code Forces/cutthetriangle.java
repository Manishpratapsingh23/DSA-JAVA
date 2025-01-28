import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            sc.nextLine();  // Consume the empty line
            
            // Read the coordinates of the three vertices
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            int x3 = sc.nextInt(), y3 = sc.nextInt();
            
            // Check if there's a valid horizontal or vertical line
            if (isValidCut(x1, y1, x2, y2, x3, y3)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static boolean isValidCut(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Check for a valid horizontal cut (distinct y-coordinates)
        if(x1!=x2 && x2!=x3  && y1!=y2 && y2!=y3 )
        return true;
        if (((y1 == y2 && y1 != y3) || (y2 == y3 && y2 != y1) || (y1 == y3 && y1 != y2))&& x1!=x2 && x2!=x3) {
            return true;
        }
        
        // Check for a valid vertical cut (distinct x-coordinates)
        if (((x1 == x2 && x1 != x3) || (x2 == x3 && x2 != x1) || (x1 == x3 && x1 != x2)) && y1!=y2 && y2!=y3) {
            return true;
        }
        
        return false;
    }
}
