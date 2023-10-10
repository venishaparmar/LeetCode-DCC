/*
-----------------------Problem Statement-----------------------
You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
nums is considered continuous if both of the following conditions are fulfilled:
All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
Return the minimum number of operations to make nums continuous.

-----------------------Example 1:-----------------------
Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.

-----------------------Example 2:-----------------------
Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.

-----------------------Example 3:-----------------------
Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.
 
-----------------------Constraints:-----------------------

1 <= nums.length <= 105
1 <= nums[i] <= 109

-----------------------Intuition-----------------------
We can make the array continuous by changing some of the elements to other integers. 
The minimum number of operations required to do this is equal to the difference between the maximum element 
and the minimum element in the array, minus the length of the array plus 1. This is because we need to make all of 
the elements in the array unique, and we need to make the difference between the maximum and minimum elements equal 
to the length of the array minus 1.

-----------------------Approach-----------------------
Sort the array.
Iterate over the array.
For each element, find the smallest element that is greater than or equal to the current element plus the length of the array.
Change the current element to the new value.
Keep track of the minimum number of operations required.
-----------------------Complexity-----------------------

Time complexity: O(n log n), where n is the length of the input array. 
This is because we need to sort the array and then iterate over it once to find the minimum and maximum elements.

Space complexity: O(n), where n is the length of the input array. 
This is because we need to create a new array to store the unique elements of the original array.
-----------------------Code-----------------------
*/
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans=n;
        Arrays.sort(nums); // Sort the array in ascending order.
        int m=1;
        int j=0;
        // Iterate over the original array.
        for(int i=1;i<n;i++)
        {
            // If the current element is unique, add it to the new array.
            if(nums[i]!=nums[i-1])
            {
                nums[m]=nums[i];
                m++;
            }
        }
        // Calculate the difference between the maximum and minimum elements in the new array.
        for(int i=0;i<m;i++)
        {
            // Find the first element in the new array that is greater than or equal to the current element plus the length of the input array.
            while(j<m && nums[j]<nums[i]+n)
            {
                j++;
            }
            ans = Math.min(ans, n-j+i);// Update the minimum number of operations required.
        }
        return ans;

    }
}
