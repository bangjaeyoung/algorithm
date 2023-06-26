package baekjoon.silver;

import java.io.*;

public class Sol_11729 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 원판을 옮기는 총 횟수 출력
        bw.write((int) Math.pow(2, N) - 1 + "\n");

        hanoi(N, 1, 3, 2);

        bw.flush();
        bw.close();
    }

    public static void hanoi(int circularDiskCount, int startColumn, int lastColumn, int otherColumn) throws IOException {

        // 마지막으로 가장 큰 원판을 시작 기둥에서 최종 기둥으로 옮김
        if (circularDiskCount == 1) {
            bw.write(startColumn + " " + lastColumn + "\n");
            return;
        }

        // n-1개의 원판을 시작 기둥에서 나머지 기둥으로 옮김
        hanoi(circularDiskCount - 1, startColumn, otherColumn, lastColumn);

        // n번째 원판을 시작 기둥에서 마지막 기둥으로 옮김
        bw.write(startColumn + " " + lastColumn + "\n");

        // n-1개의 원판을 나머지 기둥에서 최종 기둥으로 옮김
        hanoi(circularDiskCount - 1, otherColumn, lastColumn, startColumn);
    }
}
