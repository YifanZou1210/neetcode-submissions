class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minstock = Integer.MAX_VALUE;
        for(int num: prices){
            minstock = Math.min(num, minstock);
            maxprofit = Math.max(num-minstock, maxprofit);
        }
        return maxprofit;
    }
}
