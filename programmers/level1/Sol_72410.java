package programmers.level1;

public class Sol_72410 {
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();

        StringBuilder step2 = new StringBuilder();
        for (int i = 0; i < step1.length(); i++) {
            char ch = step1.charAt(i);
            if ((ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) || ch == 45 || ch == 95 || ch == 46) {
                // [^-_.a-z0-9]
                step2.append(ch);
            }
        }

        String step3 = String.valueOf(step2).replaceAll("[.]{2,1000}", ".");
                                                        // [.]{2,}

        String step4 = step3.replaceAll("^[.]", "").replaceAll("[.]$", "");
                                        // ^[.]|[.]$

        String step5 = step4.isBlank() ? "a" : step4;

        StringBuilder step5to6;
        String step6;
        if (step5.length() >= 16) {
            step5to6 = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                step5to6.append(step5.charAt(i));
            }
            step6 = String.valueOf(step5to6).replaceAll("[.]$", "");
        } else step6 = step5;

        StringBuilder step6to7;
        String step7;
        if (step6.length() <= 2) {
            step6to7 = new StringBuilder(step6);
            int lastIndex = step6.length() - 1;
            while (step6to7.length() < 3) {
                step6to7.append(step6.charAt(lastIndex));
            }
            step7 = String.valueOf(step6to7);
        } else step7 = step6;

        return step7;
    }
}
