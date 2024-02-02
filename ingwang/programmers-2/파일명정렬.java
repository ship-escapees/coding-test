class Solution35{
    public static String solution35(String number, int k) {
        StringBuilder StringBuilder = new StringBuilder();
        int index = 0;
        for(int i=0; i<number.length() - k; i++) {
			char max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
					idx = j + 1;
                }
            }
            StringBuilder.append(max);
        }
        return StringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution35("JEROEN",1));
    }
}