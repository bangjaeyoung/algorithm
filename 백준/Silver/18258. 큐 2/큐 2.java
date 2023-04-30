import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            switch (oper) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.offer(last);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}