class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        StringBuilder music = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            if(i+1 < m.length() && m.charAt(i + 1) == '#'){
                music.append(m.substring(i,i+1).toLowerCase());
                i++;
            }else{
                music.append(m.substring(i,i+1));
            }
        }
        int maxTime = 0;
        for (int i = 0; i < musicinfos.length; i++) {

            int time = stringToTime(musicinfos[i]);
            String word = musicinfos[i].split(",")[3];
            int length = word.length();
            StringBuilder builder = new StringBuilder();
            int cnt = 0;

            for (int j = 0; j < time; j++) {
                if(cnt+1 < word.length() && word.charAt(cnt + 1) == '#'){
                    builder.append(word.substring(cnt,cnt+1).toLowerCase());
                    cnt++;
                }else{
                    builder.append(word.substring(cnt,cnt+1));
                }
                cnt++;
                if(cnt == length) cnt = 0;
            }
            String s = String.valueOf(builder);
            if(s.contains(music)){
                if(maxTime < time){
                    maxTime = time;
                    answer = musicinfos[i].split(",")[2];
                }
            }
        }
        if(answer.equals("")){
            answer = "(None)";
        }
        return answer;
    }
    public int stringToTime(String s){
        int time1 = Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3,5));
        int time2 = Integer.parseInt(s.substring(6,8))*60 + Integer.parseInt(s.substring(9,11));
        return time2-time1;
    }
}
