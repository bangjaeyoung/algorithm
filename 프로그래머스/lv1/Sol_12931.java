package programmers.level1;

public class Sol_12931 {

    // 1. 인자로 받은 자연수를 문자열로 변환
    // 2. 그 문자열을 크기만큼 배열 생성
    // 3. 문자열을 하나하나씩 문자로 변환하여 배열 첫 번째 인덱스부터 저장
    // 4. 저장과 동시에 answer에 덧셈

    public int solution(int n) {

        int answer = 0;

        String str = Integer.toString(n);

        char[] arr = new char[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
            answer += arr[i] - '0';
        }

        return answer;
    }
}
