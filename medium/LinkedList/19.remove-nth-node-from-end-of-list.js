// https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
 var removeNthFromEnd = function(head, n) {
  // case 1: remove middle
  // case 2: remove first
  // case 3: remove last
  
  let length = 0;
  for(let node = head; node !== null; node = node.next) {
      length++;
  }
  const removeN = length - n + 1;
  
  if(removeN === 1) {
      return head.next;
  }
  
  for(let node = head, curr = 0, prev = null; 
      node !== null; 
      prev = node, node = node.next
  ) {
      curr++;
      if(curr === removeN) {
          prev.next = node.next;
          break;
      }
  }
  
  return head;
};

// Runtime: 77 ms, faster than 76.58% of JavaScript online submissions for Remove Nth Node From End of List.
// Memory Usage: 42.9 MB, less than 40.79% of JavaScript online submissions for Remove Nth Node From End of List.