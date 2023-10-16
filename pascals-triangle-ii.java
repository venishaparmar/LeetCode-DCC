/*
---------------------------Problem Statement---------------------------
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

---------------------------Example 1:---------------------------
Input: rowIndex = 3
Output: [1,3,3,1]
---------------------------Example 2:---------------------------
Input: rowIndex = 0
Output: [1]

---------------------------Example 3:---------------------------
Input: rowIndex = 1
Output: [1,1]
 
---------------------------Constraints:---------------------------
0 <= rowIndex <= 33

---------------------------COde---------------------------
*/
class Solution {
    public List<Integer> getRow(int row) {
        List<Integer> list = new ArrayList<>();
        long start=1;
        list.add((int)start);
        for(int i=0;i<row;i++)
        {
            start*=(row-i);
            start/=(i+1);
            list.add((int)start);
        }
        return list;
    }
}
