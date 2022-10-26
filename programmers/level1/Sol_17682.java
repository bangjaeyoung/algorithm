package programmers.level1;

public class Sol_17682 {
    public int solution(String dartResult) {

        // 초기값 설정
        int[] score = {-10000, -10000, -10000};

        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                addScore(score, dartResult.charAt(i));
                // 10일 경우
                if (Character.isDigit(dartResult.charAt(i+1))) {
                    score[nChance(score)] += 9;
                    i++;
                }
            }
            switch (dartResult.charAt(i)) {
                case 'D':
                    score[nChance(score)] = (int) Math.pow(score[nChance(score)], 2);
                    break;
                case 'T':
                    score[nChance(score)] = (int) Math.pow(score[nChance(score)], 3);
                    break;
                case '*':
                    if (nChance(score) == 0) {
                        score[nChance(score)] *= 2;
                        break;
                    } else {
                        score[nChance(score) - 1] *= 2;
                        score[nChance(score)] *= 2;
                        break;
                    }
                case '#':
                    score[nChance(score)] *= -1;
                    break;
            }
        }

        int answer = 0;
        for (int sc : score) {
            answer += sc;
        }
        return answer;
    }

    // 3번의 기회에서 얻은 처음 정수의 점수들을 배열에 넣어 놓는 메서드
    public void addScore(int[] arr, char c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -10000) {
                arr[i] = Character.getNumericValue(c);
                break;
            }
        }
    }

    // 몇 번째 기회에서 얻은 점수를 가공할지 '몇 번째'를 반환하는 메서드
    public int nChance(int[] arr) {
        int defaultNumCount = 0;
        int n = -1;

        for (int a : arr) {
            if (a == -10000) defaultNumCount++;
        }
        switch (defaultNumCount) {
            case 0:
                n = 2;
                break;
            case 1:
                n = 1;
                break;
            case 2:
                n = 0;
                break;
        }
        return n;
    }
}
