class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        profit = 0 
        for v in prices: 
            min_price = min(min_price, v)
            profit = max(profit, v-min_price)
        return profit
