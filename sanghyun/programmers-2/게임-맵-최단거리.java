import java.util.LinkedList;
import java.util.Queue;

class Solution {
	// 4방향 체크용 x,y, 
	int[] mx = { 1, 0, -1, 0 };
	int[] my = { 0, -1, 0, 1 };
	// maps의 크기와 같은 visited 2차 배열 생성(해당 자리의 가장 빠르게 도달할 수 있는 값 저장용)
	int[][] visited;

	public int solution(int[][] maps) {
		visited = new int[maps.length][maps[0].length];
		bfs(maps);
		
		if (visited[maps.length - 1][maps[0].length - 1] == 0) return -1;
		return visited[maps.length - 1][maps[0].length - 1];
	}

	public void bfs(int[][] maps) {
		// bfs를 위한 q 생성 <좌표값>
		Queue<int[]> q = new LinkedList<>();
		int[] now = { 0, 0 }; // <시작 좌표값 설정>
		q.add(new int[] { 0, 0 });
		visited[0][0] = 1; // 첫번째 자리는 1로 시작
		
		// while문을 돌며 
		while (!q.isEmpty()) {
			// now => 현재 좌표 즉, q에 넣어뒀던 값을 꺼내서 확인
			now = q.poll();
			// 본인 위치 기준 동남서북 순서로 확인해보며 갈 수 있는 방향이면 q에 추가해주며 , 해당 자리의 visited에 +1 
			for (int i = 0; i < 4; i++) {
				int x = now[0] + mx[i];
				int y = now[1] + my[i];
				if (x > maps.length - 1 || y > maps[0].length - 1 || x < 0 || y < 0 || maps[x][y] == 0
						|| visited[x][y] != 0)
					continue;
				q.add(new int[] { x, y });
				visited[x][y] = visited[now[0]][now[1]] + 1;
			}
		}
	}
}
