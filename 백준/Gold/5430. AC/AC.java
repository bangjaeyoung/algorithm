import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            // 입력 받는 [1,2,3,4] 문자열을 구분자를 통해 1, 2, 3, 4로 받는다.
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            AC(p, deque);
        }

        System.out.print(sb);
    }

    public static void AC(String command, Deque<Integer> deque) {
        
        // 직접 문자열을 뒤집는 것이 아닌, 순서에 대한 boolean 변수를 선언
        boolean isOriginalOrder = true;

        for (char cmd : command.toCharArray()) {
            // 문자열을 뒤집어야 할 경우
            if (cmd == 'R') {
                isOriginalOrder = !isOriginalOrder;
            }

            // 순서에 맞게 맨 앞 혹은 뒤 문자를 빼내야 할 경우
            else if (cmd == 'D') {
                if (deque.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }

                // 원래 순서일 경우, 큐와 같이 맨 앞 요소를 빼내기
                if (isOriginalOrder) {
                    deque.pollFirst();
                }

                // 뒤집힌 순서일 경우, 맨 뒤 요소를 빼내기
                else {
                    deque.pollLast();
                }
            }
        }

        makeAnswer(deque, isOriginalOrder);
    }

    // 모든 명령을 처리하고 남은 문자열을 처리하는 메서드
    private static void makeAnswer(Deque<Integer> deque, boolean isOriginalOrder) {
        sb.append("[");

        if (deque.size() > 0) {
            // 원래 순서일 경우, 앞 요소부터 빼면서 출력문에 추가
            if (isOriginalOrder) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }

            // 뒤집힌 순서일 경우, 뒷 요소부터 빼면서 출력문에 추가
            else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");
    }
}
