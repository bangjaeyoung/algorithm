package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol_10828 {

    public static void main(String[] args) throws IOException {

        Stack<String> newStack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push":
                    newStack.push(st.nextToken());
                    break;

                case "pop":
                    if (newStack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(newStack.pop()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(newStack.size()).append("\n");
                    break;

                case "empty":
                    if (newStack.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "top":
                    if (newStack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(newStack.peek()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
