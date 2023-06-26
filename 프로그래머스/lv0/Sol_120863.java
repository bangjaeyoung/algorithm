package 프로그래머스.lv0;

public class Sol_120863 {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" ");
        int coefficient = 0;
        int constant = 0;

        for (String ar : arr) {
            if (ar.equals("+")) continue;

            if (ar.contains("x")) {
                String temp = ar.replace("x", "");
                // x 계수가 1이면
                if (temp.equals("")) coefficient += 1;
                else coefficient += Integer.parseInt(temp);
            }
            // 상수이면
            else constant += Integer.parseInt(ar);
        }

        StringBuilder result = new StringBuilder();

        if (coefficient > 1) {
            result.append(coefficient).append("x");
            if (constant != 0) result.append(" + ").append(constant);
        } else if (coefficient == 1) {
            result.append("x");
            if (constant != 0) result.append(" + ").append(constant);
        } else if (constant != 0) result.append(constant);

        return String.valueOf(result);
    }
}
