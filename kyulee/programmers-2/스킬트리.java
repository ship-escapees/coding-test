import java.util.*;

public class 스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String tree : skill_trees) {
                if (isPossibleSkillTree(skill, tree)) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isPossibleSkillTree(String skill, String tree) {
            // 주어진 스킬트리에서 선행 스킬 순서에 맞게 스킬을 배웠는지 확인
            int idx = 0;
            for (char c : tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    if (skill.charAt(idx) == c) {
                        idx++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
