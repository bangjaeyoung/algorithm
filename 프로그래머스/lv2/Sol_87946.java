package programmers.level2;

public class Sol_87946 {
    public static boolean[] visited;
    public static int answer = -1;

    public int solution(int k, int[][] dungeons) {
        // 1. 방문을 체크하는 배열 생성
        visited = new boolean[dungeons.length];

        // 2. 던전을 하나씩 돌면서 체크
        dfs(k, dungeons, 0);

        return answer;
    }

    private void dfs(int k, int[][] dungeons, int count) {
        // 1. 탐험 가능한 최대 던전 개수를 갱신하면서 진행
        answer = Math.max(answer, count);

        // 2. 탐험 가능한 던전인지 확인 후, 던전 탐험
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == false && k >= dungeons[i][0]) {

                // 2-1. 탐험한 던전은 방문 체크
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);

                // 2-2. 하나의 탐험 과정이 끝나면 방문 체크를 원래대로
                visited[i] = false;
            }
        }
    }
}
