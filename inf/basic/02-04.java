import java.util.Scanner;

// 피보나치 수열
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Main main = new Main();
        for (int x : main.solution(n)) {
            System.out.print(x + " ");
        }
    }

    private int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr;
    }
}
