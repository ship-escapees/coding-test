public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getNextNumber(numbers[i]);
        }
        
        return answer;
    }
    
    private long getNextNumber(long number) {
        if (number % 2 == 0) {
            return number + 1;
        } else {
            long rightMostZero = ~number & (number + 1);
            return number + (rightMostZero / 2);
        }
    }
    
}