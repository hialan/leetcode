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
var zigzagLevelOrder = function (root) {
    if(root === null) {
        return [];
    }

    let result = [];
    let breadthTree = [
        [root]
    ];

    for(let depth = 0; breadthTree[depth].length > 0; depth++) {
        breadthTree[depth+1] = [];
        breadthTree[depth].forEach(node => {
            if(node.left != null) {
                breadthTree[depth+1].push(node.left);
            }
            
            if(node.right != null) {
                breadthTree[depth+1].push(node.right);
            }
        });  
    }

    for(let depth = 0; breadthTree[depth].length > 0; depth++) {
        result[depth] = [];

        if(depth % 2 === 0) {
            // left to right
            for(let i = 0; i < breadthTree[depth].length; i++) {
                result[depth].push(breadthTree[depth][i].val);
            }
        } else {
            for(let i = breadthTree[depth].length - 1; i >= 0 ; i--) {
                result[depth].push(breadthTree[depth][i].val);
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
var r = new TreeNode(3);
r.left = new TreeNode(9);
r.right = new TreeNode(20);
r.right.left = new TreeNode(15);
r.right.right = new TreeNode(7);

ans = zigzagLevelOrder(r);
console.log(ans);