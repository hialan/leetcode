'use strict';

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if (!m || !n) {
        return 0;
    }

    let pathCounts = new Array(m).fill(1);

    for(let y=1;y<n;y++){
        for(let x=1;x<m;x++) {
            pathCounts[x] += pathCounts[x-1];   // pathCount[x] is up value, pathCount[x-1] is left value
        }
    }

    return pathCounts[m-1];
};

console.log(3, uniquePaths(3, 2));
console.log(28, uniquePaths(7, 3));