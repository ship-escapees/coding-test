/*
정수 n이 매개변수로 주어집니다.
 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
  첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

  제한사항
n은 1 이상 1,000 이하입니다.
*/

const fillSnailTriangle = (n: number): number[] => {
    const answer: number[] = [];
    const map: number[][] = Array.from({ length: n }, () => Array(n).fill(0));
    let num: number = 1, x: number = -1, y: number = 0;
    
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            if (i % 3 === 0) {
                x++;
            } else if (i % 3 === 1) { 
                y++;
            } else if (i % 3 === 2) {
                x--;
                y--;
            }
            map[x][y] = num++;
        }
    }

    for (const row of map) {
        for (const val of row) {
            if (val !== 0) answer.push(val);
        }
    }

    return answer;
}
