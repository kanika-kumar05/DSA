class Solution {
    public void dfs(int i,int j,int[][] vis,int[] dRow,int[] dCol,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int r=i+dRow[k];
            int c=j+dCol[k];
            if(r>=0 && r<n && c>=0 && c<m && vis[r][c]==0 && grid[r][c]==1){
                dfs(r,c,vis,dRow,dCol,grid);
            }
        }
    } 
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        int[][] vis=new int[n][m];
        int count=0;
        //first and last row
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,vis,dRow,dCol,grid);
            }
            if(vis[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j,vis,dRow,dCol,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,vis,dRow,dCol,grid);
            }
            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,vis,dRow,dCol,grid);
            }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j]==0 && grid[i][j]==1){
                count++;
            }
        }
       }
       return count;
    }
}