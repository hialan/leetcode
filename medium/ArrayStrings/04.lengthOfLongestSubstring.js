'use strict';

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let substring = [];
    let maxLength = 0;
    let arr = s.split('');
    arr.forEach((ch) => {
        let idx = substring.indexOf(ch);
        if(idx === -1) {
            substring.push(ch);
        } else {
            if(substring.length > maxLength) {
                maxLength = substring.length;
            }
            substring = substring.splice(idx+1);
            substring.push(ch);
        }
    });
    if(maxLength < substring.length) {
        maxLength = substring.length;
    }
    return maxLength;
};

var result = lengthOfLongestSubstring("c");
console.log(result);