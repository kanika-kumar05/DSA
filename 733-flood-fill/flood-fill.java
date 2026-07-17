class Pair{
    int row,col,tm;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sr,sc));

        int orig=image[sr][sc];
        vis[sr][sc]=1;
        image[sr][sc]=color;
        
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int nRow=r+dRow[i];
                int nCol=c+dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol]==orig && vis[nRow][nCol]==0){
                    q.add(new Pair(nRow,nCol));
                    vis[nRow][nCol]=1;
                    image[nRow][nCol]=color;
                }
            }
        }
        return image;

    }
}