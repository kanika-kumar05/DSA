class Solution {
    public void dfs(int sr, int sc,int[][] image, int[][] ans, int color, int init ){
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int r=sr+dRow[i];
            int c=sc+dCol[i];
            if(r>=0 && r<n && c>=0 && c<m && ans[r][c]!=color && image[r][c]==init){
                dfs(r,c,image,ans,color,init);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int init=image[sr][sc];
        int[][] ans=image;
        dfs(sr,sc,image,ans,color,init);
        return ans;
    }
}