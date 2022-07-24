// https://leetcode.com/problems/lru-cache/

/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    
    this.root = -1;
    this.nodes = []; // [{prev, key, value, next}]
    this.index = new Map(); // key -> index
};

LRUCache.prototype.debug = function(...args) {
    console.log(...args);
}

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if(!this.index.has(key)) {
        this.debug('get', key, -1);
        return -1;
    }
    
    const i = this.index.get(key);
    
    if (i !== this.root) {
        // remove itself
        const iprev = this.nodes[i].prev;
        const inext = this.nodes[i].next;
        this.nodes[iprev].next = inext;
        this.nodes[inext].prev = iprev;

        if(this.root == i) {
          this.root = inext;
        }

        // insert it as the first
        const r = this.root;
        const last = this.nodes[r].prev; 
        this.nodes[i].prev = last;
        this.nodes[i].next = r;

        this.nodes[r].prev = i;
        this.nodes[last].next = i;

        this.root = i;        
    }
    
    this.debug('get', key, this.nodes[i].value);
    this.dump();
    return this.nodes[i].value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    this.debug('put', key, value);
    if(this.index.has(key)) {
        this.nodes[this.index.get(key)].value = value;
		this.get(key);
        this.dump(); 
        return null;
    }

    if(this.nodes.length === this.capacity) {
        const i = this.nodes[this.root].prev;
        
        // remove last 
        const oldKey = this.nodes[i].key;
        this.index.delete(oldKey);

        this.nodes[i].key = key;
        this.nodes[i].value = value;
        
        this.index.set(key, i);
        this.root = i;
    } else {
        const i = this.nodes.length;
        
        if (i === 0) {
            this.nodes[i] = {
                prev: 0, 
                next: 0,
                key, 
                value
            }
        } else {
            const prev = this.nodes[this.root].prev; 
            const next = this.root; 

            this.nodes[i] = {
                prev,
                next,
                key,
                value,
            }
            this.nodes[next].prev = i;
            this.nodes[prev].next = i;
        }
        
		this.index.set(key, i);
        this.root = i;
    }
    this.dump(); 
    return null;
};

LRUCache.prototype.dump = function() {
	this.debug(JSON.stringify({nodes: this.nodes, index: this.index, cap: this.capacity, root: this.root}, null ,2));
}

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */


// test case 1
/*
const obj = new LRUCache(2);
obj.put(1, 1);
obj.put(2, 2);
obj.get(1);
obj.put(3, 3);
obj.get(2);
obj.put(4, 4);
obj.get(1);
obj.get(3);
obj.get(4);
*/ 

// test case 2
/*
const obj = new LRUCache(2);
obj.put(2, 1);
obj.put(1, 1);
obj.put(2, 3);
obj.put(4, 1);
obj.get(1);
obj.get(2);
*/

// test case 3
// const obj = new LRUCache(2);
// obj.put(2, 1);
// obj.put(3, 2);
// obj.get(3);
// obj.get(2);
// obj.put(4, 3);
// obj.get(2);
// obj.get(3);
// obj.get(4);

const [ cmds, params, output ] = [
    ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"], 
    [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]],
    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
]; 

const obj = new LRUCache(params[0][0]);
for(let i = 1;i < cmds.length; i++) {
    const result = obj[cmds[i]].apply(obj, params[i]);
    if(result !== output[i]) {
        console.log('wrong', 'i', {cmd: cmds[i], param: params[i], expected: output[i], actual: result})
    }
}

// Runtime: 636 ms, faster than 87.92% of JavaScript online submissions for LRU Cache.
// Memory Usage: 101.4 MB, less than 77.38% of JavaScript online submissions for LRU Cache.