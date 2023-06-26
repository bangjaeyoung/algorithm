package 프로그래머스.lv0;

public class Sol_120885 {
    public String solution(String bin1, String bin2) {

        int bin1ToDecimal = Integer.parseInt(bin1, 2);
        int bin2ToDecimal = Integer.parseInt(bin2, 2);

        int answer = bin1ToDecimal + bin2ToDecimal;

        return Integer.toBinaryString(answer);
    }
}
