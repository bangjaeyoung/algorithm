package baekjoon.bronze;

import java.util.Scanner;

public class Sol_1264 {

    public static void main(String[] args) {

        //영문 문장 입력 받기
        Scanner scanner = new Scanner(System.in);

        //입력된 문자열이 #가 될 때까지만, 반복하기
        while (true) {
            String input = scanner.nextLine();

            if(input.equals("#")) {
                break;
            }

            //모음 갯수를 세는 변수 선언
            int count = 0;

            //받은 문장을 모두 소문자로 변경
            input = input.toLowerCase();

            //문자열의 길이만큼 반복하기
            for (int i = 0; i < input.length(); i++) {

                // 모음과 일치하면, count 1 증가
                if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
