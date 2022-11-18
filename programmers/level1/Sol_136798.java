package programmers.level1;

class Sol_136798 {
    public int solution(int number, int limit, int power) {
        int[] divisorsArr = new int[number + 1];    // 인덱스 값에 맞게끔 +1 길이만큼의 배열 생성
        int totalWeightOfIron = 0;

        for (int i = 1; i < divisorsArr.length; i++) {
            if (countDivisors(i) > limit) divisorsArr[i] = power;
            else divisorsArr[i] = countDivisors(i);
            totalWeightOfIron += divisorsArr[i];
        }
        return totalWeightOfIron;
    }

    static int countDivisors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }

//    시간 복잡도가 작은 코드
//    public int solution(int number, int limit, int power) {
//        int[] count = new int[number + 1];
//        for (int i = 1; i <= number; i++) {
//            for (int j = 1; j <= number / i; j++) {
//                count[i * j]++;
//            }
//        }
//        int answer = 0;
//        for (int i = 1; i <= number; i++) {
//            if (count[i] > limit) {
//                answer += power;
//            } else {
//                answer += count[i];
//            }
//        }
//        return answer;
//    }
}
