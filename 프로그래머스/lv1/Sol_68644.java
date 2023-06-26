package programmers.level1;

import java.util.Set;
import java.util.TreeSet;

// 배열의 요소들 중 두 개를 뽑아 더해서 만들 수 있는 모든 수를 오름차순으로 정렬
// 1. 배열의 모든 요소들 중 두 개를 뽑아 더한 값들을 Set에 추가
// 2. 중복되는 값이 없고, 자동으로 오름차순 정렬되도록 TreeSet을 이용
// 3. int 타입의 배열로 변환 후 반환
public class Sol_68644 {
    public int[] solution(int[] numbers) {

        Set<Integer> answer = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
