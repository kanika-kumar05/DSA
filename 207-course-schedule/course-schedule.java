class Solution {
    public boolean dfs(int node,int[]vis,int[] pathVis,List<List<Integer>> adj){
        vis[node]=1;
        pathVis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,pathVis,adj)==true)return true;
            }
            else if(pathVis[it]==1)return true;
        }
        pathVis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] vis=new int[numCourses];
        int[] pathVis=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathVis,adj)==true)return false;
            }
        }
        return true;
    }
}