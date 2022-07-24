// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

const mapping = {
  1: [],
  2: [..."abc"],
  3: [..."def"],
  4: [..."ghi"],
  5: [..."jkl"],
  6: [..."mno"],
  7: [..."pqrs"],
  8: [..."tuv"],
  9: [..."wxyz"],
  0: [],
};

const recurrsive = (digits) => {
  if (digits.length === 1) {
    return mapping[parseInt(digits[0])];
  }

  const [digit, ...subdigits] = digits;
  const subresults = recurrsive(subdigits);
  const list = mapping[parseInt(digit)];
  return list.reduce(
    (acc, curr) => [...acc, ...subresults.map((r) => `${curr}${r}`)],
    []
  );
};

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  if(digits.length === 0) {
    return [];
  }
  return recurrsive([...digits]);
};

// const result = letterCombinations("23");
// console.log(result);