import java.util.*;

public class Main {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> que = new LinkedList<>();
        for (char c : need.toCharArray()) {
            que.offer(c);
        }
        for (char c : plan.toCharArray()) {
            if (que.contains(c)) {
                if (que.poll() != c) return "NO";
            }
        }
        if (!que.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(main.solution(a, b));
    }
}
