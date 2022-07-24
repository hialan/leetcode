import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        // int[] startPos = new int[nums.length];
        // int[] maxSum = new int[nums.length];

        // startPos[0] = 0;
        // maxSum[0] = nums[0];

        // int maxPos = 0;
        // for(int i = 1;i<nums.length;i++) {
        //     if(maxSum[i-1] < 0) {
        //         startPos[i] = i;
        //         maxSum[i] = nums[i];
        //     } else {
        //         startPos[i] = startPos[i-1];
        //         maxSum[i] = maxSum[i-1] + nums[i];
        //     }

        //     if(maxSum[i] > maxSum[maxPos]) {
        //         maxPos = i;
        //     }
        // }

        // System.out.println("nums: " + Arrays.toString(nums));
        // System.out.println("maxSum: " + Arrays.toString(maxSum));
        // System.out.println("startPos: " + Arrays.toString(startPos));

        // return maxSum[maxPos];

        int lastMaxSum = nums[0];

        int maxSum = lastMaxSum;
        for(int i = 1;i<nums.length;i++) {
            if(lastMaxSum < 0) {
                lastMaxSum = nums[i];
            } else {
                lastMaxSum += nums[i];
            }

            if(lastMaxSum > maxSum) {
                maxSum = lastMaxSum;
            }
        }

        return maxSum;
    }
}

class MaximumSubarray {
    static public void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("[-2,1,-3,4,-1,2,1,-5,4] => expect(6) actual: " + sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("[-5,-4,-3,-2,-1] => expect(-1) actual: " + sol.maxSubArray(new int[]{-5,-4,-3,-2,-1}));
        System.out.println("[] => expect(0) actual: " + sol.maxSubArray(new int[]{}));
    }
}