'use strict';
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let i, j, k;
    let results = [];
    let len = nums.length;
    let sortFunc = (a, b) => { return a - b };

    nums.sort(sortFunc);

    for(i = 0; i < len - 2; i++) {
      if(nums[i] > 0) continue;
      if(i > 0 && nums[i] === nums[i-1]) continue;
        for( j = i+1, k = nums.length -1; j < k; ) {
            if(nums[i] + nums[j] + nums[k] === 0) {
              results.push([nums[i], nums[j], nums[k]]);
              j++; k--;
              while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
              while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
            } else if (nums[i] + nums[j] + nums[k] > 0) {
              k--;
            } else {
              j++;
            }
        }
    }

    return results;
};