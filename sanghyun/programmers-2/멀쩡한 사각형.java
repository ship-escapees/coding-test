class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long wl = w;
        long hl = h;
        int gdc = gdc(w,h);
        answer = wl * hl - (wl+hl-gdc);
        return answer;
    }
    public int gdc(int a, int b) {
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
