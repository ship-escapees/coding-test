import java.util.*;

class Solution {
    Map<String, List<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String in : info) {
            dfs("", 0, in.split(" "));
        }

        List<Integer> emptyList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : infoMap.entrySet())
            entry.getValue().sort(null);

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] split = query[i].split(" ");
            int score = Integer.parseInt(split[1]);
            answer[i] = infoMap.getOrDefault(split[0], emptyList).size() - binarySearch(infoMap.getOrDefault(split[0], emptyList), score);
        }
        return answer;
    }

    void dfs(String curr, int depth, String[] info) {
        if (depth == 4) {
            if (!infoMap.containsKey(curr)) {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                infoMap.put(curr, list);
            } else {
                infoMap.get(curr).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(curr+"-", depth+1, info); // 해당 조건을 고려하지 않는 경우
        dfs(curr+info[depth], depth+1, info); // 해당 조건을 고려하는 경우
    }

    int binarySearch(List<Integer> list, int score) {
        int left = 0, right = list.size(), mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) < score) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}