/*
개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.

코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.

대기실은 5개이며, 각 대기실은 5x5 크기입니다.
거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.

제한사항
places의 행 길이(대기실 개수) = 5
places의 각 행은 하나의 대기실 구조를 나타냅니다.
places의 열 길이(대기실 세로 길이) = 5
places의 원소는 P,O,X로 이루어진 문자열입니다.
places 원소의 길이(대기실 가로 길이) = 5
P는 응시자가 앉아있는 자리를 의미합니다.
O는 빈 테이블을 의미합니다.
X는 파티션을 의미합니다.
입력으로 주어지는 5개 대기실의 크기는 모두 5x5 입니다.
return 값 형식
1차원 정수 배열에 5개의 원소를 담아서 return 합니다.
places에 담겨 있는 5개 대기실의 순서대로, 거리두기 준수 여부를 차례대로 배열에 담습니다.
각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.
*/

const evaluateSocialDistancing = (places: string[][]): number[] => {
    const results: number[] = [];


    function checkDistance(room: string[], x: number, y: number): boolean {
        // 주변 확인을 위한 방향 벡터 설정
        const directions: [number, number][] = [
            [0, 1], [1, 0], [0, -1], [-1, 0], // 상하좌우
            [1, 1], [1, -1], [-1, 1], [-1, -1], // 대각선
            [0, 2], [2, 0], [0, -2], [-2, 0]  // 2칸 거리 상하좌우
        ];

        for (const [dx, dy] of directions) {
            const nx = x + dx;
            const ny = y + dy;
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && room[nx][ny] === 'P') {
                if (Math.abs(dx) + Math.abs(dy) === 1) {
                    return false;
                }
                if (Math.abs(dx) === 2 || Math.abs(dy) === 2) {

                    if (room[x + dx / 2][y + dy / 2] !== 'X') {
                        return false;
                    }
                }
                if (Math.abs(dx) === 1 && Math.abs(dy) === 1) {

                    if (room[x][ny] !== 'X' || room[nx][y] !== 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    places.forEach((place) => {
        let isCompliant = 1;
        loop: for (let i = 0; i < 5; i++) {
            for (let j = 0; j < 5; j++) {
                if (place[i][j] === 'P') {
                    if (!checkDistance(place, i, j)) {
                        isCompliant = 0;
                        break loop;
                    }
                }
            }
        }
        results.push(isCompliant);
    });

    return results;
}
