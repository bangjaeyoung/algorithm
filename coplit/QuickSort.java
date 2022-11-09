package coplit;

public class QuickSort {
    public int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    static void sort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        // 왼쪽 파티션에서 값이 2개 이상인 경우만 재귀 호출
        if (start < part - 1) {
            sort(arr, start, part - 1);
        }
        // 오른쪽 파티션도 값이 2개 이상인 경우만 재귀 호출
        if (part < end) {
            sort(arr, part, end);
        }
    }

    // start, end가 각각 pivot과 비교되면서 이동 및 스왑
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    // start, end 인덱스의 값을 스왑
    static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
