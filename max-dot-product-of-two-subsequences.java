/*
---------------Problem Statement----------------------
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

 

----------------------Example 1:----------------------

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.

----------------------Example 2:----------------------

Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.

----------------------Example 3:----------------------

Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.
 

----------------------Constraints:----------------------

1 <= nums1.length, nums2.length <= 500
-1000 <= nums1[i], nums2[i] <= 1000

----------------------Intuition----------------------
The maximum dot product of two subsequences of the same length can be found by considering all possible subsequences of both arrays and 
finding the one with the maximum dot product. This is a brute-force approach and can be very inefficient for large arrays.

A more efficient approach is to use dynamic programming. This approach works by building a table that stores the maximum dot product 
of two subsequences of the same length up to a certain index in both arrays. The table is then used to compute the maximum dot product of 
two subsequences of the same length in the entire arrays.

----------------------Approach----------------------
The dynamic programming approach to solving this problem is as follows:

Create a table dp[n + 1][m + 1], where n is the length of the first array and m is the length of the second array.
Initialize all entries of the table to Integer.MIN_VALUE.
Iterate over the table from bottom-up, starting at the bottom-left corner.
For each entry in the table, compute the maximum dot product of two subsequences of the same length up to that index in both arrays. 
This can be done by considering the following cases:
If the current entries in both arrays are equal, then the maximum dot product is equal to the dot product of the current entries plus 
the maximum dot product of two subsequences of the same length up to the previous index in both arrays.
If the current entries in both arrays are not equal, then the maximum dot product is equal to the maximum of the following values:
The maximum dot product of two subsequences of the same length up to the previous index in the first array.
The maximum dot product of two subsequences of the same length up to the previous index in the second array.
The maximum dot product of two subsequences of the same length in the entire arrays is given by the entry dp[n][m].
----------------------Complexity----------------------
Time complexity: O(n⋅m)
Space complexity: O(n⋅m)
----------------------Code----------------------
 */
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    dp[i][j] = Math.max(
                        nums1[i - 1] * nums2[j - 1] + Math.max(dp[i - 1][j - 1], 0),
                        Math.max(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }

        return dp[n][m];
    }
}
