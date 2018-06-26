'use strict';
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    nums.sort((a, b) => {
        return a > b ? -1 : 1;
    });

    return nums[k - 1];
};

console.log(5, findKthLargest([3,2,1,5,6,4], 2));
console.log(4, findKthLargest([3,2,3,1,2,4,5,5,6], 4));
console.log(10, findKthLargest([3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6], 2));