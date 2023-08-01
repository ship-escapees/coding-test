const worldOf124 = (n: number): string => {
    let answer = '';
    
    while (n > 0) {
        let remainder = n % 3;
        n = Math.floor(n / 3);

        if (remainder === 0) {
            remainder = 4;
            n -= 1;
        }

        answer = remainder + answer;
    }
    
    return answer;
} 