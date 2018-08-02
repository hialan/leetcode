class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        if(divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        int quotient = 0;
        int sum = 0;
        boolean negitive = false;
        if(divisor < 0) {
            divisor = -divisor;
            negitive = !negitive;
        }

        if(dividend == Integer.MIN_VALUE) {
            dividend += divisor;
            quotient += 1;
        }

        if(dividend < 0) {
            dividend = -dividend;
            negitive = !negitive;
        }

        // basic solution
        // while(sum+divisor > sum && sum+divisor <= dividend) {
        //     quotient++;
        //     sum += divisor;
        // }

        // use bit operation
        int multiple = 0;

        while(dividend>>multiple >= divisor) {
            multiple++;
        }
        multiple--;
        while(multiple >= 0) {
            if(dividend>>multiple >= divisor) {
                dividend -= divisor << multiple;
                quotient += 1 << multiple;
            }
            multiple--;
        }

        return (negitive) ? -quotient : quotient;
    }
}

class DivideTwoIntegers {
    static public void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("(10, 3): expect(3) actual(" + sol.divide(10, 3) + ")");
        System.out.println("(7, -3): expect(-2) actual(" + sol.divide(7, -3) + ")");
        System.out.println("(-7, 3): expect(-2) actual(" + sol.divide(-7, 3) + ")");
        System.out.println("(-7, 1): expect(-7) actual(" + sol.divide(-7, 1) + ")");
        System.out.println("(0, 2): expect(0) actual(" + sol.divide(0, 2) + ")");
        System.out.println("(2147395600, 1): expect(2147395600) actual(" + sol.divide(2147395600, 1) + ")");
        System.out.println("(2147395600, 2147395600): expect(1) actual(" + sol.divide(2147395600, 2147395600) + ")");
        System.out.println("(2147395600, -2147395600): expect(-1) actual(" + sol.divide(2147395600, -2147395600) + ")");
        System.out.println("(-2147483648, -1): expect(2147483647) actual(" + sol.divide(-2147483648, -1) + ")");
        System.out.println("(100, -10): expect(-10) actual(" + sol.divide(100, -10) + ")");
    }
}