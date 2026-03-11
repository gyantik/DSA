// LeetCode: sumOfSequence 
// Date: 11-03-2026 
 
class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return  solve(nums,0,0,k);
    }
   public int solve(int[] nums,int idx,int sum,int k){
        if(idx==nums.length){
           if(sum==k){
            return 1;
           }
           return 0;
        }
        int take = solve(nums,idx+1,sum+nums[idx],k);
        int notTake=solve(nums,idx+1,sum,k);
        return take + notTake;
    }
}