package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> moneyStack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int money = Integer.parseInt(br.readLine());

            if (money == 0) {
                moneyStack.pop();
            }
            else {
                moneyStack.push(money);
            }
        }

//        System.out.println(moneyStack.stream().reduce(0, Integer::sum));
        System.out.println(moneyStack.stream().mapToInt(e -> e).sum());
    }
}
