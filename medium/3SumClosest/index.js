// https://leetcode.com/problems/3sum-closest/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    const len = nums.length;
    let i = 0, j = 1, k = 2;
    let result = nums[0] + nums[1] + nums[2];
    let rdiff = Math.abs(result - target);
    
    nums.sort((a, b) => a - b)
    
    for(i=0;i < len - 2; i++) {
        j = i + 1;
        k = len - 1;
        while(j < k) {
            const r = nums[i] + nums[j] + nums[k];
            const diff = r - target;

            if(Math.abs(diff) < rdiff) {
                result = r;
                rdiff = Math.abs(diff);
            }

            if(diff < 0) {
                j++;
                while(nums[j+1] === nums[j]) {
                    j++;
                }
            } else if (diff > 0) {
                k--;
                while(nums[k-1] === nums[k]) {
                    k--;
                }
            } else {
                break;
            }
        }
                  
        while(nums[i] === nums[i+1]) {
            i++;
        }
    }
    return result;
};

console.log(threeSumClosest([-1,2,1,-4], 1));
