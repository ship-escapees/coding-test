const gameMap = (maps: number[][]): number => {
    const dx: number[] = [0, 0, 1, -1];
    const dy: number[] = [1, -1, 0, 0];
    const queue: [number, number, number][] = [[0, 0, 1]];

    while (queue.length) {
        const cur = queue.shift();
        if (cur![0] === maps.length - 1 && cur![1] === maps[0].length - 1) {
            return cur![2];
        }
            
        for (let i = 0; i < 4; i++) {
            const ny = cur![0] + dy[i];
            const nx = cur![1] + dx[i];
            
            if (nx >= 0 && ny >= 0 && nx < maps[0].length && ny < maps.length && maps[ny][nx] === 1) {
                maps[ny][nx] = 0;
                queue.push([ny, nx, cur![2] + 1]);    
            }
        }
    }
    
    return -1;
};


/* 
[[1,0,1,1,1],
[1,0,1,0,1],
[1,0,1,1,1],
[1,1,1,0,1],
[0,0,0,0,1]]	11

[[1,0,1,1,1],
[1,0,1,0,1],
[1,0,1,1,1],
[1,1,1,0,0],
[0,0,0,0,1]]	-1

 */