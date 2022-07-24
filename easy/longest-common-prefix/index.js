/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    const minlen = strs.reduce((acc, str) => Math.min(acc, str.length), strs[0].length);
    let prefix = [];
    for(let i = 0;i < minlen ; i++) {
	    const ch = strs[0].charAt(i);
        for(let j = 1; j < strs.length; j++) {
            if (strs[j].charAt(i) !== ch) {
                return prefix.join('')
            }
        }
        prefix.push(ch);
    }
    
    return prefix.join('')
};
console.log(longestCommonPrefix(["flower","flow","flight"]));
