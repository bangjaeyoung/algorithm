package 프로그래머스.lv0;

public class Sol_120904 {
    public int solution(int num, int k) {

        String numStr = String.valueOf(num);

        return numStr.contains(String.valueOf(k)) ? numStr.indexOf(String.valueOf(k)) + 1 : -1;
    }
}
