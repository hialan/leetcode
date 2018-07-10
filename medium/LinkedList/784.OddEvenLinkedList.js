'use strict';

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function(head) {
    let lists = [
        {
            head: null,
            curr: null,
        }, {
            head: null,
            curr: null
        }
    ];
    let listIndex = 0;

    while(head !== null) {
        if(lists[listIndex].head === null) {
            lists[listIndex].head = head;
            lists[listIndex].curr = head;
        } else {
            lists[listIndex].curr.next = head;
            lists[listIndex].curr = head;
        }

        head = head.next;
        listIndex = (listIndex + 1) % 2;
    }
    
    if(lists[1].curr !== null) {
        lists[1].curr.next = null;
    }

    if(lists[0].curr !== null) {
        lists[0].curr.next = lists[1].head;
    }

    return (lists[0].head !== null) ? lists[0].head : lists[1].head;
};

////////////////////////////

function arrayToList(arr) {
    let list = null;
    let curr = null;

    arr.forEach((val) => {
        if(list === null) {
            list = new ListNode(val);
            curr = list;
        } else {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
    });

    return list;
}

function printList(head) {
    let str = '';
    while(head !== null) {
        str += head.val + "->";
        head = head.next;
    }

    str += "NULL";
    return str;
}

let list = arrayToList([1, 2, 3, 4, 5]);
let result = oddEvenList(list);
process.stdout.write(printList(result) + "\n");

list = arrayToList([2, 1, 3, 5, 6, 4, 7]);
result = oddEvenList(list);
process.stdout.write(printList(result) + "\n");