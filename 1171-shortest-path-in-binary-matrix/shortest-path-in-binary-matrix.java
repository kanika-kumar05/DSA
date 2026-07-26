class tuple{
    int row,col,dist;
    tuple(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;

        Queue<tuple> q=new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        q.add(new tuple(0,0,1));
        int[] dr={-1,-1,-1,0,0,1,1,1};
        int[] dc={-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int dis=q.peek().dist;
            q.remove();
            if(r==n-1 && c==n-1)return dis;

            for(int i=0;i<8;i++){
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==0 && dis+1<dist[newr][newc]){
                    dist[newr][newc]=dis+1;
                    q.add(new tuple(newr,newc,dist[newr][newc]));
                }
            }   
        }
        return -1;

    }
}