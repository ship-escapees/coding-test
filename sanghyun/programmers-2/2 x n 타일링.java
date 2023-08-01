class Solution {
	public int solution(int n) {
		return tile(n);
	}
	public int tile(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return tile(n - 1) + tile(n - 2);
		}
	}
}

class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(5));
	}
}
