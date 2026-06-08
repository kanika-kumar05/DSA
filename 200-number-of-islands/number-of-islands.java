class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public static void bfs(int r,int c,char[][]grid, int[][] vis,int[] dRow, int[] dCol){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            int ro=q.peek().row;
            int co=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                    int nRow=ro+dRow[i];
                    int nCol=co+dCol[i];
                    if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]=='1' &&
                        vis[nRow][nCol]==0){
                            vis[nRow][nCol]=1;
                            q.add(new Pair(nRow,nCol));
                        }
                }
            }
        }

    

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,grid,vis,dRow,dCol);
                }
            }
        }
        return count;
    }
}