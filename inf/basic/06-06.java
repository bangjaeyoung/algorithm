import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int a : main.solution(n, arr))
            System.out.print(a + " ");
    }

    private List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        for (int i = 0; i < n; i++)
            if (arr[i] != copyArr[i])
                answer.add(i + 1);
        return answer;
    }
}
