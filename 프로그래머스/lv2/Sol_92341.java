package programmers.level2;

import java.util.*;

public class Sol_92341 {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];

        int unitTime = fees[2];
        int unitFee = fees[3];

        // 2차원 배열에 각 차량에 따른 입차(IN), 출차(OUT) 값 추가
        String[][] inOrOutOfEachCar = new String[records.length][2];

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            inOrOutOfEachCar[i][0] = record[1];
            inOrOutOfEachCar[i][1] = record[2];
        }

        // 각 차량별로 누적 시간값 구하기
        Map<Integer, Integer> totalTimeOfEachCarNumber = new LinkedHashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");

            String[] timeArr = record[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);

            int carNum = Integer.parseInt(record[1]);

            if (totalTimeOfEachCarNumber.containsKey(carNum)) {
                if (record[2].equals("IN")) {
                    totalTimeOfEachCarNumber.put(carNum, time + totalTimeOfEachCarNumber.get(carNum));

                    // 후에 같은 차량 번호로 출차된 기록이 없으면 23:59에서 뺀 값을 누적시간에 더하기
                    if (Arrays.stream(inOrOutOfEachCar).noneMatch(el -> el[0].equals(record[1]) && el[1].equals("OUT")))
                        totalTimeOfEachCarNumber.put(carNum, (23 * 60 + 59) - totalTimeOfEachCarNumber.get(carNum));

                } else if (record[2].equals("OUT"))
                    totalTimeOfEachCarNumber.put(carNum, totalTimeOfEachCarNumber.get(carNum) - time);

            } else {
                totalTimeOfEachCarNumber.put(carNum, time);

                // 후에 같은 차량 번호로 출차된 기록이 없으면 23:59에서 뺀 값을 누적시간에 더하기
                if (Arrays.stream(inOrOutOfEachCar).noneMatch(el -> el[0].equals(record[1]) && el[1].equals("OUT")))
                    totalTimeOfEachCarNumber.put(carNum, (23 * 60 + 59) - totalTimeOfEachCarNumber.get(carNum));
            }

            inOrOutOfEachCar[i][0] = "";
            inOrOutOfEachCar[i][1] = "";
        }

        // 현재 누적 시간을 구하는 방법은 누적 시간이 음수가 나올 수 있기 때문에, 절댓값으로 양수로 바꾸기
        totalTimeOfEachCarNumber.replaceAll((k, v) -> Math.abs(totalTimeOfEachCarNumber.get(k)));

        // 각 차량별로 요금 구하기
        for (Integer key : totalTimeOfEachCarNumber.keySet()) {
            if (totalTimeOfEachCarNumber.get(key) <= baseTime) totalTimeOfEachCarNumber.put(key, baseFee);

            else
                totalTimeOfEachCarNumber.put(key, (int) (baseFee + Math.ceil((double) (totalTimeOfEachCarNumber.get(key) - baseTime) / unitTime) * unitFee));
        }

        // 차량 변호로 오름차순 정렬하기
        List<Integer> keyList = new ArrayList<>(totalTimeOfEachCarNumber.keySet());
        keyList.sort(Integer::compareTo);

        // 정답으로 반환할 리스트에 오름차순 정렬된 요금 값을 하나씩 넣기
        List<Integer> answer = new ArrayList<>();

        for (Integer key : keyList) answer.add(totalTimeOfEachCarNumber.get(key));

        return answer.stream().mapToInt(el -> el).toArray();
    }
}
