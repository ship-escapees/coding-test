
public class 의상 {
public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();

        // 의상의 종류별로 개수를 세어 HashMap에 저장
        for (String[] cloth : clothes) {
        String type = cloth[1];
        clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 각 종류의 의상을 입는 경우의 수 계산
        for (int count : clothesMap.values()) {
        answer *= (count + 1); // 각 종류의 의상을 입지 않는 경우도 포함하기 위해 +1
        }

        // 모든 의상을 입지 않는 경우는 제외
        return answer - 1;
        }
}
