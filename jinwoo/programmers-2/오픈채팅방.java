import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidToNickname = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                uidToNickname.put(uid, parts[2]);
            }

            if (!action.equals("Change")) {
                actions.add(new String[]{action, uid});
            }
        }

        String[] answer = new String[actions.size()];
        int idx = 0;

        for (String[] actionDetail : actions) {
            String action = actionDetail[0];
            String uid = actionDetail[1];
            String nickname = uidToNickname.get(uid);

            if (action.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}