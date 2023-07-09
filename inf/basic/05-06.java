import java.util.*;

public class Main {
    public int solution(int n, int k) {
        int cnt = 1;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            que.offer(i);
        while (que.size() > 1) {
            if (cnt == k) {
                que.poll();
                cnt = 1;
            }
            else {
                que.offer(que.poll());
                cnt++;
            }
        }
        return que.poll();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(main.solution(n, k));
    }
}
