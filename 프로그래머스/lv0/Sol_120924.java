package 프로그래머스.lv0;

public class Sol_120924 {
    public int solution(int[] common) {
        int difference = common[1] - common[0];

        if (common[2] - common[1] == difference) return common[common.length - 1] + difference;
        else return common[common.length - 1] * (common[2] / common[1]);
    }
}
