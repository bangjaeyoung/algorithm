import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext와 sort_by에 대한 인덱스 매핑을 정의한 HashMap
        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("code", 0);
        indexMap.put("date", 1);
        indexMap.put("maximum", 2);
        indexMap.put("remain", 3);
        
        // ext와 sort_by에 대한 인덱스 가져오기
        int extIdx = indexMap.get(ext);
        int sortIdx = indexMap.get(sort_by);
        
        // 조건에 맞는 데이터 필터링하여 리스트에 추가
        List<int[]> list = new LinkedList<>();
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }
        
        // 리스트를 sort_by를 기준으로 정렬
        Collections.sort(list, Comparator.comparingInt(arr -> arr[sortIdx]));
        
        // 결과 배열에 정렬된 데이터 저장
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
