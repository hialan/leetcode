class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
             return 0;   
        }
        int[] minValue = new int[prices.length];
        minValue[0] = prices[0];
        for(int i = 1;i<prices.length;i++) {
            minValue[i] = (prices[i] < minValue[i-1]) ? prices[i] : minValue[i-1];
        }
        int maxProfit = 0;
        for(int i = 0;i < prices.length;i++) {
            maxProfit = (prices[i] - minValue[i] > maxProfit) ? prices[i] - minValue[i] : maxProfit;
        }
        return maxProfit;
    }
}

class BestTimeToBuyAndSellStock {
    static public void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("[7,1,5,3,6,4] => expect(5) actual: " + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("[7,6,4,3,1] => expect(0) actual: " + sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}