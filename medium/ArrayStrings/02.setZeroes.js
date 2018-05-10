'use strict';
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */

// https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
var setZeroes = function(matrix) {
    let lenY = matrix.length;
    let lenX = matrix[0].length;
    let col0 = 1;
    
    for(let j = 0;j < lenY; j++) {
        if(matrix[j][0] === 0) {
            col0 = 0;
        }
        for(let i = 1; i < lenX; i++) {
            if(matrix[j][i] === 0) {
                matrix[j][0] = matrix[0][i] = 0;
            }
        }
    }
    
    for(let j = lenY - 1; j >= 0 ; j--) {
        for(let i = lenX - 1;i >= 1; i--) {
            if(matrix[j][0] === 0 || matrix[0][i] === 0) {
                matrix[j][i] = 0;
            }
        }
        if(col0 === 0) {
            matrix[j][0] = 0;
        }
    }
    
    return;
};