package programmers.level2;

public class Sol_42860 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minWay = len - 1;   // 초기값으로 오른쪽으로 이동할 경우로만 설정

        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);

            // A가 아닌 경우, 상하 컨트롤 중 작은 값을 더함
            if (ch != 'A') answer += Math.min(ch - 'A', 'Z' - ch + 1);

            // 다음 인덱스부터 A가 아닌 문자를 발견할 때까지 반복
            int nextIdx = i + 1;
            while (nextIdx < len && name.charAt(nextIdx) == 'A') nextIdx++;

            // i * 2(원점부터 현재 내 위치 + 현재 위치부터 원점까지) + len(문자열 길이) - nextIdx(문자열 마지막에서 nextIdx까지)
            // = 현재 위치부터 왼쪽으로 돌아 끝에서 A가 아닌 현재 위치까지의 거리
            minWay = Math.min(minWay, i * 2 + len - nextIdx);

            // 처음부터 왼쪽으로 가는 게 최적인 경우 ex) BBBBAAAAAAAB
            // (len - nextIdx) * 2 + i = 원점에서 왼쪽으로 이동, 다시 원점으로 이동한 후 현재 위치까지
            minWay = Math.min(minWay, (len - nextIdx) * 2 + i);
        }

        return answer + minWay;
    }
}
