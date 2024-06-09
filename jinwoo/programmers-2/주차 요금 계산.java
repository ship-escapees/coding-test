import java.util.*;
import java.text.*;

public class Solution {
    // 시간 문자열을 분 단위로 변환하는 함수
    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // 요금 계산 함수
    private static int calculateFee(int totalMinutes, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalMinutes <= baseTime) {
            return baseFee;
        } else {
            return baseFee + (int)Math.ceil((double)(totalMinutes - baseTime) / unitTime) * unitFee;
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();
        Set<String> cars = new HashSet<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            cars.add(carNumber);

            if (action.equals("IN")) {
                inTime.put(carNumber, timeToMinutes(time));
            } else {
                int totalParkedTime = timeToMinutes(time) - inTime.remove(carNumber);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + totalParkedTime);
            }
        }

        // 23:59에 출차된 것으로 간주
        int endOfDay = timeToMinutes("23:59");
        for (String carNumber : inTime.keySet()) {
            int totalParkedTime = endOfDay - inTime.get(carNumber);
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + totalParkedTime);
        }

        // 차량 번호 순으로 정렬
        List<String> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);

        // 결과 계산
        int[] result = new int[sortedCars.size()];
        for (int i = 0; i < sortedCars.size(); i++) {
            String carNumber = sortedCars.get(i);
            int totalMinutes = parkingTime.get(carNumber);
            result[i] = calculateFee(totalMinutes, fees);
        }

        return result;
    }
}