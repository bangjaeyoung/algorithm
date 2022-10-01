package programmers.level1;

// 인자 n을 받으면, n만큼 '수박수박..' 패턴을 가지는 문자열을 반환하라.
// 1. 반복문을 통해, n을 1씩 줄여가며 '수', '박'을 붙임
// 2. n이 0이 되는 순간, 반복문을 멈추고 문자열 반환
public class Sol_12922 {
    public String solution(int n) {

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append("수");
            n--;
            if (n == 0) {
                break;
            }

            sb.append("박");
            n--;
            if (n == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
