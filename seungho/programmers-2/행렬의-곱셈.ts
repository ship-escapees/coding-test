/*
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다.
*/

const multiplyMatrices = (arr1: number[][], arr2: number[][]) => {
        let answer: number[][] = [];
        for(let i = 0; i < arr1.length; i++) {
            let row: number[] = [];
            for(let j = 0; j < arr2[0].length; j++) {
                let sum = 0;
                for(let k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                row.push(sum);
            }
            answer.push(row);
        }
        return answer;
    }

