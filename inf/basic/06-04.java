import java.util.Scanner;

public class Main {
    private int[] solution(int cacheSize, int workSize, int[] workArr) {
        int[] cacheArr = new int[cacheSize];
        for (int work : workArr) {
            int pos = -1;
            for (int i=0; i<cacheSize; i++)
                if (work == cacheArr[i])
                    pos = i;
            if (pos == -1)
                for (int i=cacheSize-1; i>=1; i--)
                    cacheArr[i] = cacheArr[i-1];
            else
                for (int i=pos; i>=1; i--)
                    cacheArr[i] = cacheArr[i-1];
            cacheArr[0] = work;
        }
        return cacheArr;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for (int a : main.solution(s, n, arr))
            System.out.print(a + " ");
    }
}
