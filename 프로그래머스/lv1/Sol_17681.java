package programmers.level1;

// 1. 배열 arr1와 arr2를 모두 2진수로 나타냄
// 2. 두 배열을 더함
// 3. 더해서 1과 2를 가지면 #으로, 0일 경우는 공백으로 전환
// 4. 최종 배열을 반환
public class Sol_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        // 배열 arr1를 2진수로 바꿔 넣어줄 배열
        String[] arr1ToBinary = new String[n];
        // 배열 arr2를 2진수로 바꿔 넣어줄 배열
        String[] arr2ToBinary = new String[n];

        // 마지막으로 #과 공백으로 바꿔 넣어줄 배열
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // n자리 만큼의 2진수로 표현
            arr1ToBinary[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            arr2ToBinary[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));

            // 2진수로 바꾼 두 배열을 n자리 만큼 표현
            answer[i] = String.format("%0" + n + "d", Long.parseLong(arr1ToBinary[i]) + Long.parseLong(arr2ToBinary[i]));

            // 두 배열에서 더한 값이 1과 2이면 #으로, 0일 경우 공백으로 바꿈
            answer[i] = answer[i].replaceAll("[1-2]", "#").replaceAll("0", " ");
        }

        return answer;
    }
}
