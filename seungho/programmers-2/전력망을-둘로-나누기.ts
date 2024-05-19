/*
n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다. 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.

송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 2 이상 100 이하인 자연수입니다.
wires는 길이가 n-1인 정수형 2차원 배열입니다.
wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
1 ≤ v1 < v2 ≤ n 입니다.
전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
*/

const findMinimumTowerDifference = (n: number, wires: number[][]): number => {

    const adj: number[][] = Array.from({ length: n + 1 }, () => []);
    wires.forEach(([v1, v2]) => {
        adj[v1].push(v2);
        adj[v2].push(v1);
    });

    let minDifference: number = Infinity;
    // 각 전선을 끊고 두 그룹의 송전탑 개수 차이 계산
    for (const [v1, v2] of wires) {
        // 두 노드 사이의 연결을 끊음
        const idx1: number = adj[v1].indexOf(v2);
        const idx2: number = adj[v2].indexOf(v1);
        adj[v1].splice(idx1, 1);
        adj[v2].splice(idx2, 1);
        // DFS를 사용
        const visited: boolean[] = new Array(n + 1).fill(false);
        const countNodes = (node: number): number => {
            visited[node] = true;
            return adj[node].reduce((acc: number, next: number) => {
                if (!visited[next]) {
                    acc += countNodes(next);
                }
                return acc;
            }, 1);
        };

        const groupSize: number = countNodes(v1);
        const difference: number = Math.abs(groupSize - (n - groupSize));
        minDifference = Math.min(minDifference, difference);

        // 끊었던 연결 복원
        adj[v1].push(v2);
        adj[v2].push(v1);
    }

    return minDifference;
}