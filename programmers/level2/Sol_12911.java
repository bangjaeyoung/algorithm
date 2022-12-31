package programmers.level2;

public class Sol_12911 {
    public int solution(int n) {
        int theNumberOfOne = countOneInBinaryString(n);

        while (true) {
            int theTempNumberOfOne = countOneInBinaryString(++n);

            if (theNumberOfOne == theTempNumberOfOne) break;
        }

        return n;
    }

    static int countOneInBinaryString(int num) {
        int theNumberOfOne = 0;
        String binaryString = Integer.toBinaryString(num);

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') theNumberOfOne++;
        }

        return theNumberOfOne;
    }
}
