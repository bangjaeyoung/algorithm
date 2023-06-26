package 프로그래머스.lv0;

public class Sol_120839 {
    public String solution(String rsp) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rsp.length(); i++) {

            switch (rsp.charAt(i)) {

                case '2':
                    sb.append("0");
                    break;

                case '0':
                    sb.append("5");
                    break;

                default:
                    sb.append("2");
                    break;
            }
        }

        return String.valueOf(sb);
    }
}
