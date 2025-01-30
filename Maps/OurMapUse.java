public class OurMapUse {
    public static void main(String[] args) {
        Map<String,Integer> map=new Map();
        for(int i=0;i<20;i++){
            map.insert("abc"+i,i+1);
            System.out.println("i = "+i+" Load Factor = "+map.loadFactor());
        }
        map.removeKey("abc3");
        map.removeKey("abc8");
        map.removeKey("abc20");
        for(int i=0;i<20;i++){
            System.out.println("abc"+i+": "+map.getValue("abc"+i));
        }
    }
}
