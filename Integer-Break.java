/*
-------------Problem Statement--------------
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.
-------------Example 1:-------------

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

-------------Example 2:-------------
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 
-------------Constraints:-------------

2 <= n <= 58

-------------Intuition-------------
The problem can be solved by breaking down the integer into smaller and smaller integers,
and maximizing the product of those integers at each step. For example, to break down the integer 10, 
we can break it down into 3 + 3 + 4, or 2 + 5 + 3, or 5 + 5, etc. The maximum product of the resulting integers is 36.

-------------Approach-------------
The code uses a dynamic programming approach to solve the problem. 
The dynamic programming table maxProduct stores the maximum product of the integers that can be 
obtained by breaking down the integer num into smaller and smaller integers. 
The table is filled bottom-up, starting from the base cases for numbers 1, 2, and 3.

To fill the table for a larger number num, the code iterates through all smaller numbers and 
calculates the maximum product that can be obtained by breaking down num into subNum and num - subNum. 
The maximum product for num is then stored in the table.

Once the table is filled, the maximum product of the integers that can be obtained by breaking down the integer n 
is the value stored in maxProduct[n].

-------------Complexity-------------

Time complexity: O(n^2), where n is the input integer. 
This is because the dynamic programming table is filled bottom-up, and each entry in the table requires us to 
iterate through all smaller numbers.
Space complexity: O(n), where n is the input integer. This is because the dynamic programming table stores 
the maximum product for each number from 1 to n.

-------------Code-------------
*/
class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        // Dynamic programming table to store maximum products
        int[] maxProduct = new int[n + 1];

        // Base cases for numbers 1, 2, and 3 -only for computing for the rest of the numbers-
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;

        // Fill the dynamic programming table for larger numbers
        for (int num = 4; num <= n; ++num) {
            int maxProductForNum = 0;
            // Iterate through smaller numbers to calculate the maximum product
            for (int subNum = 1; subNum <= num / 2; ++subNum) {
                maxProductForNum = Math.max(maxProductForNum, maxProduct[subNum] * maxProduct[num - subNum]);
            }
            // Update the maximum product for the current number
            maxProduct[num] = maxProductForNum;
        }
        return maxProduct[n];
    }
}
