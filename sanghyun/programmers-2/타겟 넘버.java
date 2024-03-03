
class Solution {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }

    public void dfs(int[] numbers,int target,int idx, int sum){
        // idx = 현재 위치, sum = idx 까지 합
        if (idx == numbers.length) {
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers,target,idx+1,sum + numbers[idx]);
        dfs(numbers,target,idx+1,sum - numbers[idx]);
    }
}
