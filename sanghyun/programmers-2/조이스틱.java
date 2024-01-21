class Solution {
    public int solution(String name) {
        int answer = 0;
        int m = name.length();
        int cursorMove = m - 1;
        int front = 0, middle = 0, back = 0;

        for(int i = 0; i < m; i++){
            char word = name.charAt(i);
            if(word == 65){
                if(back != 0){
                    front += back;
                    back = 0;
                }
                middle += 1;
            }else{
                if(middle != 0){
                    back += 1;
                }else if(middle == 0){
                    front += 1;   
                }
            } 
        }

        front = front > 1 ?  front + front - 2 : 0;

        if(front + back < cursorMove) cursorMove = front + back;
        answer += cursorMove;
        for(int i = 0; i < m; i++){
            char word = name.charAt(i);     
            if(word == 65) continue;
            int position = word - 65;
            if(word > 78){ 
                answer += 26 - position;
            }else{
                answer += position;
            }
        }
        return answer;
    }
}
