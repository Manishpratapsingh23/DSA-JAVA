
import java.util.HashMap;

public class intersectionOfArray {
    private static void intersection(int arr1[],int arr2[]){
        if (arr1.length == 0 || arr2.length == 0)
            return;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                System.out.println(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,3,4,5,6,7,13,14,8,9,14,17,11,12};
        int arr2[]={12,13,1,5,8,8,2,2,2,3,3,3,19,15,16,10,8};
        intersection(arr1,arr2);
    }
}
