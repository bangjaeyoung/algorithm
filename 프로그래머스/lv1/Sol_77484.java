package programmers.level1;

// 번호가 가장 많이 일치하려면, 서로 일치하는 번호 + lottos 배열의 0인 요소들이 모두 win_nums 배열의 요소들과 일치하는 수들이면 된다.
// 번호가 가장 적게 일치하려면, 서로 일치하는 번호들 이외에는 서로 다른 수들이면 된다.
class Sol_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int sameCount = 0;  // lottos와 win_nums에서 동일한 요소 개수
        int zeroCount = 0;  // lottos에서 0인 요소 개수

        for (int lotto : lottos) {
            if (lotto == 0) zeroCount++;

            for (int win_num : win_nums) {
                if (lotto == win_num) sameCount++;
            }
        }
        // 순위는 6등까지 있고, 당첨 개수와는 반비례한다.
        answer[0] = (7 - (sameCount + zeroCount) == 7) ? 6 : 7 - (sameCount + zeroCount);
        answer[1] = (7 - sameCount == 7) ? 6 : 7 - sameCount;

        return answer;
    }
}
