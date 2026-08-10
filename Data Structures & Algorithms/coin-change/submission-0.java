class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); //初始值都设置为amount+1即无穷大

        dp[0] = 0;

        for(int i = 1; i<=amount; i++){
            // 尝试所有硬币，选择构成金额i的最小硬币数目
            for(int coin: coins){
                if(i-coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount? -1: dp[amount];
    }
}
