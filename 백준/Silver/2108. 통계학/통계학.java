import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        answer.append(caculateArithmeticMean(N, arr))
                .append("\n")
                .append(calculateMedian(N, arr))
                .append("\n")
                .append(calculateMode(N, arr))
                .append("\n")
                .append(calculateRange(arr));
        
        System.out.println(answer);
    }
    
    private static int caculateArithmeticMean(int N, int[] arr) {
        int sum = Arrays.stream(arr)
                .sum();
        
        return (int) Math.round((double) sum / N);
    }
    
    private static int calculateMedian(int N, int[] arr) {
        Arrays.sort(arr);
        
        return arr[N / 2];
    }
    
    private static int calculateMode(int N, int[] arr) {
        int mode = 0;
        Map<Integer, Integer> countOfNum = new LinkedHashMap<>();
        
        for (int i = 0; i < N; i++) {
            countOfNum.put(arr[i], countOfNum.getOrDefault(arr[i], 0) + 1);
        }
        
        int maxCount = 0;
        for (int key : countOfNum.keySet()) {
            int count = countOfNum.get(key);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        int countOfMax = 0;
        for (int key : countOfNum.keySet()) {
            int count = countOfNum.get(key);
            if (count == maxCount) {
                countOfMax++;
            }
        }
        
        if (countOfMax > 1) {
            int count = 0;
            for (int key : countOfNum.keySet()) {
                if (maxCount == countOfNum.get(key)) {
                    count++;
                }
                
                if (count == 2) {
                    return key;
                }
            }
        }
        
        for (int key : countOfNum.keySet()) {
            int count = countOfNum.get(key);
            if (count == maxCount) {
                mode = key;
            }
        }
        
        return mode;
    }
    
    private static int calculateRange(int[] arr) {
        int max = Arrays.stream(arr)
                .max()
                .orElseThrow();
        
        int min = Arrays.stream(arr)
                .min()
                .orElseThrow();
        
        return max - min;
    }
}
