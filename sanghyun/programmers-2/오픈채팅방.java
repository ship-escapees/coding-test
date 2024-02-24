import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> input = new LinkedHashMap<>();
        Queue<String[]> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String type = record[i].split(" ")[0];
            String uid = record[i].split(" ")[1];
            String[] s = {type,uid};
            if(type.equals("Change")) {
                input.put(uid,record[i].split(" ")[2]);
            }else if(type.equals("Enter")){
                cnt++;
                input.put(uid,record[i].split(" ")[2]);
                queue.add(s);
            }else{
                cnt++;
                queue.add(s);
            }
        }
        String[] answer = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            String type = queue.peek()[0];
            String uid = queue.peek()[1];
            queue.poll();
            if(type.equals("Enter")){
                answer[i] = input.get(uid)+"님이 들어왔습니다.";
            }else{
                answer[i] = input.get(uid)+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}
