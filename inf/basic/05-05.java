import java.util.*;

public class Main {
    public int solution(String str) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                st.push('(');
            else {
                st.pop();
                if (str.charAt(i-1) == '(') {
                    ans += st.size();
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(m.solution(str));
    }
}
