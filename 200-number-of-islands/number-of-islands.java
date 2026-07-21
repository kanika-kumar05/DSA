class Solution {
    public void dfs(int i, int j,int[][] vis,char[][] grid,int[] dCol,int[] dRow){
        vis[i][j]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int k=0;k<4;k++){
            int nRow=i+dRow[k];
            int nCol=j+dCol[k];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]=='1'){
                dfs(nRow,nCol,vis,grid,dCol,dRow);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        int[]dRow={-1,0,1,0};
        int[]dCol={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(i,j,vis,grid,dCol,dRow);
                    count++;
                }
            }
        }
        return count;
    }
}