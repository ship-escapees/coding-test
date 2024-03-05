class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            boolean check = true;
            int index = 0;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (skill.indexOf(skill_trees[i].charAt(j)) == -1) continue;
                else if (skill.indexOf(skill_trees[i].charAt(j)) == index) index++;
                else {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }
        return answer;
    }

}