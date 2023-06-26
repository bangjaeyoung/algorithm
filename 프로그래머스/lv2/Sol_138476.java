package programmers.level2;

import java.util.Arrays;


/**
 * 1. tangerine 배열에서 가장 큰 수 + 1 크기 만큼의 배열을 생성해준다.
 * 이 배열은 각 귤의 크기별로 귤이 몇 개씩 있는지 판단하기 위한 배열이다.
 * 2. 귤의 크기별 개수를 담은 변하지 않을 배열과 변할 배열을 각각 생성해준다.
 * 나중에 둘의 요소를 비교하여, 변한 요소들의 인덱스 개수를 구해주면 종류가 구해진다.
 * 각각 배열을 생성해줄 땐, 0인 요소들은 제외시키고 오름차순으로 정렬시켜서 생성해준다.
 * 3. 이제 변할 배열을 가지고 귤의 개수가 가장 많이 분포된 크기 종류부터 -1씩 해준다.
 * 4. 변한 배열과 변하지 않은 기존 배열과 비교하여 답을 구해주면 그 값이 서로 다른 종류의 최솟값이 된다.
 */
public class Sol_138476 {
    public int solution(int k, int[] tangerine) {
        int maxSizeOfTangerine = Arrays.stream(tangerine).max().orElse(0);

        int[] tempArr = new int[maxSizeOfTangerine + 1];

        for (int el : tangerine) tempArr[el]++;

        int[] originalSizeArr = Arrays.stream(tempArr).filter(el -> el != 0).sorted().toArray();
        int[] changingSizeArr = Arrays.stream(tempArr).filter(el -> el != 0).sorted().toArray();

        while (k > 0) {
            k -= 1;

            for (int i = changingSizeArr.length - 1; i >= 0; i--) {
                if (changingSizeArr[i] == 0) continue;

                changingSizeArr[i]--;
                break;
            }
        }

        int answer = 0;

        for (int i = 0; i < originalSizeArr.length; i++)
            if (originalSizeArr[i] != changingSizeArr[i]) answer++;

        return answer;
    }
}
