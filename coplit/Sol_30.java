package coplit;

/* rotatedArraySearch */
public class Sol_30 {
    public int rotatedArraySearch(int[] rotated, int target) {
        // 시간복잡도 O(N) 풀이
        // int answer = -1;
        // for (int i = 0; i < rotated.length; i++) {
        // 	if (rotated[i] == target) answer = i;
        // }
        // return answer == -1 ? -1 : answer;


        // 시간 복잡도 O(logN) 이진 탐색 풀이
        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (rotated[middle] == target) {
                return middle;
            }
            // 절반 기준 왼쪽이 오름차순 정렬되어 있는 경우
            if (rotated[left] < rotated[middle]) {
                if (rotated[left] <= target && target < rotated[middle]) {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            // 절반 기준 왼쪽이 오름차순 정렬되어 있는 경우
            else {
                if (rotated[middle] < target && target <= rotated[right]) {
                    left = middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
