class Solution18 {
    public static int solution18(int[] arr) {
        int answer = 0;

        if (arr.length == 1) {
            return arr[0];
        }
        // 최대공약수
        int m = max(arr[0], arr[1]);
        // 최대 공약수
        int n = (arr[0] *arr[1])/m;

        if(arr.length>2){
            for (int i = 2; i < arr.length; i++) {
                m = max(n, arr[i]);
                n = (n * arr[i])/m;
            }
        }
        answer = n;
        return answer;
    }

    private static int max(int n, int m) {
        int x = n % m;
        if (x == 0) {
            return m;
        }
        return max(m, x);
        
    }

    public static void main(String[] args) {
        int [] a = {1,2,3};
        System.out.println(solution18(a));
    }
}
