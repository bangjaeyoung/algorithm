package 프로그래머스.lv0;

public class Sol_120907 {
    public static String calculate(String num1, String operator, String num2) {
        int result = 0;

        switch (operator) {
            case "+":
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "-":
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
        }
        return String.valueOf(result);
    }

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] partsOfEquation = quiz[i].split(" ");
            if (calculate(partsOfEquation[0], partsOfEquation[1], partsOfEquation[2]).equals(partsOfEquation[4]))
                answer[i] = "O";
            else answer[i] = "X";
        }
        return answer;
    }
}

/**
 * class Sol_120907 {
 *     public String[] solution(String[] quiz) {
 *         for (int i = 0; i < quiz.length; i++) {
 *             String[] partsOfEquation = quiz[i].split(" ");
 *             int result = Integer.parseInt(partsOfEquation[0]) + (Integer.parseInt(partsOfEquation[2]) * (partsOfEquation[1].equals("+") ? 1 : -1));
 *             quiz[i] = result == Integer.parseInt(partsOfEquation[4]) ? "O" : "X";
 *         }
 *         return quiz;
 *     }
 * }
 */
