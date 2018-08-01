import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> usedNumber = new HashSet<>();
        usedNumber.add(n);

        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            if(usedNumber.contains(sum)) {
                return false;
            }

            usedNumber.add(sum);
            n = sum;
        }

        return true;
    }
}

class HappyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("19: " + sol.isHappy(19));
    }
}