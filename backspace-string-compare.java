/*
------------------Problem Statement------------------
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
------------------Example 1:------------------
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
------------------Example 2:------------------
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
------------------Example 3:------------------
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 
------------------Constraints:------------------
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

------------------Intuition------------------
The intuition for this problem is to simulate the backspace operation on both input strings and then compare the 
resulting strings to determine if they are equal.

------------------Approach------------------
Convert the input strings s and t into character arrays for easy processing.
Create a helper method processString to simulate the backspace operation and process each input string, 
returning the length of the processed string.
Process both input strings using the processString method to obtain the processed versions.
If the lengths of the processed strings are different, the original strings can't be equal, so return false.
Compare the processed strings character by character. If a mismatch is found, return false.
If no mismatches are found, the strings are equal after simulating the backspace operation, so return true.

------------------Complexity------------------
Time complexity: O(n) - Both strings are traversed once, where n is the total length of the strings s and t.
Space complexity: O(n) - In the worst case, if there are no backspaces, the entire string might be stored in the stack.

------------------Code------------------
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Convert input strings into character arrays for easy processing.
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Process both input strings and get the length of the processed strings.
        int k = processString(sChars);
        int p = processString(tChars);

        // If the lengths of the processed strings are different, the original strings can't be equal.
        if (k != p) return false;

        // Compare the processed strings character by character.
        for (int i = 0; i < k; i++) {
            if (sChars[i] != tChars[i]) 
                return false;
        }

        // If no mismatches are found, the strings are equal after simulating the backspace operation.
        return true;     
    }

    // Method to process the input string and simulate the backspace operation.
    private int processString(char[] chars) {
        int k = 0;// Index for where characters should be inserted after processing.
        for (char c : chars) {
            if (c != '#') {
                // If the character is not a backspace, add it to the processed string.
                chars[k++] = c;
            } else if (k > 0) {
               // If the character is a backspace and there are characters to backspace, erase the last character.
                k--;
            }
        }
        return k;// Return the length of the processed string.
    }
}
