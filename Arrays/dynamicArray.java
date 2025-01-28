package Arrays;

class DynamicArray {
    public static void main(String[] args) {
        Demo ob = new Demo();
        for (int i = 0; i < 100; i++) {
            ob.add(i + 10);
        }
        System.out.println(ob.size());
        ob.set_index(4, 10000);
        System.out.println(ob.get(3));
        System.out.println(ob.get(4));
        System.out.println(ob.get(5));
        while (!ob.isEmpty()) {
            System.out.println(ob.removeLast());
        }

    }
}

class Demo {
    private int data[];
    private int index;

    public Demo() {
        data = new int[5];
        index = 0;
    }

    public int size() {
        return index;
    }

    public void add(int n) {
        if (index == data.length)
            restructure();
        data[index++] = n;
    }

    public void set_index(int ind, int num) {
        if (ind > index)
            System.out.println("########## NEGATIVE ############");
        else if (ind < index)
            data[ind] = num;
    }

    public int get(int ind) {
        if (ind >= data.length || ind < 0)
            return -1;
        else
            return data[ind];

    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void restructure() {
        int temp[] = data;
        data = new int[data.length * 2];
        for (int i = 0; i < index; i++)
            data[i] = temp[i];
    }

    public int removeLast() {
        if (size() == 0) {
            // error out
            return -1;
        }
        int value = data[index - 1];
        data[index - 1] = 0;
        index--;
        return value;
    }
}