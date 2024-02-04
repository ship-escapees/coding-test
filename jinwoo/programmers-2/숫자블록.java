class Solution {
    public int[] solution(long begin, long end) {
        int length = (int)(end-begin)+1;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            //begin==1인경우 처음 배열 값 저장
            if((int)begin==1 && i==0) {
                answer[0]=0;
                continue;
            }
            //저장되는 값을 1로 값 세팅(==소수인 경우)
            answer[i]=1;
            for (int j = 2; j <= Math.sqrt(begin+i); j++) {
                if ((begin + i) % j == 0) {
                    if ((begin + i) / j <= 10000000) {
                        answer[i] = (int) ((begin + i) / j);
                        break;
                    } else {
                        answer[i] = j;
                    }
                }
            }
        }
        return answer;
    }
}