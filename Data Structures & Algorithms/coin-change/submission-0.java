class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int minCoins = helper(dp, coins, amount);
        // System.out.println(Arrays.toString(dp));
        return minCoins == 10001 ? -1 : minCoins;
    }

    int helper(int[] dp, int[] coins, int amount) {
        if (amount < 0) {
            return 10001;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] > 0) {
            return dp[amount];
        }
        int minCoins = 10001;
        for (int coin : coins) {
            minCoins = Math.min(1 + helper(dp, coins, amount - coin), minCoins);
        }
        // System.out.println(amount + " " + minCoins);
        return dp[amount] = minCoins;
    }
}
