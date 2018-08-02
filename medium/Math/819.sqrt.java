class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }

        if(x <= 3) {
            return 1;
        }

        int y = 2;
        while((y+1)*(y+1) <= x && (y+1)*(y+1) > y*y) {
            y++;
        }

        return y;
    }
}

class MySqrt {
    static public void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("4: expect(2) actual(" + sol.mySqrt(4) + ")");
        System.out.println("8: expect(2) actual(" + sol.mySqrt(8) + ")");
        System.out.println("9: expect(3) actual(" + sol.mySqrt(9) + ")");
        System.out.println("2147395599: expect(46339) actual(" + sol.mySqrt(2147395599) + ")");
        System.out.println("2147395600: expect(46340) actual(" + sol.mySqrt(2147395600) + ")");
    }
}