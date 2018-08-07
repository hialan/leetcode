import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lens = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int maxLen = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i] && lens[j] > maxLen) {
                    maxLen = lens[j];
                }
            }
            lens[i] = 1 + maxLen;
        }

        // System.out.println(Arrays.toString(lens));

        int maxLen = 0;
        for(int i = 0;i<lens.length;i++) {
            if(lens[i] > maxLen) {
                maxLen = lens[i];
            }
        }

        // System.out.println(maxLen);
        return maxLen;
    }
}

/* best solution */
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int n : nums) {
            int i = 0;
            int j = len;
            // Binary search
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (dp[mid] < n) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            if (i < 0)
                i = -(i + 1);

            dp[i] = n;
            if (i == len) len++;
        }
        
        return len;
    }
}
*/

class LongestIncreasingSubsequence {
    static public void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("[10,9,2,5,3,7,101,18] => expect(4) actual: "
                + sol.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }
}