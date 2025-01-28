public class pairUse {
    public static void main(String[] args) {
        System.out.println("###########   GENERIC  1  ############");

        pair<Integer, Integer> pInt = new pair<>(1, 2);
        pInt.setfirst(10);
        pInt.setsecond(20);
        System.out.println("first  is " + pInt.getfirst());
        System.out.println("second  is " + pInt.getsecond());
        System.out.println("###########   GENERIC 2   ############");
        pair<String, String> pString = new pair<>("Manish", "Kartikay");
        pString.setfirst("Adhya");
        pString.setsecond("Akshay");
        System.out.println("first  is " + pString.getfirst());
        System.out.println("second  is " + pString.getsecond());

        System.out.println("###########   MULTI-VALUED GENERIC 1   ############");

        pair<Integer, String> p2 = new pair<>(1, "abc");
        p2.setfirst(100);
        p2.setsecond("Adhya");
        System.out.println("first  is " + p2.getfirst());
        System.out.println("second  is " + p2.getsecond());
        System.out.println("###########    MULTI-VALUED GENERIC 2   ############");
        pair<String, Character> p1 = new pair<>("Manish", 'M');
        p1.setfirst("Akshay");
        p1.setsecond('A');
        System.out.println("first  is " + p1.getfirst());
        System.out.println("second  is " + p1.getsecond());

        System.out.println("###########   CHAINED GENERIC  TYPE  ############");

        pair<pair<Integer, String>, Character> p3 = new pair<>(p2, 'c');
        System.out.println("first  is " + p3.getfirst().getfirst());
        System.out.println("second  is " + p3.getsecond());
        System.out.println("first  is " + p3.getfirst().getsecond());
    }
}
