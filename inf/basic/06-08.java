import java.util.*;

class Main {
  public static void main(String[] args) {
    Main main = new Main();
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt(), m = sc.nextInt();
    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    
    System.out.println(main.solution(n, m, arr));
  }
  
  private int solution(int n, int target, int[] arr) {
    int answer = 0;
    int lt = 0, rt = n - 1;
    
    Arrays.sort(arr);
    
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      
      if (arr[mid] == target) {
        answer = mid + 1;
        break;
      } else if (arr[mid] > target) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
    
    return answer;
  }
}
