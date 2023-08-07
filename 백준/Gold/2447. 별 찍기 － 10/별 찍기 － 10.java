import java.util.Scanner;

public class Main {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new char[n][n];

        star(0, 0, n, false);

        // 별이 모두 찍힌 뒤, 출력하는 과정
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans.append(arr[i][j]);
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }

    // 별 찍는 메서드
    static void star(int x, int y, int n, boolean blank) {
        // 공백이 들어가야 되는 경우
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 재귀로 끝까지 들어가서 *이 찍어야 되는 경우
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
 
        // 3의 제곱수만큼 재귀가 반복되므로
        int size = n / 3;
        int cnt = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                cnt++;
                
                // 총 9개의 칸 중 5번째 칸에는 공백이 들어가야 함
                if (cnt == 5) {
                    star(i, j, size, true);
                }
                // 5번째 칸을 제외한 칸에는 *이 찍혀야 함
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
