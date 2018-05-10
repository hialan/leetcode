'use strict';

function sortLetter(str) {
    return str.split('').sort().join('');
}

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let map = new Map();
    
    strs.forEach((str) => {
        let key = sortLetter(str);
        if(map.has(key)) {
            let val = map.get(key);
            val.push(str);
            map.set(key, val);
        } else {
            map.set(key, [str]);
        }
    });
    
    var result = [];
    map.forEach((val) => {
        result.push(val);
    })
    
    return result;
};