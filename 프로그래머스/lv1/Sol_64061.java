package programmers.level1;

public class Sol_64061 {
    public int solution(int[][] board, int[] moves) {
        int saveCount = 0;  // 바구니에 쌓인 개수
        int removeCount = 0;    // 바구니에서 없어지는 개수
        int[] basket = new int[1000];   // 1000개까지 쌓일 수 있음
        int lineCount = board.length;    // board의 행 개수

        for (int move : moves) {
            for (int i = 0; i < lineCount; i++) {
                if (board[i][move - 1] != 0) {
                    basket[saveCount] = board[i][move - 1];
                    saveCount++;
                    board[i][move - 1] = 0;

                    if (saveCount >= 2) {   // 바구니에 2개 이상 쌓였을 경우
                        if (basket[saveCount - 1] == basket[saveCount - 2]) {
                            basket[saveCount - 1] = 0;
                            basket[saveCount - 2] = 0;
                            saveCount -= 2;
                            removeCount += 2;
                        }
                    }
                    break;
                }
            }
        }
        return removeCount;
    }
}
