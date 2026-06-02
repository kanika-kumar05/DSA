class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }
    public static void dfs(int city,boolean[] vis, int[][] isConnected){
        vis[city]=true;

        for(int i=0;i<isConnected.length;i++){
            if(isConnected[city][i]==1 && vis[i]==false){
                dfs(i,vis,isConnected);
            }
        }
    }
}