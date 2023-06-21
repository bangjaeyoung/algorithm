import java.util.Scanner;

// 에라토스테네스의 채
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Main main = new Main();
        System.out.print(main.solution(n));
    }

    private int solution(int n) {
        int[] arr = new int[n+1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                count++;

                for (int j = i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }

        return count;
    }
}
