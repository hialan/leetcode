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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let first = null;
    let curr = null;

    let i = 0;
    
    while(l1 !== null || l2 !== null || i !== 0) {
        if(l1 !== null) {
            i += l1.val;    
            l1 = l1.next;
        }

        if(l2 !== null) {
            i+= l2.val;
            l2 = l2.next;
        }

        if(first === null) {
            first = new ListNode(i % 10);
            curr = first;
        } else {
            curr.next = new ListNode(i % 10);
            curr = curr.next;
        }

        i = parseInt(i / 10);
    }
    return first;
};

/////////////////////////////////////////////

function numberToList(num) {
    let first = null;
    let current = null;

    while(num > 0) {
        let n = num % 10;

        if(first === null) {
            first = new ListNode(n);
            current = first;
        } else {
            current.next = new ListNode(n);
            current = current.next;
        }

        num = parseInt(num / 10);
    }

    if(first === null) {
        first = new ListNode(0);
    }

    return first;
}

function listToNumber(list) {
    let result = 0;
    let i = 1;

    while(list !== null) {
        result += (list.val * i);
        list = list.next;
        i *= 10;
    }

    return result;
}

function listToArray(list) {
    let result = [];

    while(list !== null) {
        result.push(list.val);
        list = list.next;
    }

    return result;
}

// var l1 = numberToList(342);
// var l2 = numberToList(465);
// var result = addTwoNumbers(l1, l2);
// console.log(listToArray(result));


// var l1 = numberToList(0);
// var l2 = numberToList(0);
// var result = addTwoNumbers(l1, l2);
// console.log(listToArray(result));

var l1 = numberToList(5);
var l2 = numberToList(5);
var result = addTwoNumbers(l1, l2);
console.log(listToArray(result));