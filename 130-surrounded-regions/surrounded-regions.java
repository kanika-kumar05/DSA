class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                vis[0][i]=1;
                q.add(new Pair(0,i));
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O'){
                vis[i][m-1]=1;
                q.add(new Pair(i,m-1));
            }
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O'){
                vis[n-1][i]=1;
                q.add(new Pair(n-1,i));
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                vis[i][0]=1;
                q.add(new Pair(i,0));
            }
        }
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nRow=r+dRow[i];
                int nCol=c+dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && board[nRow][nCol]=='O' && vis[nRow][nCol]==0){
                    vis[nRow][nCol]=1;
                    q.add(new Pair(nRow,nCol));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}