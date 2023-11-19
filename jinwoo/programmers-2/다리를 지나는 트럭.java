
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int answer = 0;
            int weightOnBridge = 0;
            for (int i = 0; i < bridge_length; i++) {
                bridge.add(0);
            }
            for (int i = 0; i < truck_weights.length; i++) {
                while (true) {
                    weightOnBridge -= bridge.poll();
                    if (weightOnBridge + truck_weights[i] > weight) {
                        bridge.add(0);
                        answer++;
                    } else {
                        bridge.add(truck_weights[i]);
                        weightOnBridge += truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }
            return answer + bridge_length;
    }
}