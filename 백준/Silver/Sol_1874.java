package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력받은 수열을 배열에 추가
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int startNum = 1;    // 1부터 1씩 증가될 변수
        StringBuilder sb = new StringBuilder();
        boolean result = true;    // "NO"인지 아닌지를 나타낼 변수

        for (int i = 0; i < n; i++) {
            int curNum = arr[i];

            // 1부터 특정 수열까지 1씩 증가된 수를 스택에 추가
            if (curNum >= startNum) {
                while (curNum >= startNum) {
                    stack.push(startNum++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int topNum = stack.pop();

                // 스택 제일 상단의 값과 현재 수열 값 비교
                if (topNum > curNum) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) System.out.println(sb);
    }
}
