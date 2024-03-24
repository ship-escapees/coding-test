class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        long gcd = gcd(w, h);
        answer -= gcd * ((w / gcd) + (h / gcd) - 1);
        return answer;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
