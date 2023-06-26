package baekjoon.bronze;

import java.util.Scanner;

public class Sol_2083 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //여러 회원의 이름, 나이, 몸무게 받기
        while (true) {
            String inputName = sc.next();
            int inputAge = sc.nextInt();
            int inputWeight = sc.nextInt();

            // 이름, 나이, 몸무게가 각각 #, 0, 0일 때 반복문 멈추기
            if (inputName.equals("#") && inputAge == 0 && inputWeight == 0) {
                break;
            }

            //회원 분류 변수 선언
            String category = "";

            //17세 초과, 몸무게 80 이상 -> senior
            //나머지 -> junior
            if (inputAge > 17 || inputWeight >= 80) category = "Senior";
            else category = "Junior";

            //회원 정보 출력
            System.out.println(inputName + " " + category);
        }
    }
}