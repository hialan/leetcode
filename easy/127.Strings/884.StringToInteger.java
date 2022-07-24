class Solution {
    public int myAtoi(String str) {
        int begin = 0;
        int end = 0;
        boolean negative = false;

        if(str == null || str.length() == 0) {
            return 0;
        }

        // strip whitespace
        while(begin < str.length() && str.charAt(begin) == ' ') {
            begin++;
        }

        if(begin >= str.length()) {
            return 0;
        }
        
        System.out.println("negative: " + negative);

        if(str.charAt(begin) == '-') {
            negative = true;
            begin++;
        } else if(str.charAt(begin) == '+') {
            begin++;
        }

        System.out.println("negative: " + negative);

        if(begin >= str.length()) {
            return 0;
        }
        
        char c = str.charAt(begin);
        if(c < '0' && c > '9') {
            return 0;
        }
        
        end=begin;
        int num = 0;
        
        int max = Integer.MAX_VALUE / 10;
        System.out.println("max: " + max);
        while(c >= '0' && c <= '9') {
            System.out.println("num: " + num);
            if(num > max || (num == max && (c - '0') > Integer.MAX_VALUE % 10)) {
                if(negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            
            num = num*10 + (c - '0');
            end++;
            if(end < str.length()) {
                c = str.charAt(end);
            } else {
                break;
            }
        }
        
        if(negative) {
            return -num;
        } else {
            return num;
        }
    }
}

class StringToInteger {
    static public void main(String[] args) {
        Solution sol = new Solution();
        // System.out.println("expect(42) => " + sol.myAtoi("42"));
        // System.out.println("expect(-42) => " + sol.myAtoi("   -42"));
        // System.out.println("expect(4193) => " + sol.myAtoi("4193 with words"));
        // System.out.println("expect(0) => " + sol.myAtoi("words and 987"));
        // System.out.println("expect(-2147483648) => " + sol.myAtoi("-91283472332"));
        // System.out.println("expect(0) => " + sol.myAtoi(""));
        // System.out.println("expect(0) => " + sol.myAtoi(null));
        // System.out.println("expect(0) => " + sol.myAtoi(" "));
        // System.out.println("expect(2147483647) => " + sol.myAtoi("2147483648"));
        // System.out.println("expect(2147483646) => " + sol.myAtoi("2147483646"));
        System.out.println("expect(-2147483648) => " + sol.myAtoi("-91283472332"));
    }
}