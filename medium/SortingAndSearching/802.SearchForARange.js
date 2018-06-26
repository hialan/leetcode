'use strict';

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let ret = [-1, -1];
    
    nums.forEach((n, i) => {
        if (n === target) {
            if(ret[0] === -1) {
                ret[0] = ret[1] = i;
            } else if(i > ret[1]) {
                ret[1] = i;
            }
        }
    });
    
    return ret;
};

console.log([3, 4], searchRange([5,7,7,8,8,10], 8));
console.log([-1,-1], searchRange([5,7,7,8,8,10], 6));