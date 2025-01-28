import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesisHelper(int n, int closed, int open, String current, List<String> result) {
        if (open == n && closed == n) {
            result.add(current); 
            return;
        }
        if (open > n || closed > open) {
            return; 
        }
        generateParenthesisHelper(n, closed, open + 1, current + "(", result);
        generateParenthesisHelper(n, closed + 1, open, current + ")", result);
    }
}
