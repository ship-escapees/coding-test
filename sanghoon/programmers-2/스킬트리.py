def solution(skill, skill_trees):
    count = 0
    for skill_tree in skill_trees:
        s = ""  # skill_trees[x] 마다 s 문자열 초기화
        for ch in skill_tree:
            if ch in skill:  # skill_trees[x]의 각 스킬마다 skill이 있으면 s 문자열에 추가
                s += ch

        if skill[:len(s)] == s:  # 만든 s를 기준으로 skill과 같다면 count += 1
            count += 1

    return count

skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
solution(skill, skill_trees)