package coplit;

// dynamic programming: O(N)
public class LSCS {
    public int solution(int[] arr) {
        int subArrSum = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            subArrSum = Math.max(subArrSum + arr[i], arr[i]);
            max = Math.max(max, subArrSum);
        }
        return max;
    }
}

//public class LSCS {
//    // dynamic programming: O(N)
//    public int solution(int[] arr) {
//        int subArrSum = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            subArrSum += arr[i];
//            if (subArrSum > max) max = subArrSum;
//            if (subArrSum < 0) subArrSum = 0;
//        }
//        return max;
//    }
//}
