import java.util.Arrays;
import java.util.HashMap;

/* my solution */
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result = this._coinChange(coins, coins.length - 1,amount, 0, Integer.MAX_VALUE);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private int _coinChange(int[] coins, int index, int amount, int currCount, int minTatol) {
        if(index < 0) {
            return Integer.MAX_VALUE;
        }

        for(int coinCount = amount / coins[index]; coinCount >= 0; coinCount--) {
            int remainAmount = amount - coinCount * coins[index];
            int newCount = currCount + coinCount;

            if(remainAmount > 0 && newCount < minTatol) {
                int newTotal = _coinChange(coins, index - 1, remainAmount, newCount, minTatol);

                if(newTotal != Integer.MAX_VALUE && newTotal < minTatol) {
                    minTatol = newTotal;
                }
            } else if(newCount < minTatol) {
                minTatol = newCount;
            } else if(newCount >= minTatol) {
                break;
            }
        }
        
        return minTatol;
    }
}

/* best solution 2 */
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1]; // f[0], ... , f[amount]
        int n = coins.length;

        f[0] = 0;

        int i, j;

        for (i = 1; i <= amount; ++i) {
            f[i] = Integer.MAX_VALUE;

            // last coin A[0], A[1], ... A[j], A[n-1]
            for (j = 0; j < n; ++j) {
                if (coins[j] <= i && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }

        if (f[amount] == Integer.MAX_VALUE) {
            f[amount] = -1;
        }
        return f[amount];
    }
}
*/

/* best solution 1 */
/*
class Solution {
    int total = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        count(amount, coins.length - 1, coins, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    void count(int amount, int index, int[] coins, int count) {
        if (index < 0 || count >= total - 1)
            return;
        int c = amount / coins[index];
        for (int i = c; i >= 0; i--) {
            int newCount = count + i;
            int rem = amount - i * coins[index];

            if (rem > 0 && newCount < total)
                count(rem, index - 1, coins, newCount);
            else if (newCount < total)
                total = newCount;
            else if (newCount >= total - 1)
                break;
        }
    }
}
*/

class CoinChange {
    static public void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("[1, 2, 5] & 11 => " + sol.coinChange(new int[] { 1, 2, 5 }, 11));
        System.out.println("[2] & 3 => " + sol.coinChange(new int[] { 2 }, 3));
        System.out.println("[1] & 2 => " + sol.coinChange(new int[] { 1 }, 2));
        System.out.println("[3,7,405,436] & 8839 => " + sol.coinChange(new int[] { 3, 7, 405, 436 }, 8839));
    }
}