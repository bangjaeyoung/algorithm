class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int depth, int sum) {
        // 마지막 노드일 경우
        if (depth == numbers.length) {
            // 최종 값과 target 값이 같으면 케이스 찾기 성공
            if (sum == target) {
                answer++;
            }
        } else {
            // +number를 합하기
            dfs(numbers, target, depth+1, sum+numbers[depth]);
            // -number를 합하기
            dfs(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}