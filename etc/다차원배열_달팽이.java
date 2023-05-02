//  1  2  3  4 5
// 16 17 18 19 6
// 15 24 25 20 7
// 14 23 22 21 8
// 13 12 11 10 9
  
public class Solution {
  public void solution(int size) {
    int[][] answer = new int[size][size];
    int print = size; // 한 행, 열이 끝나면 감소될 값
    int start = 1;    // 1씩 증가되면서 배열에 추가될 값
    int width = 0;    // 열
    int length = -1;  // 행
    int control = 1;  // →, ↓ / ←, ↑을 조절할 값
    
    for (int i = 0; i < size; i++) {
      // 행 작업
      for (int j = 0; j < print; j++) {
        length += control;
        answer[width][length] = start;
        start++;
      }
      
      print--;
      
      // 열 작업
      for (int j = 0; j < print; j++) {
        width += control;
        answer[width][length] = start;
        start++;
      }
      
      // 방향 바꾸기
      control *= -1;
    }
    
    // 출력
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(answer[i][j] + " ");
      }
      System.out.println();
    }
  }
}
