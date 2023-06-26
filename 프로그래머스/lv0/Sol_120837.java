package 프로그래머스.lv0;

// 인자로 받은 hp에 맞게, 최소한 몇 마리의 개미가 필요한가?
// hp가 5이상일 때, 장군개미
// hp가 5미만 3이상일 때, 병정개미
// hp가 3미만 0이상일 때, 일개미
public class Sol_120837 {
    public int solution(int hp) {

        int cnt = 0;

        while (hp > 0) {

            if (hp >= 5) {
                hp -= 5;
                cnt++;
            }
            else if (hp >= 3) {
                hp -= 3;
                cnt++;
            }
            else {
                hp -= 1;
                cnt++;
            }
        }
        return cnt;
    }
}
