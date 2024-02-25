import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        Map<String, String> id = new HashMap<>();

        // id 리스트 작성
        for(String chat : record){
            String[] log = chat.split(" ");
            if(!log[0].equals("Leave")){
                id.put(log[1], log[2]);
            }
        }

        for(String chat : record) {
            String[] log = chat.split(" ");
            String userId = id.get(log[1]);

            if (log[0].equals("Enter")) {
                result.add(userId + "님이 들어왔습니다.");
            } else if (log[0].equals("Leave")) {
                result.add(userId + "님이 나갔습니다.");
            }
        }

        answer = result.toArray(new String[0]);

        return answer;
    }
}