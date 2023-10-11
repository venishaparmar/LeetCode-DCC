/*
----------------------------Problem Statement------------------------------
url-https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/

You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be 
in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, 
where people[i] is the time that the ith person will arrive to see the flowers.

Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.

------------------------------Example 1:------------------------------
Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
Output: [1,2,2,2]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.

------------------------------Example 2:------------------------------
Input: flowers = [[1,10],[3,3]], poeple = [3,3,2]
Output: [2,2,1]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
 

------------------------------Constraints:------------------------------

1 <= flowers.length <= 5 * 104
flowers[i].length == 2
1 <= starti <= endi <= 109
1 <= people.length <= 5 * 104
1 <= people[i] <= 109

------------------------------Intuition------------------------------
To find the number of flowers in full bloom for each person, we can use a binary search to find the first and last 
flower that are in full bloom during the person's arrival time. The difference between these two indices will be the
number of flowers in full bloom.

------------------------------Approach------------------------------
Sort the start and end times of the flowers. This will allow us to efficiently find the first and last flower in full bloom 
during a person's arrival time.
Initialize an array ans to store the number of flowers in full bloom for each person.
Iterate over the people array and use binary search to find the first and last flower in full bloom during each person's arrival time.
Calculate the number of flowers in full bloom for each person by subtracting the index of the first flower from the index of the last flower.
Return the ans array.

------------------------------Complexity------------------------------
Time complexity: O(nlogn), where n is the number of flowers. This is because we need to sort the start and end times of the flowers, 
and then perform a binary search for each person.

Space complexity: O(n), where n is the number of people. This is because we need to store the ans array.

------------------------------Code------------------------------
*/
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        // Sort the start and end times of the flowers in ascending order.
        for(int i = 0;i < flowers.length;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1]+1;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        // Iterate over the people's arrival times.
        for(int i = 0;i < people.length;i++){
            // Use a binary search to find the number of flowers that are in full bloom at that time.
            int before = check(start,people[i]);
            int after = check(end,people[i]);

            // The number of flowers in full bloom is the difference between the number of flowers that started blooming before the person arrived and the number of flowers that finished blooming before the person arrived.
            ans[i] = before - after;
        }

        return ans;
    }

    private int check(int[] nums, int target){
        int low = 0, high = nums.length;

        // Perform a binary search to find the first element in the array that is greater than or equal to the target.
        while(low < high){
            int mid = low + (high-low) / 2;

            if(nums[mid] <= target){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        // The number of elements that are greater than or equal to the target is the low pointer.
        return low;
    }
}
