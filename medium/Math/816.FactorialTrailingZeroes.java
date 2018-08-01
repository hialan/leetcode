class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n > 1) {
            sum += (n / 5);
            n /= 5;
        }
        return sum;
    }
}

class FactorialTrailingZeroes {
    static public void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("3 => " + sol.trailingZeroes(3));
        System.out.println("5 => " + sol.trailingZeroes(5));
        System.out.println("30 => " + sol.trailingZeroes(30));

        // 1808548329 is the max of the 32-bit integer
        System.out.println("1808548329 => (Exp: 452137076) " + sol.trailingZeroes(1808548329));
    }
}