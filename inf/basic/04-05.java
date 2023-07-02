import java.util.*;

public class Main {
    public int solution(int n, int k, int[] arr) {
        Set<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int sum : tSet) {
            if (++cnt == k)
                return sum;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(main.solution(n, k, arr));
    }
}
