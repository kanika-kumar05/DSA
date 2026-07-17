class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        int[][] vis=new int[n][m];

        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)countFresh++;
            }
        }
        int count=0;
        int time=0;
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            time=Math.max(t,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nRow=r+dRow[i];
                int nCol=c+dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                    q.add(new Pair(nRow,nCol,t+1));
                    vis[nRow][nCol]=2;
                    count++;
                }
            }
        }
        if(count!=countFresh)return -1;
        return time;
    }
}