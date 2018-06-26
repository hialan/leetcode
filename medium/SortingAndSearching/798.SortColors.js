'use strict';
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let begin=0, end=nums.length - 1;

    for(let i=0;i<=end;) {
        if(nums[i] === 2) {
            swap(nums, i, end);
            end--;
        }
        
        if(nums[i] === 0) {
            swap(nums, i, begin);
            begin++;
            i++;
        }

        if(nums[i] === 1) {
            i++;
        }
    }
};


function swap(nums, i, j) {
    let a = nums[i];
    nums[i] = nums[j];
    nums[j] = a;
}

var nums = [2,0,2,1,1,0];
sortColors(nums);
console.log(nums);

nums = [2, 0, 1];
sortColors(nums);
console.log(nums);
