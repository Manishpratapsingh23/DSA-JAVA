import java.util.*;

public class Toggle{
//://telegram.me/PLACEMENTLELO

    public static List<Integer> getPossibleDigits(Map<Integer, String> validDigits, String fd) {
        List<Integer> potd = new ArrayList<>();
        
        for (Map.Entry<Integer, String> entry : validDigits.entrySet()) {
            int mismatches = 0;
            String pattern = entry.getValue();
            //://telegram.me/PLACEMENTLELO

            for (int i = 0; i < fd.length(); i++) {
                if (fd.charAt(i) != pattern.charAt(i)) {
                    mismatches++;
                }
            }
            //://telegram.me/PLACEMENTLELO

            if (mismatches <= 1) {
                potd.add(entry.getKey());
            }
        }
        
        return potd;
    }
//://telegram.me/PLACEMENTLELO

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        
        List<String> segd = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            segd.add(scanner.nextLine().strip());
        }
        //://telegram.me/PLACEMENTLELO

        List<String> placementlelo = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            placementlelo.add(scanner.nextLine().strip());
        }
//://telegram.me/PLACEMENTLELO

        Map<Integer, String> digp = new HashMap<>();
        
        for (int digit = 0; digit < 10; digit++) {
            StringBuilder pattern = new StringBuilder();
            for (int row = 0; row < 3; row++) {
                pattern.append(segd.get(row).substring(digit * 3, (digit + 1) * 3));
            }
            digp.put(digit, pattern.toString());
        }
//://telegram.me/PLACEMENTLELO

        List<List<Integer>> possibleNumbers = new ArrayList<>();
        
        for (int i = 0; i < placementlelo.get(0).length() / 3; i++) {
            StringBuilder fd = new StringBuilder();
            for (int row = 0; row < 3; row++) {
                fd.append(placementlelo.get(row).substring(i * 3, (i + 1) * 3));
            }
          //://telegram.me/PLACEMENTLELO
  
            List<Integer> matchingDigits = getPossibleDigits(digp, fd.toString());
            
            if (matchingDigits.isEmpty()) {
                System.out.print("Invalid");
                return;
            }
            possibleNumbers.add(matchingDigits);
        }
//://telegram.me/PLACEMENTLELO

        int totalSum = 0;
        for (List<Integer> combination : getCombinations(possibleNumbers)) {
            StringBuilder number = new StringBuilder();
            for (int digit : combination) {
                number.append(digit);
            }
            totalSum += Integer.parseInt(number.toString());
        }
//://telegram.me/PLACEMENTLELO

        System.out.print(totalSum);
    }

    public static List<List<Integer>> getCombinations(List<List<Integer>> possibleNumbers) {
        List<List<Integer>> result = new ArrayList<>();
        gch(possibleNumbers, 0, new ArrayList<>(), result);
        return result;
    }

    private static void gch(List<List<Integer>> possibleNumbers, int index, List<Integer> curcom, List<List<Integer>> result) {
        if (index == possibleNumbers.size()) {
            result.add(new ArrayList<>(curcom));
            return;
        }
////://telegram.me/PLACEMENTLELO

        for (int digit : possibleNumbers.get(index)) {
            curcom.add(digit);
            gch(possibleNumbers, index + 1, curcom, result);
            curcom.remove(curcom.size() - 1);
        }
    }
//://telegram.me/PLACEMENTLELO

    public static void main(String[] args) {
        solve();
    }
}