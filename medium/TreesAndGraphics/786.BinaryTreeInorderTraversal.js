'use strict';

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

 
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    let result = [];
    let stack = [];
    let node = root;
    while (1) {
        if(!node) {
            break;
        }
        
        if (node.left !== null) {
            stack.push(node);
            node = node.left;
            continue;
        }
        result.push(node.val);

        if(node.right !== null) {
            node = node.right;
            continue;
        } else {
            if(stack.length > 0) {
                node = stack.pop(); // parent
                node.left = null;
            } else {
                break;
            }
        }
    }

    return result;
};


function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var ans = null
var r = new TreeNode(1);
r.right = new TreeNode(2);
r.right.left = new TreeNode(3);

ans = inorderTraversal(r);
console.log(ans);