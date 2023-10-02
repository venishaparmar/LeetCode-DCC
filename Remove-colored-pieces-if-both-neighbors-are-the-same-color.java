/*
--------------Problem Statement--------------
There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. 
You are given a string colors of length n where colors[i] is the color of the ith piece.

Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.

Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. 
She is not allowed to remove pieces that are colored 'B'.
Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. 
He is not allowed to remove pieces that are colored 'A'.
Alice and Bob cannot remove pieces from the edge of the line.
If a player cannot make a move on their turn, that player loses and the other player wins.
Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.

-----------  Example 1:
Input: colors = "AAABABB"
Output: true
Explanation:
AAABABB -> AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.

Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.

------------- Example 2:
Input: colors = "AA"
Output: false
Explanation:
Alice has her turn first.
There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
Thus, Bob wins, so return false.

-------------- Example 3:
Input: colors = "ABBBBBBBAAA"
Output: false
Explanation:
ABBBBBBBAAA -> ABBBBBBBAA
Alice moves first.
Her only option is to remove the second to last 'A' from the right.

ABBBBBBBAA -> ABBBBBBAA
Next is Bob's turn.
He has many options for which 'B' piece to remove. He can pick any.

On Alice's second turn, she has no more pieces that she can remove.
Thus, Bob wins, so return false.

--------------Intuition-----------------
The key to solving this problem is to realize that Alice and Bob can only make moves on pieces that are surrounded by two pieces of the same color. 
This means that if Alice or Bob can make a move on a piece, then the other player cannot make a move on that piece.

-----------------Approach---------------
To solve this problem, we can iterate through the colors string, excluding the edge pieces. 
For each piece, we check if Alice or Bob can make a move on that piece. 
If Alice can make a move, we increment her score. If Bob can make a move, we increment his score.

After iterating through the entire string, we compare Alice's score to Bob's score. 
If Alice's score is greater than Bob's score, then Alice wins. Otherwise, Bob wins.

------------------Complexity------------
Time complexity: O(n), where n is the length of the colors string. This is because we iterate through the entire string once.

Space complexity: O(1), since we only use two variables to store Alice's and Bob's scores.

------------------Code-------------------
*/

class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceScore = 0;
        int bobScore = 0;

        //Iterate throught the colors, excluding the edge pieces
        for(int i = 1; i < colors.length() - 1; i++){
            char currentColor = colors.charAt(i);
            char prevColor = colors.charAt(i - 1);
            char nextColor = colors.charAt(i + 1);

            //Check if Alice can make a move here
            if(currentColor == 'A' && prevColor == 'A' && nextColor == 'A')
            {
                aliceScore++; // Alice can remove 'A'
            }

            //Check if Bob can make a move here
            else if(currentColor == 'B' && prevColor == 'B' && nextColor == 'B')
            {
                bobScore++; // Bob can remove 'B'
            }
        }
        return aliceScore > bobScore; // determines the winner based on the scores.
    }
}
