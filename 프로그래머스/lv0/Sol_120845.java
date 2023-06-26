package 프로그래머스.lv0;

public class Sol_120845 {
    public int solution(int[] box, int n) {
        int width = box[0];
        int depth = box[1];
        int height = box[2];

        return (width / n ) * (depth / n) * (height/ n);
    }
}
