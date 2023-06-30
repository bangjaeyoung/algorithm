import java.util.*;

public class Main {
    public char solution(int n, String str) {
        Map<Character, Integer> candidates = new HashMap<>();
        char ans = ' ';
        int max = Integer.MIN_VALUE;
        for (char a : str.toCharArray()) {
            candidates.put(a, candidates.getOrDefault(a, 0)+1);
        }
        for (char key : candidates.keySet()) {
            Integer value = candidates.get(key);
            if (value > max) {
                max = value;
                ans = key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.print(main.solution(n, str));
    }
}
