import java.util.*;

public class 순위검색 {
    class Solution {
        private Map<String, List<Integer>> applicantsInfo;

        private void parseApplicantsInfo(String[] info) {
            applicantsInfo = new HashMap<>();

            for (String information : info) {
                String[] splittedInfo = information.split(" ");
                String language = splittedInfo[0];
                String position = splittedInfo[1];
                String career = splittedInfo[2];
                String soulFood = splittedInfo[3];
                int score = Integer.parseInt(splittedInfo[4]);

                for (String lang : new String[]{language, "-"}) {
                    for (String pos : new String[]{position, "-"}) {
                        for (String car : new String[]{career, "-"}) {
                            for (String food : new String[]{soulFood, "-"}) {
                                String key = lang + pos + car + food;
                                applicantsInfo.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                            }
                        }
                    }
                }
            }

            for (List<Integer> scores : applicantsInfo.values()) {
                Collections.sort(scores);
            }
        }

        private int countApplicants(String query) {
            String[] conditions = query.split(" and ");
            String[] lastCondition = conditions[3].split(" ");
            String soulFood = lastCondition[0];
            int score = Integer.parseInt(lastCondition[1]);

            String key = conditions[0] + conditions[1] + conditions[2] + soulFood;
            if (!applicantsInfo.containsKey(key)) return 0;

            List<Integer> scores = applicantsInfo.get(key);
            int index = Collections.binarySearch(scores, score);
            if (index < 0) index = -index - 1;

            return scores.size() - index;
        }

        public int[] solution(String[] info, String[] query) {
            parseApplicantsInfo(info);

            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                answer[i] = countApplicants(query[i]);
            }

            return answer;
        }
    }
}
