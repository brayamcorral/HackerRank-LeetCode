class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int[][] dp = new int[1001][1001];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return helper(nums, multipliers, 0, nums.length-1, 0, dp);
           
    }
    
    int helper(int[] nums, int[] multipliers, int numsStart,int numsEnd, int multIndex, int[][] dp){
        
        if(multIndex > multipliers.length-1)
            return 0;
        
        if(dp[multIndex][numsStart] != -1) 
            return dp[multIndex][numsStart];
        
        int left = multipliers[multIndex] * nums[numsStart] + helper(nums, multipliers, numsStart+1, numsEnd, multIndex+1, dp);
        int right = multipliers[multIndex] * nums[numsEnd] + helper(nums, multipliers, numsStart, numsEnd-1, multIndex+1, dp);
        int answer = Math.max(left, right);
        dp[multIndex][numsStart] = answer;
        return answer;
             
    }
}
