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

/*
var result = lengthOfLongestSubstring("c");
console.log(result);
*/

/*  Best solution

var lengthOfLongestSubstring = function(s) {
  if (s === null) {
    return 0;
  }
  if (s.length <= 1) {
    return s.length;
  }
  
  let longest = 1;
  let i = 0;
  let j = 1;
	
  while (j < s.length) {
    if (s.slice(i, j).indexOf(s.charAt(j)) >= 0) {
      i += s.slice(i, j).indexOf(s.charAt(j)) + 1; 		
    } else {
      longest = Math.max(j - i + 1, longest);
    }
    
    j++;
  }
  
  return longest;
}; 
*/