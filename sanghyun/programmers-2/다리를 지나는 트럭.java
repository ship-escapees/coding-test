import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (q.isEmpty()){
                    q.add(truck);
                    weight -= truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    weight += q.poll();
                } else {
                    if (weight >= truck) {
                        q.add(truck);
                        weight -= truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }

        }
        return time + bridge_length;
    }
}
