class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,s,rev,dp);
    }
    public static int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i==s1.length() || j==s2.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(
            solve(i+1,j,s1,s2,dp),
            solve(i,j+1,s1,s2,dp)
        );
    }
}