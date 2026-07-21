class Solution {
    public boolean dfs(int node,int col,int[][] graph,int[] color){
        color[node]=col;
        for(Integer it:graph[node]){
            if(color[it]==-1){
                if(dfs(it,1-col,graph,color)==false)return false;
            }
            else if(color[node]==color[it])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int[]color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,graph,color)==false)return false;
            }
        }
        return true;
    }
}