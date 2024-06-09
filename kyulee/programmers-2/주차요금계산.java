import java.util.*;
import java.util.stream.Collectors;

public class 주차요금계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int baseTime = fees[0];
            int baseFee = fees[1];
            int unitTime = fees[2];
            int unitFee = fees[3];

            // 차량별 총 주차 시간 저장하는 맵
            Map<String, Integer> totalParkingTime = new HashMap<>();
            // 차량별 입차 시간 저장하는 맵
            Map<String, Integer> currentParkingTime = new HashMap<>();

            // 기록을 처리
            for (String record : records) {
                String[] parts = record.split(" ");
                int time = toMinutes(parts[0]);
                String carNumber = parts[1];
                boolean isEntry = parts[2].equals("IN");

                if (isEntry) {
                    currentParkingTime.put(carNumber, time);
                } else {
                    int entryTime = currentParkingTime.remove(carNumber);
                    int duration = time - entryTime;
                    totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + duration);
                }
            }

            // 23:59까지 출차하지 않은 차량 처리
            for (Map.Entry<String, Integer> entry : currentParkingTime.entrySet()) {
                int duration = toMinutes("23:59") - entry.getValue();
                totalParkingTime.put(entry.getKey(), totalParkingTime.getOrDefault(entry.getKey(), 0) + duration);
            }

            // 차량 번호별로 정렬
            List<String> carNumbers = new ArrayList<>(totalParkingTime.keySet());
            Collections.sort(carNumbers);

            // 결과를 저장할 배열
            int[] answer = new int[carNumbers.size()];
            int index = 0;

            // 주차 요금 계산
            for (String carNumber : carNumbers) {
                int parkingTime = totalParkingTime.get(carNumber);
                int fee = calculateFee(parkingTime, baseTime, baseFee, unitTime, unitFee);
                answer[index++] = fee;
            }

            return answer;
        }

        // 시간 문자열을 분 단위로 변환
        private int toMinutes(String time) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours * 60 + minutes;
        }

        // 주차 요금 계산
        private int calculateFee(int parkingTime, int baseTime, int baseFee, int unitTime, int unitFee) {
            if (parkingTime <= baseTime) {
                return baseFee;
            }
            int extraTime = parkingTime - baseTime;
            int extraUnits = (int) Math.ceil((double) extraTime / unitTime);
            return baseFee + extraUnits * unitFee;
        }
    }
}
