class Pair{
    int row,col,dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        // calculate all zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                    dis[i][j]=0;
                } 
            }
        }
        
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;
            
            q.remove();
            for(int i=0;i<4;i++){
                int nRow=r+dRow[i];
                int nCol=c+dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && mat[nRow][nCol]==1){
                    q.add(new Pair(nRow,nCol,d+1));
                    vis[nRow][nCol]=1;
                    dis[nRow][nCol]=d+1;
                }
            }
        }
        return dis;
    }
}