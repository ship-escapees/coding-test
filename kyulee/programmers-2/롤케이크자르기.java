import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기 {
            int n = topping.length;
            int result = 0;

            // 왼쪽 부분의 고유 토핑을 추적하기 위한 세트
            Set<Integer> leftSet = new HashSet<>();
            // 오른쪽 부분의 고유 토핑을 추적하기 위한 세트
            Set<Integer> rightSet = new HashSet<>();

            // 오른쪽 부분의 토핑 개수를 추적하기 위한 맵
            Map<Integer, Integer> rightMap = new HashMap<>();

            // 초기 오른쪽 세트와 맵을 채운다
            for (int t : topping) {
                rightSet.add(t);
                rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
            }

            // 자를 위치를 이동하며 공평한지를 확인
            for (int i = 0; i < n - 1; i++) {
                int t = topping[i];
                leftSet.add(t);
                rightMap.put(t, rightMap.get(t) - 1);
                if (rightMap.get(t) == 0) {
                    rightSet.remove(t);
                }

                // 왼쪽과 오른쪽의 고유 토핑 수가 같으면 공평하게 나누어진다
                if (leftSet.size() == rightSet.size()) {
                    result++;
                }
            }

            return result;
}
