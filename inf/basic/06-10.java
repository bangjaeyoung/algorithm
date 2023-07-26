import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), c = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(main.solution(n, c, arr));
    }

    private int solution(int n, int c, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = arr[1]-arr[0], rt = arr[n-1]-arr[0];

        while (lt <= rt) {
            int mid = (lt+rt)/2;

            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid+1;
            } else
                rt = mid-1;
        }

        return answer;
    }

    private int count(int[] arr, int between) {
        int cnt = 1, pos = arr[0];

        for (int i=1; i<arr.length; i++) {
            if (arr[i]-pos >= between) {
                cnt++;
                pos = arr[i];
            }
        }

        return cnt;
    }
}
