'use strict';

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var increasingTriplet = function(nums) {
    let maxId = nums.length - 1, minId = 0;
    for(let i=1;i<nums.length;i++) {
        if(nums[i] > nums[minId] && nums[i] < nums[maxId] && i > minId && i < maxId) {
            return true;
        }

        let j = nums.length - i -1;  
        if(nums[j] > nums[minId] && nums[j] < nums[maxId] && j > minId && j < maxId) {
            return true;
        }

        if(nums[j] > nums[maxId] && j > minId) {
            maxId = j;
        }
        
        if(nums[i] < nums[minId] && i < maxId) {
            minId = i;
        }
    }

    for(let i = minId + 1; i < maxId; i++) {
        if(nums[i] > nums[minId] && nums[i] < nums[maxId]) {
            return true;
        }
    }

    return false;
};


function run(expectResult, testCase) {
    console.log(expectResult, increasingTriplet(testCase), testCase);
}

run("true", [1, 2, 3, 4, 5]);
run("false", [5, 4, 3, 2, 1]);
run("false", [1, 2, 2, 1]);
run("true", [2, 5, 3, 4, 5]);
run("false", [2, 1, 5, 0, 3]);
run("true", [2, 1, 5, 0, 3, 4]);
run("true", [2, 1, 5, 0, 4, 6]);
run("false", [1, 1, -2, 6]);