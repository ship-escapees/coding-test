/*
Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
예를 들어, 다음과 같은 직선 5개를

2x - y + 4 = 0
-2x - y + 4 = 0
-y + 1 = 0
5x - 8y - 12 = 0
5x + 8y + 12 = 0
좌표 평면 위에 그리면 아래 그림과 같습니다.


이때, 모든 교점의 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4), (1.5, 1.0), (2.1, -0.19), (0, -1.5), (-2.1, -0.19), (-1.5, 1.0)입니다. 이 중 정수로만 표현되는 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4)입니다.

만약 정수로 표현되는 교점에 별을 그리면 다음과 같습니다.

위의 그림을 문자열로 나타낼 때, 별이 그려진 부분은 *, 빈 공간(격자선이 교차하는 지점)은 .으로 표현하면 다음과 같습니다.

"..........."  
".....*....."  
"..........."  
"..........."  
".*.......*."  
"..........."  
"..........."  
"..........."  
"..........."  
".*.......*."  
"..........."  
이때 격자판은 무한히 넓으니 모든 별을 포함하는 최소한의 크기만 나타내면 됩니다.

따라서 정답은

"....*...."  
"........."  
"........."  
"*.......*"  
"........."  
"........."  
"........."  
"........."  
"*.......*"  
입니다.

직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.

제한사항
line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
line의 가로(열) 길이는 3입니다.
line의 각 원소는 [A, B, C] 형태입니다.
A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
A = 0이면서 B = 0인 경우는 주어지지 않습니다.
정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
별이 한 개 이상 그려지는 입력만 주어집니다.
*/

const drawStarsOnGrid = (lines: number[][]): string[] => {
    const points: Set<string> = new Set();
    const n: number = lines.length;

    for (let i = 0; i < n - 1; i++) {
        for (let j = i + 1; j < n; j++) {
            const [A1, B1, C1] = lines[i];
            const [A2, B2, C2] = lines[j];

            const det: number = A1 * B2 - A2 * B1;
            if (det !== 0) {
                const x: number = (B1 * C2 - B2 * C1) / det;
                const y: number = (A2 * C1 - A1 * C2) / det;

                if (Number.isInteger(x) && Number.isInteger(y)) {
                    points.add(`${x},${y}`);
                }
            }
        }
    }

    const xs: number[] = [];
    const ys: number[] = [];
    points.forEach(point => {
        const [x, y] = point.split(',').map(Number);
        xs.push(x);
        ys.push(y);
    });

    const minX: number = Math.min(...xs);
    const maxX: number = Math.max(...xs);
    const minY: number = Math.min(...ys);
    const maxY: number = Math.max(...ys);

    const grid: string[][] = Array.from({ length: maxY - minY + 1 }, () =>
        new Array(maxX - minX + 1).fill('.')
    );

    points.forEach(point => {
        const [x, y] = point.split(',').map(Number);
        grid[y - minY][x - minX] = '*';
    });

    const result: string[] = grid.map(row => row.join(''));
    return result.reverse();
}
