import java.util.*;
class Solution {
    public static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static int max = 0;
    public static PriorityQueue<String> pq = new PriorityQueue<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for(int i=0;i<course.length;i++) {
            getCourse(course[i], orders);
        }
        answer = new String[pq.size()];
        int index = 0;
        while(!pq.isEmpty()) {
            answer[index] = pq.poll();
            index++;
        }
        return answer;
    }
    public static void getCourse(int count, String[] orders) {
        for(int i=0;i<orders.length;i++) {
            int len = orders[i].length();
            if(len >= count) {
                String[] menu = orders[i].split("");
                Arrays.sort(menu);
                boolean[] visit = new boolean[len];
                getMenu(menu, count, "", visit, 0);
            }
        }
        
        if(max > 1) {
            findMax();
        }
        max = 0;
        map.clear();
    }
    
    public static void getMenu(String[] menu, int cnt, String set, boolean[] visit, int index) {
        if(set.length() == cnt) {
            if(map.get(set) != null) {
                int newCount = map.get(set) + 1;
                map.put(set, newCount);
                if(max < newCount) {
                    max = newCount;
                }
            } else {
                map.put(set, 1);
            }
            return;
        }
        for(int i=index;i<menu.length;i++) {
            if(!visit[i]) {
                visit[i] = true;
                getMenu(menu, cnt, set + menu[i], visit, i);
                visit[i] = false;
            }
        }
    }
    
    public static void findMax() {
        for(String key:map.keySet()) {
            if(max == map.get(key)) {
                pq.offer(key);
            }
        }
    }
}
