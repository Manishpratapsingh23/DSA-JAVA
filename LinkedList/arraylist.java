import java.util.ArrayList;

public class arraylist {
    public static void main(String args[]) {
        int arr[] = { -1, -2, -3 };
        System.out.println(arr);
        ArrayList<Integer> lst = new ArrayList<>();
        System.out.println(lst.size());
        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(1, 100); // if we specify the index where element to be added then it add that elemnt on
                         // that place and shift after elemnet by one
        lst.add(null);
        System.out.println("Before removing the element");
        System.out.println(lst);
        System.out.println(lst.size());
        System.out.println(lst.get(1));
        System.out.println(lst.get(3));
        lst.remove(0);
        System.out.println("After removing the element");
        System.out.println(lst);
        lst.set(1, 20000);
        System.out.println("After changing the element");
        System.out.println(lst);
        lst.remove(null);
        for (int i : lst)
            System.out.print(i + " ");
    }
}
