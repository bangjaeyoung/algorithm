import java.util.*;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println(main.solution(n, arr));
    }

    private Character solution(int n, int[] arr) {
        Arrays.sort(arr);
        for (int i=0; i<n-1; i++)
            if (arr[i] == arr[i+1])
                return 'D';
        return 'U';
    }
}
