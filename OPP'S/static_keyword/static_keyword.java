class demo {
    private static int a = 10;

    public void print() {
        int a = 20;
        System.out.println(this.a);
        System.out.println(a);
    }

}

class static_keyword {
    public static void main(String args[]) {
        demo ob = new demo();
        ob.print();
    }
}
