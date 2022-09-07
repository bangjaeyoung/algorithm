package baekjoon.silver;

public class Sol_4673 {
    public static void main(String[] args) {

        // 1부터 10000까지
        boolean[] arr = new boolean[10001];

        // 셀프 넘버가 아닌 수 체크
        for (int i = 1; i < 10001; i++) {

            int n = d(i);

            if (n <= 10000) {
                arr[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        // 셀프 넘버인 수 출력
        for (int i = 1; i < 10001; i++) {

            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }


    // 셀프 넘버가 아닌 수를 구하는 함수
    public static int d(int num) {

        int sum = num;

        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }

        return sum;
    }
}
