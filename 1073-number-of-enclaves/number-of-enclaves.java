class Solution {
    public void dfs(int r,int c,int[] dRow, int[] dCol,int[][] vis,int[][] grid){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nRow=r+dRow[i];
            int nCol=c+dCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                dfs(nRow,nCol,dRow,dCol,vis,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        int[][] vis=new int[n][m];

        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(0,i,dRow,dCol,vis,grid);
            }
            if(vis[n-1][i]==0 && grid[n-1][i]==1){
                dfs(n-1,i,dRow,dCol,vis,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,dRow,dCol,vis,grid);
            }
            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,dRow,dCol,vis,grid);
            }
        }
        int count=0;
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