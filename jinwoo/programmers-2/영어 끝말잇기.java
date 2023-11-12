class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        loop:
        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer = new int[]{(i)%n+1, ((i) / n) + 1};
                break;
            }
            for (int j = 0; j < i; j++) {
                if(words[j].equals(words[i])) {
                    answer = new int[]{(i)%n+1, ((i) / n) + 1};
                    break loop; //상위 for문 break
                }
            }
        }
        return answer;
    }
}