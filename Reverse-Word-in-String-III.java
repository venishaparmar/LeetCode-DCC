/*
----------Problem Statement
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"

-------------------Intuition-----------------------------
The intuition behind this solution is that we can reverse the order of characters in each word within a sentence 
by reversing the order of characters in each substring of the sentence that is delimited by spaces.

-----------------Approach---------------------
The approach is to start from the beginning of the string and iterate over it one character at a time. 
For each character, we check if it is a space. If it is not a space, then we add it to the current substring. 
If it is a space, then we reverse the order of characters in the current substring and add it to the output string. 
We then repeat this process until we reach the end of the string.

------------------Complexity---------------
Time complexity: O(n), where n is the length of the input string. 
This is because we need to visit each character in the string once.

Space complexity: O(n), where n is the length of the input string. 
This is because we need to maintain the output string, which can be up to twice the length of the input string.


---------Code----------
*/
class Solution {
    public String reverseWords(String s) {
        char arr[] = s.toCharArray();
        int start=0;
        int end=0;

        while(start < arr.length){
            while( end < arr.length && arr[end] != ' '){
                end++;
            }
            reverse(start, end-1, arr);
            start  = end+1;
            end = start;
        }
        return new String(arr);
    }
    private void reverse(int l,  int  r, char  arr[]){
        while(l<r){
            char temp=arr[l];
            arr[l++]=arr[r];
            arr[r--]=temp;
        }
    }
}
