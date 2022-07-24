class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for(int i = 1;i<nums.length;i++) {
            if(nums[i] != nums[len - 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}

class RemoveDuplicatesFromSortedArray {
    static public void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.removeDuplicates(new int[]{1, 1, 2});
        System.out.println("[1, 1, 2] => expect(2) actual: " + result);
    }
}