package programmers.level0;

public class Sol_120921 {
    public int solution(String A, String B) {
        int result = 0;
        StringBuilder AtoB = new StringBuilder(A);

        // hello -> ohello -> ohell
        while (result < A.length()) {
            if (String.valueOf(AtoB).equals(B)) return result;

            AtoB.insert(0, AtoB.charAt(AtoB.length() - 1));
            AtoB.deleteCharAt(AtoB.length() - 1);
            result++;
        }

        return -1;
    }
}
//     < 더 효율적인 풀이 >
//     public class Sol_120921 {
//         public int solution(String A, String B) {
//             String tempB = B.repeat(2);
//             return tempB.indexOf(A);
//         }
//     }
