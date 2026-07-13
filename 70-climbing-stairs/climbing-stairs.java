class Solution {
    public static int count(int n,int[] dp){
        if(n==1 || n==0)return 1;
        if(dp[n]!=-1)return dp[n];
        dp[n]=count(n-1,dp)+count(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}