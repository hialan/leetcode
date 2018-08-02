class Solution {
    public double myPow(double x, int n) {
        int m = n;
        if(m == 0) {
            return 1;
        }

        if(m < 0) {
            x = 1 / x;
            if(m == Integer.MIN_VALUE) {
                x = x*x;
                m = -(m/2);
            } else {
                m = -m;
            }
        }

        System.out.println("x=" + x + " m=" + m);
        double ret = 1.0;

        // Note: recursive way
        // if(n%2 == 1) {
        //     ret *= x;
        // }
        // ret *= myPow(x*x, n/2);

        // Note: iterative way
        while(m>0) {
            if(m%2 == 1) {
                ret *= x;
            }
            m /= 2;
            x *= x;
        }

        return ret;
    }
}

class MyPow {
    static public void test(Solution sol, double x, int n, double expectedResult) {
        System.out.println(x + "^" + n + " => expectedResult(" + expectedResult + ") actual(" + sol.myPow(x, n) + ")");
    }

    static public void main(String[] args) {
        Solution sol = new Solution();

        test(sol, 2, 10, 1024);
        test(sol, 2.1, 3, 9.2610);
        test(sol, 2, -2, 0.25);
        test(sol, 2, -2147483648, 0);
    }
}