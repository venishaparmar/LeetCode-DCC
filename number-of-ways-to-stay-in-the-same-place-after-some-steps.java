/*
-----------------------Problem Statement-----------------------
You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 
1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after exactly steps steps. 
Since the answer may be too large, return it modulo 109 + 7.

-----------------------Example 1:-----------------------
Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay

-----------------------Example 2:-----------------------
Input: steps = 2, arrLen = 4
Output: 2
Explanation: There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
Example 3:

Input: steps = 4, arrLen = 2
Output: 8
 
-----------------------Constraints:-----------------------
1 <= steps <= 500
1 <= arrLen <= 106

-----------------------Code-----------------------
*/
class Solution {
    //memoized
    static final int MOD = 1_000_000_007;
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps / 2 + 1, arrLen);
        int[][] dp = new int[arrLen][steps + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return calculateWays(steps, 0, dp);
    }
    
    private static int calculateWays(int steps, int pos, int[][] dp) {
        if (steps < pos) return 0;
        if (steps == 0) return 1;
        if (dp[pos][steps] != -1) return dp[pos][steps];
        int ways = 0;
        if (pos < dp.length - 1) ways = (ways + calculateWays(steps - 1, pos + 1, dp)) % MOD;
        if (pos > 0) ways = (ways + calculateWays(steps - 1, pos - 1, dp)) % MOD;
        ways = (ways + calculateWays(steps - 1, pos, dp)) % MOD;
        dp[pos][steps] = ways;
        return ways;
    }
}
