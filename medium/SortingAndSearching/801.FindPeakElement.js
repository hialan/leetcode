'use strict';

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    if(nums.length === 1) {
        return 0;
    }

    for(let i = 1;i<nums.length-1;i++) {
        if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
            return i;
        }
    }

    // not found, then we check edge (first & last)
    if(nums[0] > nums[1]) {
        return 0;
    }

    if(nums[nums.length-1] > nums[nums.length-2]) {
        return nums.length-1;
    }

    return -1;
};

console.log(2, findPeakElement([1,2,3,1]));
console.log(1, findPeakElement([1,2,1,3,5,6,4]));
console.log(0, findPeakElement([1]));
console.log(0, findPeakElement([2, 1]));
console.log(0, findPeakElement([3, 2, 1]));