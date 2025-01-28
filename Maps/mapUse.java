
import java.util.HashMap;
import java.util.Set;

public class mapUse {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("abc",1);
        map.put("def",2);
        map.put("abc",3);
        map.put("abc1",2);
        System.out.println("Size : "+map.size());
        if(map.containsKey("abc")){
            System.out.println("has abc");
        }

        if(map.containsKey("abc1")){
            System.out.println("has abc1");
        }

        if(map.containsValue(1)){
        System.out.println("1");
        }

        if(map.containsValue(3)){
            System.out.println("3");
        }

        int y=map.get("def");
        System.out.println(y);
        int x=map.get("abc1");
        System.out.println(x);
        
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=65;i<91;i++)
        map1.put((char)(i),i);
        Set<Character> keys=map1.keySet();
        for(char ch: keys)
        System.out.println(ch+" "+map1.get(ch));
        
    }
}
