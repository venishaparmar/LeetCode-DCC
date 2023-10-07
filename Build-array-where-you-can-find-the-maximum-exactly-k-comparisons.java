/*
--------------------Problem Statement---------------------------
You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:

---------------------------Intuition---------------------------
The problem asks us to count the number of arrays of length n such that each element of the array is an integer from 1 to m, 
and the sum of any contiguous subarray is less than or equal to k.

One way to think about this problem is to build the array from the left to the right. At each step, we have to choose a number 
from 1 to m to add to the array. We can only choose a number if the sum of the current subarray plus the new number is less than or equal to k.

---------------------------Approach---------------------------
We can count the number of arrays with the desired properties by building them from the left to the right. 
At each step, we can either add a new element to the array, or we can skip adding a new element.

If we add a new element to the array, it must be greater than all the elements to its left. 
This means that we can only add the number max_val + 1 to the array.

If we skip adding a new element to the array, then the maximum value of the array remains the same.

We can use dynamic programming to keep track of the number of ways to build an array with a given maximum 
value and search cost. We will define a 3D array dp where dp[i][cost][max_val] represents the number of ways 
to build an array of length i + 1 with a maximum value of max_val + 1 and a search cost of cost + 1.

The base case is dp[0][0][max_val] = 1 for all max_val. This is because there is only one way to build an empty array, 
and its search cost is always 0.

For the recursive case, we have two cases to consider:

Adding the number max_val + 1 to the array: This case is only possible if cost < i. In this case, we can add the number max_val + 1 to 
the array, and the new search cost will be cost + 1. The number of ways to build the array is therefore dp[i - 1][cost][max_val].
Skipping adding a new element to the array: This case is always possible. In this case, the maximum value of the array remains the same, 
and the search cost remains the same. The number of ways to build the array is therefore dp[i - 1][cost][max_val].
We can therefore update the value of dp[i][cost][max_val] as follows:
dp[i][cost][max_val] = (dp[i - 1][cost][max_val] + dp[i - 1][cost - 1][max_val]) % mod
where mod = 10^9 + 7.

Once we have filled the dp array, the total number of arrays with the desired properties is given by the sum of dp[n - 1][k - 1][max_val] 
for all max_val.

---------------------------Complexity---------------------------
Time complexity: O(n * m * k), since we have to fill the entire dp array.
Space complexity: O(n * m * k), since we need to store the entire dp array.
---------------------------Code---------------------------
*/
class Solution {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n][k][m];
        long mod = 1000000007;
        Arrays.fill(dp[0][0], 1);
        
        for (int i = 1; i < n; i++) {
            for (int cost = 0; cost < Math.min(i + 1, k); cost++) {
                for (int max = 0; max < m; max++) {
                    dp[i][cost][max] = (dp[i][cost][max] + (max + 1) * dp[i - 1][cost][max]) % mod;
                    if (cost != 0) {
                        long sum = 0;
                        for (int prevMax = 0; prevMax < max; prevMax++) {
                            sum += dp[i - 1][cost - 1][prevMax];
                            sum %= mod;
                        }
                        dp[i][cost][max] = (dp[i][cost][max] + sum) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int max = 0; max < m; max++) {
            ans += dp[n - 1][k - 1][max];
            ans %= mod;
        }
        return (int) ans;
    }
}
