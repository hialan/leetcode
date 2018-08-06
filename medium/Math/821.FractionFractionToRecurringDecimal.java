import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == Integer.MIN_VALUE && denominator == Integer.MIN_VALUE) {
            return "1";
        }

        StringBuffer ret = new StringBuffer();

        long denominL = (long) denominator;
        long numL = (long)numerator;
        long intPart = numL / denominL;
        if(intPart == 0) {
            if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
                ret.append('-');
            }
        }
        ret.append(intPart);

        denominL = (denominator < 0) ? -1 * (long)denominator : (long)denominator;
        numL = (numerator < 0) ? -1 * (long)numerator : (long)numerator;
        long remainder = numL % denominL;
        // System.out.println(numerator + " / " + denominator + " = " + remainder);
        if(remainder > 0) {
            ret.append('.');
        }
        HashMap<Long, Integer> usedNumMap = new HashMap<>();

        long append = 0;
        while(remainder > 0) {
            // System.out.println("ret=" + ret.toString() + " remainder: " + remainder + " usedMap:" + usedNumMap.toString());

            if(usedNumMap.containsKey(remainder)) {
                // loop here
                int pos = usedNumMap.get(remainder);
                String prefix = ret.substring(0, pos);
                String loopPart = ret.substring(pos);

                ret = new StringBuffer(prefix + "(" + loopPart + ")");
                break;
            } else {
                usedNumMap.put(remainder, ret.length());
            }

            remainder *= 10;
            if(remainder >= denominL) {
                append = remainder / denominL;
                remainder -= append * denominL;
            } else {
                append = 0;
            }

            ret.append(append);
        }

        return ret.toString();
    }
}

class FractionFractionToRecurringDecimal {
    static public void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("1 / 2: expect(0.5) actual(" + sol.fractionToDecimal(1, 2) + ")");
        System.out.println("2 / 1: expect(2) actual(" + sol.fractionToDecimal(2, 1) + ")");
        System.out.println("2 / 3: expect(0.(6)) actual(" + sol.fractionToDecimal(2, 3) + ")");
        System.out.println("4 / 333: expect(0.(012)) actual(" + sol.fractionToDecimal(4, 333) + ")");
        System.out.println("7 / -12: expect(-0.58(3)) actual(" + sol.fractionToDecimal(7, -12) + ")");
        System.out.println("-1 / -2147483648: expect(0.0000000004656612873077392578125) actual(" + sol.fractionToDecimal(-1, -2147483648) + ")");

        System.out.println("-2 / 1: expect(-2) actual(" + sol.fractionToDecimal(-2, 1) + ")");
        System.out.println("67 / 9: expect(7.(4)) actual(" + sol.fractionToDecimal(67, 9) + ")");
        System.out.println("-2147483648 / -1: expect(2147483648) actual(" + sol.fractionToDecimal(-2147483648, -1) + ")");
        System.out.println("-2147483648 / -2147483648: expect(1) actual(" + sol.fractionToDecimal(-2147483648, -2147483648) + ")");
        System.out.println("-2147483648 / 3: expect(-715827882.(6)) actual(" + sol.fractionToDecimal(-2147483648, 3) + ")");
    }
}