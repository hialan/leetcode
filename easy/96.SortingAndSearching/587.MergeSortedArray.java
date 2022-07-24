import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m+n-1;i>=0;i--) {
            if(m > 0 && n > 0) {
                // System.out.println(" m > 0 && n > 0");
                if(nums1[m-1] > nums2[n-1]) {
                    nums1[i] = nums1[m-1];
                    --m;
                } else if(nums2[n-1] >= nums1[m-1]) {
                    nums1[i] = nums2[n-1];
                    --n;
                }                
            } else if(m > 0) {
                // System.out.println(" m > 0");
                nums1[i] = nums1[m-1];
                --m;
            } else if(n > 0) {
                // System.out.println(" n > 0");
                nums1[i] = nums2[n-1];
                --n;            
            }

            // System.out.println(Arrays.toString(nums1) + " i: " + i + " m: " + m + " n: " + n);
        } 
    }
}

class MergeSortedArray {
    static public void main(String[] args) {
        Solution sol = new Solution();

        
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        sol.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }
}