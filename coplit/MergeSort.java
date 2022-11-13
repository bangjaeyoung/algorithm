package coplit;

public class MergeSort {
    public int[] solution(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
        return arr;
    }

    // 기존 배열을 절반으로 계속 나누어서, 최종적으로 요소가 1개씩 들어간 배열들로 만듬
    static void sort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    // 나뉜 두 개의 배열을 값의 순서에 맞게 병합
    static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;    // 저장할 인덱스를 기억
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        // 두 배열 중 하나의 배열이 빈 경우를 위해, 비어있지 않은 배열을 붙여줌
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
