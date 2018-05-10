'use strict';
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {    
    let start = 0;
    let len = 1;

    function extendPalindrome(s, i, j) {
        while(i >= 0 && j < s.length && s[i] === s[j]) {
            i -= 1;
            j += 1;
        }
        if(len < j-i-1) {
            len = j-i-1;
            start = i+1;
        }
    }
    for(let idx = 0; idx < s.length; idx++) {
        extendPalindrome(s, idx, idx);
        extendPalindrome(s, idx, idx+1);
    }

    return s.substring(start, start+len);
};
//console.log(checkPalindrome('ddcc'));
console.log(longestPalindrome('aba'));