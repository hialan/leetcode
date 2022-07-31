// https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
 var mergeTwoLists = function(list1, list2) {
  // case 1: a=[1,2,4], b=[1,3,4]
  // case 2: a=[], b=[1,3,4]
  // case 3: a=[1,2,4], b=[]
  // case 4: a=[],b=[]
  let curr1 = list1;
  let curr2 = list2;
  let head = null;
  
  if(!curr1) {
      return curr2;
  } else if(!curr2) {
      return curr1;
  } else {
      if(curr1.val < curr2.val) {
          head = curr1;
          curr1 = curr1.next;
      } else {
          head = curr2;
          curr2 = curr2.next;
      }
  }
  
  let curr = head;
  
  while(curr1 || curr2) {
      if(!curr1) {
          curr.next = curr2; 
          return head;
      }
      
      if(!curr2) {
          curr.next = curr1;
          return head;
      }
      
      if(curr1.val < curr2.val) {
          curr.next = curr1;
          curr1 = curr1.next;
      } else {
          curr.next = curr2;
          curr2 = curr2.next;
      }
      curr = curr.next;
  }
  
  return head;
};

// Runtime: 107 ms, faster than 43.80% of JavaScript online submissions for Merge Two Sorted Lists.
// Memory Usage: 44 MB, less than 79.24% of JavaScript online submissions for Merge Two Sorted Lists.