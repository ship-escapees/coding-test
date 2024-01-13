
public class 다리를 지나는 트럭 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
                Queue<Integer> bridge = new LinkedList<>();
                int time = 0;
                int currentWeight = 0;
                int truckIndex = 0;

                while (true) {
                        time++;

                        if (bridge.size() == bridge_length) {
                                currentWeight -= bridge.poll();
                        }

                        if (truckIndex < truck_weights.length && currentWeight + truck_weights[truckIndex] <= weight) {
                                bridge.offer(truck_weights[truckIndex]);
                                currentWeight += truck_weights[truckIndex];
                                truckIndex++;
                        } else {
                                bridge.offer(0); // 0을 추가하여 무게를 나타내는 경우와 대기 중인 경우를 나누어 표현
                        }

                        if (currentWeight == 0 && truckIndex == truck_weights.length) {
                                break;
                        }
                }

                return time;
        }
}
