import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(main.solution(n, m, arr));
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else
                lt = mid + 1;
        }

        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;

        for (int a : arr) {
            if (sum + a > capacity) {
                cnt++;
                sum = a;
            } else
                sum += a;
        }

        return cnt;
    }
}
