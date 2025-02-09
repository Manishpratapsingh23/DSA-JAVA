
import java.util.ArrayList;
import java.util.Arrays;

public class AutoCompleteUse {
    public static void main(String[] args) {
        ArrayList<String> words=new ArrayList<>();
        String st="do dont no not note notes den";
        words.addAll(Arrays.asList(st.split(" ")));
        AutoComplete ac=new AutoComplete();
        ac.autoComplete(words, "no");
    }
}
