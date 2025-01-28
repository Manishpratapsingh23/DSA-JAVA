class demo {
    private int a = 10;

    public void print() {
        int a = 20;
        System.out.println(this.a);
        System.out.println(a);
    }

}

class this_keyword_use {
    public static void main(String args[]) {
        demo ob = new demo();
        ob.print();
    }
}
// output
// 10
// 20
