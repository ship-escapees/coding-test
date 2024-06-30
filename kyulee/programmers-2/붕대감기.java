import java.util.HashMap;
import java.util.Map;

public class 붕대감기 {
    import java.util.HashMap;
import java.util.Map;

    public class Solution {
        static Map<Integer, Integer> attackTimes = new HashMap<>();
        static int lastAttackTime = 0;
        static int currentHealth = 0;
        static int consecutiveHealingTime = 0;

        public int solution(int[] bandage, int health, int[][] attacks) {
            currentHealth = health;
            attackTimes.clear();
            lastAttackTime = 0;
            consecutiveHealingTime = 0;

            for (int[] attack : attacks) {
                attackTimes.put(attack[0], attack[1]);
                lastAttackTime = Math.max(lastAttackTime, attack[0]);
            }

            for (int time = 1; time <= lastAttackTime; time++) {
                if (attackTimes.containsKey(time)) { // 공격이 있다면
                    currentHealth -= attackTimes.get(time);
                    consecutiveHealingTime = 0;
                } else { // 공격이 없다면
                    currentHealth += bandage[1];
                    consecutiveHealingTime++;

                    if (consecutiveHealingTime == bandage[0]) {
                        currentHealth += bandage[2];
                        consecutiveHealingTime = 0;
                    }
                    if (currentHealth > health) {
                        currentHealth = health;
                    }
                }

                if (currentHealth <= 0) { // 이번 턴을 마치고 체력이 바닥났다면 종료
                    return -1;
                }
            }

            return currentHealth;
        }
    }

}
