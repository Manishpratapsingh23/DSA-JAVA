public class pair<T, F> {
    /*
     * as <T > is a genreic as if i uses a int inplace of t and want to create a
     * main class which implemnets string
     * instead od int then i have to make new pair class and change all int datatype
     * to String that's why we create generic
     */
    private T first;
    private F second;

    public pair(T first, F second) {
        this.first = first;
        this.second = second;
    }

    public void setfirst(T first) {
        this.first = first;
    }

    public void setsecond(F second) {
        this.second = second;
    }

    public T getfirst() {
        return first;
    }

    public F getsecond() {
        return second;
    }

}
