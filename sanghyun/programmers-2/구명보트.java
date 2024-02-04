import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> peopleDeque = new ArrayDeque<>();
        for (int i = people.length-1; i >= 0; i--) {
            peopleDeque.add(people[i]);
        }
        while (!peopleDeque.isEmpty()){
            int sum = peopleDeque.peekFirst() + peopleDeque.peekLast();
            if(sum > limit){
                peopleDeque.pollFirst();
            } else {
                peopleDeque.pollFirst();
                peopleDeque.pollLast();
            }
            answer++;
        }
        return answer;
    }
}
