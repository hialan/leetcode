import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        int movedCount = 0;
        for (int i = 0; i < k; i++) {
            int tmp = nums[i];
            int cur = i;
            do {
                movedCount++;
                nums[cur] = nums[(cur + nums.length - k) % nums.length];
                cur = (cur + nums.length - k) % nums.length;
            } while(cur != i);
            nums[(i + k) % nums.length] = tmp;
            if(movedCount == nums.length) {
                return;
            }
        }
        return;
    }
}

class RotateArray {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        sol.rotate(test, 3);
        System.out.println("[1,2,3,4,5,6,7], k=3 => " + Arrays.toString(test));

        test = new int[] { -1, -100, 3, 99 };
        sol.rotate(test, 2);
        System.out.println("[-1,-100,3,99], k=2 => " + Arrays.toString(test));

        test = new int[] { -1, -100, 3, 99 };
        sol.rotate(test, 6);
        System.out.println("[-1,-100,3,99], k=6 => " + Arrays.toString(test));


    }
}