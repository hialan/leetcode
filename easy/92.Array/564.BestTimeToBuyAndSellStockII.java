class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int buyIndex = 0;

        if(prices.length < 2) {
            return 0;
        }

        for(int i = 0;i<prices.length-1;i++) {
            if(prices[i+1] < prices[i]) {
                total += prices[i] - prices[buyIndex];
                buyIndex = i+1;
            }
        }

        if(prices[prices.length-1] > prices[buyIndex]) {
            total += prices[prices.length-1] - prices[buyIndex];
        }

        return total;
    }
}

/* Best Solution */
/*
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
*/

class BestTimeToBuyAndSellStockII {
    static public void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("[7,1,5,3,6,4] => expect(7) actual: " + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("[1,2,3,4,5] => expect(4) actual: " + sol.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println("[5,4,3,2,1] => expect(0) actual: " + sol.maxProfit(new int[]{5,4,3,2,1}));
        System.out.println("[] => expect(0) actual: " + sol.maxProfit(new int[]{}));
    }
}