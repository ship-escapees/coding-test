class Solution13 {
    public static String solution13(String s) {
        String answer = "";
        String[] num = s.split(" ");
        int max = Integer.parseInt(num[0]);;
        int min = Integer.parseInt(num[0]);

        for (int i = 0; i < num.length - 1; i++) {
            int rmax = Math.max(Integer.parseInt(num[i]), Integer.parseInt(num[i + 1]));
            int rmin = Math.min(Integer.parseInt(num[i]), Integer.parseInt(num[i + 1]));
            if(max < rmax){
                max = rmax;
            }else if(min > rmin){
                min = rmin;
            }

            System.out.println(min);
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution13("1 2 3 4"));
    }
}