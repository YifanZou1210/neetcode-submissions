class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1; // 1级台阶有1种爬法
        dp[2] = 2; // 2级台阶有2种爬法

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 状态转移
        }

        return dp[n];
}
}
