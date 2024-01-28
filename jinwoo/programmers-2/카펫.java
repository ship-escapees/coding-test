class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w,h;
        int area = brown+yellow;

        for (h = 3; h < area; h++) {
            w=area/h;
            int y=(w-2)*(h-2);
            int b=area-y;
            if(yellow==y && brown==b) {
                answer[0]=w;
                answer[1]=h;
                break;
            }
        }

        return answer;
    }
}