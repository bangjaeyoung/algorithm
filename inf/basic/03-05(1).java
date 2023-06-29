import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int ans = 0, cnt = 1;
        n--;
        while (n > 0) {
            n -= ++cnt;
            if (n % cnt == 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(main.solution(n));
    }
}
