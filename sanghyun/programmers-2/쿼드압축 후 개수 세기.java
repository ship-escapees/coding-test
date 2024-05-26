import java.util.Arrays;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {

        cycle(arr,0,arr.length,0,arr[0].length);

        return answer;
    }
    public void cycle(int[][] arr, int sX, int eX, int sY, int eY){
        boolean cheak = true;
        for1 :
        for (int i = sX; i < eX; i++) {
            for (int j = sY; j < eY; j++) {
                if(arr[sX][sY] != arr[i][j]){
                    cheak = false;
                    break for1;
                }
            }
        }
        if(cheak){
            answer[arr[sX][sY]]++;
            return;
        }
        cycle(arr,sX,(sX+eX)/2,sY,(sY+eY)/2);//1
        cycle(arr,sX,(sX+eX)/2,(sY+eY)/2,eY);//3
        cycle(arr,(sX+eX)/2,eX,sY,(sY+eY)/2);//2
        cycle(arr,(sX+eX)/2,eX,(sY+eY)/2,eY);//4
    }
}
