package programmers.level0;
// ** 이해 필요 ** //
class Sol_120880 {
    public int[] solution(int[] numList, int n) {
        int size = numList.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int a = (numList[i] - n) * (numList[i] > n ? 1 : -1);
                int b = (numList[j] - n) * (numList[j] > n ? 1 : -1);

                if (a > b || (a == b && numList[i] < numList[j])) {
                    int temp = numList[i];
                    numList[i] = numList[j];
                    numList[j] = temp;
                }

            }
        }
        return numList;
    }
}
