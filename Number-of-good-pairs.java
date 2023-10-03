/*
---------------Problem Statement----------------------
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.


---------------Example 1:----------------
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

-------------Example 2:-----------------
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

---------------Example 3:----------------------
Input: nums = [1,2,3]
Output: 0
 

-----------------Constraints:-----------------
1 <= nums.length <= 100
1 <= nums[i] <= 100

--------------Intuition---------------
We can count the number of good pairs in an array by counting the number of times each element appears in the array. 
For each element, the number of good pairs it forms is equal to the number of times it appears after it in the array. 
For example, if the array is [1, 2, 3, 1, 1, 3], the element 1 appears twice in the array, and each time it appears, 
it forms a good pair with the element to its right. Therefore, the total number of good pairs formed by the element 1 is 2.

----------------Approach-----------------
To count the number of times each element appears in the array, we can use a hash table. 
We can create a hash table of size 101, where each index represents an element in the array. 
The value at each index in the hash table represents the number of times the corresponding element appears in the array.

Once we have created the hash table, we can iterate over the array and increment the value at the corresponding 
index in the hash table for each element. Finally, we can iterate over the hash table and add the value at each index to the result.

-----------Complexity--------------
Time complexity: O(n)

Space complexity: O(n)

--------------Code---------------------
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int temp[] = new int[101];
        int result = 0;
        for(int i = 0 ; i < nums.length ; i++){
            result += temp[nums[i]];
            temp[nums[i]]++;
        }
        return result;
    }
}
