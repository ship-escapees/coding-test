class Solution34 {
    public static int solution(String name) {
        int answer = 0 ;
        int move = name.length()-1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            int n = i+1;
            while (n<name.length() && name.charAt(n)=='A') {
                n++;
            }
            move = Math.min(Math.min(move, i*2+name.length()-n), (name.length()-n)*2 +i);
        }
        


        return answer +move;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }
}