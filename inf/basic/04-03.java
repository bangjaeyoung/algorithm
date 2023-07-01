import java.util.*;

public class Main {
    public List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new LinkedList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
      	for (int i = 0; i < k-1; i++) 
          	hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
      	int lt = 0;
      	for (int rt = k-1; rt < n; rt++) {
          	hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0)+1);
      		answer.add(hashMap.size());
      		hashMap.put(arr[lt], hashMap.get(arr[lt])-1);
      		if (hashMap.get(arr[lt]) == 0) 
              	hashMap.remove(arr[lt]);
      		lt++;
        }
      	return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int a : main.solution(n, k, arr)) 
          	System.out.print(a + " ");
    }
}
