package programmers.level1;

import java.util.Arrays;

// 1. commands 배열의 행의 길이만큼 길이를 가진 answer 배열을 생성
// 2. for문을 통해,
// 2-1. commands 요소의 첫 요소부터 두 번째 요소까지의 인덱스 범위의 값들을 가진 arr 배열을 생성
// 2-2. arr 배열을 오름차순으로 정렬
// 2-3. arr 배열의 commands 요소의 세 번째 요소의 수를 answer 배열에 저장
// 3. answer 배열 반환
class Sol_42748 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            Arrays.sort(arr);

            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }
}
