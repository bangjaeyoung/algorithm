import java.util.Scanner;

public class Main {
    static boolean[] isBrokenButtons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();

        isBrokenButtons = new boolean[10];

        // 지금 보고 있는 채널과 목표 채널이 같으면 바로 0 출력하고 종료
        if (target == 100) {
            System.out.print(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            isBrokenButtons[sc.nextInt()] = true;
        }

        // 초기 정답 값 설정
        // 100에서 목표 채널까지 (+, -)로만 이동하는 횟수
        int answer = Math.abs(target - 100);

        // 최대 채널 500_000까지 순회하면서,
        // 누를 수 있는 채널들 중에서 목표 채널까지 버튼을 누르는 횟수 구하기
        outerLoop:
        for (int i = 0; i <= 999_999; i++) {
            String channel = String.valueOf(i);

            // 부서진 버튼을 눌러야 하는 채널은 건너뜀
            for (char c : channel.toCharArray()) {
                if (isBrokenButtons[Character.getNumericValue(c)]) {
                    continue outerLoop;
                }
            }

            // 현재 채널을 누르기 위한 횟수(channel 길이) + (+, -)로만 이동하는 횟수
            int count = channel.length() + Math.abs(target - i);

            answer = Math.min(answer, count);
        }

        System.out.print(answer);
    }
}
