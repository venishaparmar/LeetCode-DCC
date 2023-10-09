/*

------------------------Problem Statement----------------------------
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

----------------------------Example 1:----------------------------
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

----------------------------Example 2:----------------------------
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

----------------------------Example 3:----------------------------
Input: nums = [], target = 0
Output: [-1,-1]

----------------------------Intuition----------------------------
Binary search is an efficient algorithm for finding an item in a sorted list. It works by repeatedly dividing in half 
the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

In this problem, we can use binary search to find the start and end indices of the target value in the array. 
To do this, we need to perform two binary searches: one to find the leftmost index of the target value, and another 
to find the rightmost index.

----------------------------Approach----------------------------
To find the leftmost index of the target value, we can use the following steps:

Initialize the low and high indices to 0 and the length of the array minus 1, respectively.
While the low index is less than or equal to the high index:
Calculate the middle index, mid, as the average of the low and high indices.
If the element at the mid index is equal to the target value, then the leftmost index of the target value is mid. 
Update the high index to mid - 1.
If the element at the mid index is less than the target value, then the leftmost index of the target value is greater than mid. 
Update the low index to mid + 1.
Return the low index.
To find the rightmost index of the target value, we can use a similar approach, but we update the low index to mid + 1 if the 
element at the mid index is equal to the target value.

----------------------------Complexity----------------------------
Time complexity: O(log n), where n is the length of the array. This is because we perform two binary searches, 
each of which has a time complexity of O(log n).

Space complexity: O(1), since we only need to store a few variables.
----------------------------Code----------------------------
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);

        if (leftIndex <= rightIndex) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }
    private int binarySearch(int[] nums, int target, boolean findLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (findLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
}
