class Solution {
    public int find(int ind,int[] nums,int[] dp){
        if(ind==0)return nums[ind];
        if(ind<0)return 0;
        if(dp[ind]!=-1)return dp[ind];

        int pick=nums[ind]+find(ind-2,nums,dp);
        int notPick=0+find(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return find(n-1,nums,dp);
    }
}