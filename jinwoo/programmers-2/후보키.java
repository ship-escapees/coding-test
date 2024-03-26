import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<Set<Integer>> candidateKeySet;

    public int solution(String[][] relation) {
        candidateKeySet = new HashSet<>();
        int columnSize = relation[0].length;

        for (int i = 1; i <= columnSize; i++) {
            makeCandidateKeySet(relation, new HashSet<>(), 0, i);
        }

        return candidateKeySet.size();
    }
    
    public void makeCandidateKeySet(String[][] relation, Set<Integer> candidateKey, int start, int size) {
        // 후보키의 조합의 크기가 size와 같으면 후보 키 검증
        if (candidateKey.size() == size) {
            // 이미 찾은 후보키의 부분집합인지 확인
            for (Set<Integer> key : candidateKeySet) {
                if (candidateKey.containsAll(key)) {
                    return;
                }
            }
            
            // 유일성 검증
            if (checkUniqueness(relation, candidateKey)) {
                candidateKeySet.add(new HashSet<>(candidateKey));
            }
            
            return;
        }

        // 컬럼의 조합을 만드는 반복문
        for (int i = start; i < relation[0].length; i++) {
            candidateKey.add(i);
            makeCandidateKeySet(relation, candidateKey, i + 1, size);
            candidateKey.remove(i);
        }
    }

    public boolean checkUniqueness(String[][] relation, Set<Integer> candidateKey) {
        Set<String> tupleSet = new HashSet<>();

        for (String[] tuple : relation) {
            StringBuilder keyBuilder = new StringBuilder();
            for (int keyIndex : candidateKey) {
                keyBuilder.append(tuple[keyIndex]);
            }
            if (!tupleSet.add(keyBuilder.toString())) {
                return false; // 중복되는 튜플이 존재한다면 유일하지 않음
            }
        }

        return true;
    }
}