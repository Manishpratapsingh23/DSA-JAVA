
import java.util.Random;



public class randonNumber {
    public static void main(String[] args) {
        int si=10;
        int ei=100;
        Random rn=new Random();
        for(int i=0;i<10;i++){
            int x=rn.nextInt(ei-si+1);
            System.out.print(x+" ");
        }

    }


}
