class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        for (int i = (int) Math.sqrt(carpet)+1; i > 2; i--) {
            if(carpet%i == 0) {
                int width = i;
                int height = carpet/i;
                int widthCnt = width*2;
                int heightCnt = height*2-4;
                if(carpet-widthCnt-heightCnt == yellow){
                    return new int[]{width, height};
                }
            }
        }
        return answer;
    }
}
