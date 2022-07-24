import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    
class Solution {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 1);
    }

    private int getMaxDepth(TreeNode root, int depth) {
        int left = (root.left != null) ? getMaxDepth(root.left, depth + 1) : depth;
        int right = (root.right != null) ? getMaxDepth(root.right, depth + 1) : depth;
        return (left > right) ? left : right;
    }
}