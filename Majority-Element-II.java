/*
---------------Problem Statement------------------
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

------------------Example 1:------------------
Input: nums = [3,2,3]
Output: [3]

------------------Example 2:------------------
Input: nums = [1]
Output: [1]

------------------Example 3:------------------
Input: nums = [1,2]
Output: [1,2]

------------------Intuition------------------
If the array contains the majority of elements, their occurrence must be greater than the floor(N/3). 
Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. 
So when we traverse through the array we try to keep track of the counts of elements and the elements themselves for which 
we are tracking the counts.

After traversing the whole array, we will check the elements stored in the variables. 
Then we need to check if the stored elements are the majority elements or not by manually checking their counts.

------------------Approach------------------
1. Initialize 4 variables:
    count1 & count2 – for tracking the counts of elements
    element1 & element2 – for storing the majority of elements.
2. Traverse through the given array.
    If count1 is 0 and the current element is not element2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
    If count2 is 0 and the current element is not element1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
    If the current element and element1 are the same increase the count1 by 1.
    If the current element and element2 are the same increase the count2 by 1.
    Other than all the above cases: decrease count1 and count2 by 1.
3. The integers present in element1 & element2 should be the result we are expecting. 
So, using another loop, we will manually check their counts if they are greater than the floor(N/3).
4. Also, we are checking if the current element is already included in our elements, and if it is there, 
we will not again include it in another variable.

------------------Complexity------------------
Time complexity: 
O(N) + O(N), where N = size of the given array.
Reason: The first O(N) is to calculate the counts and find the expected majority elements. 
The second one is to check if the calculated elements are the majority ones or not.

Space complexity: 
O(1) as we are only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.

------------------Code------------------
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int count1 = 0, count2 = 0, element1 = 0, element2 = 0;

        for(int num : nums){
            if(element1 == num){
                count1++;
            }
            else if(element2 == num){
                count2++;
            }
            /* checking if the current element is already included in our elements, and if it is there, 
              we will not again include it in another variable. (num != element2)   */
            else if(count1 == 0 && num != element2){
                element1 = num;
                count1 = 1;
            }

            else if(count2 == 0 && num != element1){
                element2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }  
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == element1) {
                count1++;
            }
            else if (num == element2) {
                count2++;
            }
        }
    
        if (count1 > nums.length / 3) {
            result.add(element1);
        }
        if (count2 > nums.length / 3) {
            result.add(element2);
        }

    return result;     
    }
}
