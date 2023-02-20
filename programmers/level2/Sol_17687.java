package programmers.level2;

/*
1. n진수로 변환한 숫자들을 정의한다. (baseNumList)
1-1. baseNumList의 길이가 (t * m)일 때까지만 숫자를 추가하는 이유는 최대 (t * m)까지만 사용할 것이고, 불필요한 용량을 줄이기 위해서이다.
2. (p - 1)부터 시작해서 m씩 증가하며 정답 문자열에 숫자 문자를 추가해준다.
3. 10 ~ 15까지는 A ~ F로 출력하므로, 마지막에 나오는 소문자들을 모두 대문자로 변환 후 정답으로 반환한다.
 */
public class Sol_17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder baseNumList = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i <= t * m; i++) {
            if (baseNumList.length() == t * m) break;
            baseNumList.append(Integer.toString(i, n));
        }

        for (int i = p - 1; i <= baseNumList.length(); i += m) {
            if (answer.length() == t) break;
            answer.append(String.valueOf(baseNumList).charAt(i));
        }

        return String.valueOf(answer).toUpperCase();
    }
}
