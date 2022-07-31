// https://leetcode.com/problems/valid-parentheses/submissions/
/**
 * @param {string} s
 * @return {boolean}
 */
 var isValid = function(s) {
  // case 1: '[(])';
  // case 2: ')(';
  // case 3: ')'
  
  const chs = [...s];
  
  let acc = []
  for(const ch of chs) {
      if('({['.includes(ch)) {
          acc.push(ch);
          continue;
      }

      if(')]}'.includes(ch)) {
          const last = acc.pop();
          const combi = [last, ch].join('');
          if(!['()', '[]', '{}'].includes(combi)) {
              return false;
          }  
      }
  }
  return acc.length === 0;
};

// Runtime: 74 ms, faster than 82.39% of JavaScript online submissions for Valid Parentheses.
// Memory Usage: 43.4 MB, less than 15.31% of JavaScript online submissions for Valid Parentheses.