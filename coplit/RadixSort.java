package coplit;

public class RadixSort {
    public int[] solution(int[] arr) {
        // 몇의 자리까지 비교할지는 배열 요소 중 최대값에 따라 정해지기 때문에, 먼저 최대값을 구함
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }

        // 일의 자리부터 최대값의 최대 자리까지 비교함
        for (int digit = 1; digit <= maxValue; digit *= 10) {
            arr = countingSort(arr, digit);
        }
        return arr;
    }

    public int[] countingSort(int[] arr, int digit) {
        int[] temp = new int[arr.length]; // 임시로 값을 할당할 공간
        int[] counting = new int[10]; // 0 ~ 9까지 카운팅할 배열

        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10; // 해당 자리수의 숫자 추출
            counting[num]++;
        }

        // 일의 자릿수만 이용하는 기존 계수 정렬과는 다르게, 여러 자릿수를 이용하기 때문에 누적합을 구함
        // 구한 누적합은 temp 배열의 인덱스에 쓰임
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 안정적으로 오름차순 정렬하기 위해, 맨 뒷 요소부터 시작
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = (arr[i] / digit) % 10;
            counting[num]--;
            temp[counting[num]] = arr[i];
        }
        return temp;
    }
}
