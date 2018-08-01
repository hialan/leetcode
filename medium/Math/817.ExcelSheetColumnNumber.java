class Solution {
    public int titleToNumber(String s) {
        char[] ary = s.toCharArray();
        int numA = Character.getNumericValue('A');
        int base = 1;
        int sum = 0;

        for(int i=ary.length-1;i>=0;i--, base *= 26) {
            sum += (Character.getNumericValue(ary[i]) - numA + 1) * base;
        }

        return sum;
    }
}

class ExcelSheetColumnNumber {
    static public void test(Solution sol, String s, int expectedResult) {
        System.out.println(s + " => expectedResult(" + expectedResult + ") actual(" + sol.titleToNumber(s) + ")");
    }

    static public void main(String[] args) {
        Solution sol = new Solution();

        test(sol, "A", 1);
        test(sol, "Z", 26);
        test(sol, "AA", 27);
        test(sol, "AB", 28);
        test(sol, "ZY", 701);
    }
}