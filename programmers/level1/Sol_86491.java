package programmers.level1;

// 1. sizes 배열의 요소들을 [명함의 긴 쪽, 명함의 짧은 쪽]으로 정렬
// 2. 명함의 긴 쪽 중 가장 큰 값을 지갑의 가로 길이로 설정
// 3. 명함의 짧은 쪽 중 가장 큰 값을 지갑의 세로 길이로 설정
// 4. 지갑의 가로 길이와 세로 길이의 곱을 반환
public class Sol_86491 {
    public int solution(int[][] sizes) {

        // 최종적으로 할당할 지갑의 가로, 세로 길이 변수 선언
        int maxWidth = -1;
        int maxHeight = -1;

        for (int[] size : sizes) {

            int width = size[0];
            int height = size[1];

            // 각 배열 행의 첫 요소는 큰 값, 두 번째 요소는 작은 값으로 설정
            size[0] = Math.max(width, height);
            size[1] = Math.min(width, height);

            // 가장 큰 가로 길이와 세로 길이를 찾는 과정
            maxWidth = Math.max(maxWidth, size[0]);
            maxHeight = Math.max(maxHeight, size[1]);
        }

        return maxWidth * maxHeight;
    }
}
