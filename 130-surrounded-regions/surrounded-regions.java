class Solution {
    public void dfs(int i,int j,int[][] vis,int[] dRow,int[] dCol,char[][] board){
        int n=board.length;
        int m=board[0].length;
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int r=i+dRow[k];
            int c=j+dCol[k];
            if(r>=0 && r<n && c>=0 && c<m && vis[r][c]==0 && board[r][c]=='O'){
                dfs(r,c,vis,dRow,dCol,board);
            }
        }
    }    
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        //first and last row
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,vis,dRow,dCol,board);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis,dRow,dCol,board);
            }
       }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
            dfs(i,0,vis,dRow,dCol,board);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,dRow,dCol,board);
            }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j]==0 && board[i][j]=='O'){
                board[i][j]='X';
            }
        }
       }
        
    }
}