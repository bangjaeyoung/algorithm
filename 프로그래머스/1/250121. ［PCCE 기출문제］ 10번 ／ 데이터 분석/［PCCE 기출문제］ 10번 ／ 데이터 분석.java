import java.util.List;
import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> typeList = Arrays.asList("code", "date", "maximum", "remain");

        int extIdx = typeList.indexOf(ext);
        int sortIdx = typeList.indexOf(sort_by);

        return Arrays.stream(data)
            .filter(e -> e[extIdx] < val_ext)
            .sorted((o1, o2) -> o1[sortIdx] - o2[sortIdx])
            .toArray(int[][]::new);
    }
}
