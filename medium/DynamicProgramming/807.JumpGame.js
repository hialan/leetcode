'use strict';

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
    let flag = [];
    for (let i = 0; i < nums.length; i++) {
        flag.push(false);
    }
    flag[nums.length - 1] = true;

    for (let i = nums.length - 2; i >= 0; i--) {
        let len = Math.min(i + nums[i] + 1, nums.length);
        for (let j = len - 1; j > i; j--) {
            //console.log('i', i, 'j', j, 'len', len);
            if (flag[j] === true) {
                flag[i] = true;
                break;
            }
        }
    }

    return flag[0];
};

console.log(true, canJump([2, 3, 1, 1, 4]));
console.log(false, canJump([3, 2, 1, 0, 4]));