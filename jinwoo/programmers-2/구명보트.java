import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int max = people.length - 1;
        int min = 0;

        while (true) {
            int weight = people[max];
            if (weight + people[min] <= limit) {
                min++;
            }
            max--;
            answer++;
            if(max < min) {
                break;
            }
        }
        return answer;
    }
}