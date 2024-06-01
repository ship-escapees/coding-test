class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String numlist = sb.reverse().toString();

        String num = "";
        for (int i = 0; i < numlist.length(); i++) {
            char c = numlist.charAt(i);
            if(c == '0'){
                if(!num.equals("1") && !num.equals("") && primeNumber(num)) answer++;
                num = "";
            }else{
                num += c;
            }
        }
        if(!num.equals("1") && !num.equals("") && primeNumber(num)) answer++;
        return answer;
    }
    protected boolean primeNumber (String s){
        long num = Long.parseLong(s);
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
