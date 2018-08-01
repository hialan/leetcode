import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> usedNumber = new HashSet<>();
        usedNumber.add(n);

        while(true) {
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = (n - digit) / 10;
            }

            if(sum == 1) {
                return true;
            }

            if(usedNumber.contains(sum)) {
                //return false;
                break;
            }

            usedNumber.add(sum);
            n = sum;
        }

        return false;
    }
}

class HappyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("19: " + sol.isHappy(19));
    }
}