package programmers.level1;

public class Sol_12901 {
    public String solution(int a, int b) {

        // 2016년 1월 1일은 금요일이므로, 금요일부터 시작
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        // 윤년이므로, 2월은 29일까지 있음
        int[] daysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDays = 0;

        // a월 b일까지의 일수를 구함
        for (int i = 0; i < a - 1; i++) {
            sumDays += daysPerMonth[i];
        }
        sumDays += b;

        // days배열의 (0 - 1)번째 요소를 가리킬 경우, 범위 에러가 나므로, 따로 예외 처리
        if (sumDays % 7 == 0) return days[days.length - 1];

        return days[sumDays % 7 - 1];
    }
}
