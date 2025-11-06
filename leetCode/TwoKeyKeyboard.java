public class TwoKeyKeyboard {
    public static void main(String agrs[]){
        System.out.println(minSteps(4));
        System.out.println(minSteps(4));
        System.out.println(minSteps(7));
        System.out.println(minSteps(9));
        System.out.println(minSteps(24));
    }

    private static int minSteps(int n){

        return 1+helper(n, "A", "A");
    }

    private static int helper(int n, String screen, String clipboard){
        if(screen.length()>n) return Integer.MAX_VALUE;
        if(screen.length()==n) return 0;
        //if(c)
        int op1 = helper(n, screen.concat(clipboard), clipboard);
        int op2 = Integer.MAX_VALUE;
        if(screen.length()!=clipboard.length()){
            op2 = helper(n, screen, screen);
        }

        
        return 1+Math.min(op1, op2);
    }
}
