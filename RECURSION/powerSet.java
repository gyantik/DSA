// LeetCode: powerSet 
// Date: 10-03-2026 
 
class Solution { 
    // User function Template for Java

class Solution {

    // List to store all subsequences
    List<String> result = new ArrayList<>();

    // Main function that will be called
    public List<String> AllPossibleStrings(String s) {

        // Empty string to build subsequences
        String curr = "";

        // Start recursion from index 0
        solve(s, curr, 0);

        // Sort the final list lexicographically
        Collections.sort(result);

        // Return all subsequences
        return result;
    }

    // Recursive function to generate subsequences
    public void solve(String s, String curr, int idx){

        // Base case: if index reaches end of string
        if(idx == s.length()){

            // Ignore empty subsequence
            if(curr != ""){
                result.add(curr);   // Add current subsequence to result
            }

            return; // Stop recursion
        }

        // Choice 1: include the current character in subsequence
        solve(s, curr + s.charAt(idx), idx + 1);

        // Choice 2: exclude the current character
        solve(s, curr, idx + 1);

        return; // return after both recursive calls
    }
}
} 
