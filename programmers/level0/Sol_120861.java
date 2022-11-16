package programmers.level0;

public class Sol_120861 {
    public int[] solution(String[] keyInput, int[] board) {
        int[] result = new int[2];

        for (String key : keyInput) {
            switch (key) {
                case "left":
                    if (result[0] > -(board[0] / 2)) {
                        result[0] -= 1;
                    }
                    break;
                case "right":
                    if (result[0] < (board[0] / 2)) {
                        result[0] += 1;
                    }
                    break;
                case "up":
                    if (result[1] < (board[1] / 2)) {
                        result[1] += 1;
                    }
                    break;
                case "down":
                    if (result[1] > -(board[1] / 2)) {
                        result[1] -= 1;
                    }
                    break;
            }
        }
        return result;
    }
}
