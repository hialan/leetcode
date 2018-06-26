'use strict';

/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function (intervals) {
    let ret = [];
    let latest = null;

    intervals.sort((a, b) => {
        if(a.start !== b.start) {
            return (a.start < b.start) ? -1 : 1;
        } else {
            return (a.end < b.end) ? -1 : 1;
        }
    });

    intervals.forEach((current) => {
        if (latest === null || latest.end < current.start) {
            if (latest) {
                ret.push(latest);
            }

            latest = current;
        } else if (current.end > latest.end) {
            latest.end = current.end;
        }
    });

    if(latest) {
        ret.push(latest);
    }

    return ret;
};

function Interval(start, end) {
    this.start = start;
    this.end = end;
}

let input = [
    new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)
];
console.log(merge(input));

input = [
    new Interval(1, 4), new Interval(1, 5)
];
console.log(merge(input));

input = [
    new Interval(1, 4), new Interval(2, 3)
];
console.log(merge(input));