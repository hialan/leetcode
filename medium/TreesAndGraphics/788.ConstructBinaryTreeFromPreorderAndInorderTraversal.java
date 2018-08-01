import java.util.Arrays;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // System.out.println("buildTree: preorder: " + Arrays.toString(preorder) + " inorder: " + Arrays.toString(inorder));

        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        int inIndex = -1;

        TreeNode node = new TreeNode(val);
        if(preorder.length == 1 || inorder.length == 1) {
            return node;
        }

        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == val) {
                inIndex = i;    // inIndex also represent how many nodes in left tree
                break;
            }
        }

        if(inIndex > 0) {
            int[] preLeft = copyOfRange(preorder, 1, inIndex);
            int[] inLeft = copyOfRange(inorder, 0, inIndex - 1);
            node.left = buildTree(preLeft, inLeft);    
        }

        if(inIndex + 1 < inorder.length) {
            int[] preRight = copyOfRange(preorder, inIndex + 1, preorder.length - 1);
            int[] inRight = copyOfRange(inorder, inIndex + 1, inorder.length - 1);
            node.right = buildTree(preRight, inRight);    
        }

        return node;
    }

    public int[] copyOfRange(int[] arr, int from, int to) {
        int len = to - from + 1;
        int[] result = new int[len];

        for(int i=0;i<len;i++) {
            result[i] = arr[i+from];
        }

        return result;
    }
}

class Main {
    static public void printTree(TreeNode root) {
        String str = root.val + " -> ";

        if(root.left != null) {
            str += root.left.val + "(left) ";
        } else {
            str += "null (left) ";
        }

        if(root.right != null) {
            str += root.right.val + "(right) ";
        } else {
            str += "null (right) ";
        }

        System.out.println(str);

        if(root.left != null) {
            printTree(root.left);
        }

        if(root.right != null) {
            printTree(root.right);
        }

        return;
    }

    static public void main(String[] args) {
        // Example case
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Error case 1
        // int[] preorder = {1, 2};
        // int[] inorder = {1, 2};

        // Error case 2
        // int[] preorder = {1, 2, 3};
        // int[] inorder = {3, 2, 1};

        System.out.println("preorder: " + Arrays.toString(preorder));
        System.out.println("inorder: " + Arrays.toString(inorder));

        Solution sol = new Solution();

        TreeNode treeRoot = sol.buildTree(preorder, inorder);

        Main.printTree(treeRoot);

        return;
    }
}