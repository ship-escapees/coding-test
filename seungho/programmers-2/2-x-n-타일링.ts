/*
가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 
타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.

타일을 가로로 배치 하는 경우
타일을 세로로 배치 하는 경우
예를들어서 n이 7인 직사각형은 다음과 같이 채울 수 있습니다.

직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.

제한사항
가로의 길이 n은 60,000이하의 자연수 입니다.
경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

일반 점화식 문제
n일 때, 방법의 수
=> a=1, 1
=> a=2, 2
=> a=3, 3   a3 = a2 + a1
=> a=4, 5   a4 = a3 + a2
=> a=n,     an = a(n-1) + a(n-2) 즉 첫 째항 부터 셋 째항 까지만 구하면 일반 점화식이 완성됨
*/

const tiling2n = (n: number) => {
    if (n === 1) return 1;
    if (n === 2) return 2;

    let prevPrev = 1; 
    let prev = 2;      
    let current = 0;

    const MOD = 1_000_000_007;

    for (let i = 3; i <= n; i++) {
        current = (prev + prevPrev) % MOD;
        prevPrev = prev;
        prev = current;
    }

    return current;
}